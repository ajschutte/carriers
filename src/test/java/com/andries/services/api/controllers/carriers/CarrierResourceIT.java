package com.andries.services.api.controllers.carriers;

import com.andries.services.api.resources.carriers.Carrier;
import com.andries.services.api.resources.carriers.Driver;
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

    private static final int N_THREADS = 10;

    private static final int LATCH_TIMEOUT = 30;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient();
        //client.property(ClientProperties.CONNECT_TIMEOUT, 100);
        //client.property(ClientProperties.READ_TIMEOUT, 500);
        this.tut = this.client.target("http://localhost:8080/carriers/api");
        mapper =new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    @Test
    public void fetchCarrierByResourceLocationExistingCarrierMatchingCarrierReturned() throws Exception {

        for (int i = 1; i < 5; i++) {

            //Long carrierNextId = fetchNextCarrierId();
            //Long driverNextId = fetchNextDriverId();
            Carrier carrier = createAndFetchCarrier();
            Driver driver = createAndFetchDriver();
            Long carrierCurrId = fetchCurrentCarrierId();
            Long driverCurrId = fetchCurrentDriverId();


            //System.out.println("\n");
            //System.out.println("nextVal() on CARRIER SEQ VAL: " + carrierNextId);
            //System.out.println("nextVal() on DRIVER SEQ VAL: " + driverNextId);
            System.out.println("\n");
            System.out.println("CREATED CARRIER: " + i + " with ID: " + carrier.getId());
            System.out.println("CREATED DRIVER : " + i + " with ID: " + driver.getId());
            System.out.println("\n");
            System.out.println("currVal() on CARRIER SEQ VAL: " + carrierCurrId);
            System.out.println("currVal() on DRIVER SEQ VAL: " + driverCurrId);
            System.out.println("\n");

        }

    }

    @Test
    public void createAndFetchCarrierManyThreads() throws Exception {

        int nThreads = N_THREADS;
        CountDownLatch latch = new CountDownLatch(nThreads);
        Runnable run = () -> {
            try {
                fetchCarrierByResourceLocationExistingCarrierMatchingCarrierReturned();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                latch.countDown();
            }
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

    private Carrier createAndFetchCarrier() {

        WebTarget target = tut.path("carrier/" + UUID.randomUUID().toString());

        Response response = target.request(MediaType.APPLICATION_JSON).get();
        Carrier carrier = response.readEntity(Carrier.class);
        assertEquals(response.getStatus(), 200);
        return carrier;

    }

    private Long fetchCurrentCarrierId() {

        WebTarget target = tut.path("carrier-id/currentval");

        Response response = target.request(MediaType.APPLICATION_JSON).get();
        return response.readEntity(Long.class);

    }

    private Long fetchNextCarrierId() {

        WebTarget target = tut.path("carrier-id/nextval");

        Response response = target.request(MediaType.APPLICATION_JSON).get();
        return response.readEntity(Long.class);

    }

    private Long fetchCurrentDriverId() {

        WebTarget target = tut.path("driver-id/currentval");

        Response response = target.request(MediaType.APPLICATION_JSON).get();
        return response.readEntity(Long.class);

    }

    private Long fetchNextDriverId() {

        WebTarget target = tut.path("driver-id/nextval");

        Response response = target.request(MediaType.APPLICATION_JSON).get();
        return response.readEntity(Long.class);

    }

    private Driver createAndFetchDriver() {

        WebTarget target = tut.path("driver/" + UUID.randomUUID().toString());

        Response response = target.request(MediaType.APPLICATION_JSON).get();
        Driver driver = response.readEntity(Driver.class);
        assertEquals(response.getStatus(), 200);
        return driver;

    }

}
