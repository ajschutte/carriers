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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Andries on 5/10/16.
 */
public class CarrierResourceIT {

    private Client client;
    private WebTarget tut;
    ObjectMapper mapper;

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
    public void fetchCarrierByResourceLocation_existingCarrier_matchingCarrierReturned() throws Exception {

        WebTarget target = tut.path(UUID.randomUUID().toString());
        System.out.println("REQUEST URL: " + target.getUri().toString());

        Response response = target.request(MediaType.APPLICATION_JSON).get();
        assertEquals(response.getStatus(), 200);
        String data = response.readEntity(String.class);
        System.out.println("RESPONSE: " + data);
        assertNotNull(data);

    }

}
