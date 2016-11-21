package com.andries.services.api.controllers.carriers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Created by Andries on 5/10/16.
 */
public class CarrierResourceIT {

    private Client client;
    private WebTarget tut;
    ObjectMapper mapper;

    private static final int N_THREADS = 20;

    private static final int LATCH_TIMEOUT = 30;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient();
        //client.property(ClientProperties.CONNECT_TIMEOUT, 100);
        //client.property(ClientProperties.READ_TIMEOUT, 500);
        this.tut = this.client.target("http://localhost:8080/carriers/api/carrier");
        mapper =new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    @Test
    public void fetchCarrierByResourceLocationExistingCarrierMatchingCarrierReturned() throws Exception {

        String data = createAndFetchCarrier();
        System.out.println("RESPONSE: " + data);
        assertNotNull(data);

    }

    @Test
    public void createAndFetchCarrierManyThreads() throws InterruptedException {

        int nThreads = N_THREADS;
        CountDownLatch latch = new CountDownLatch(nThreads);
        Runnable run = () -> {
            String data = createAndFetchCarrier();
            assertNotNull(data);
            System.out.println("Request OK, Response: " + data);
            latch.countDown();
        };
        ExecutorService tp = Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < nThreads; i++) {
            long start = System.currentTimeMillis();
            tp.submit(run);
            System.out.println("-- took: " + (System.currentTimeMillis() - start) + " millisecs to submit task to executor...");
        }
        boolean allOK = latch.await(LATCH_TIMEOUT, TimeUnit.SECONDS);

        if (!allOK) {
            fail("Latch timed out before all threads were done..");
        }
        else {
            System.out.println("All requests OK..");
        }
    }

    private String createAndFetchCarrier() {

        WebTarget target = tut.path(UUID.randomUUID().toString());

        Response response = target.request(MediaType.APPLICATION_JSON).get();
        assertEquals(response.getStatus(), 200);
        return response.readEntity(String.class);

    }

}
