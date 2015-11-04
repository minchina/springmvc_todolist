package org.tw.todo.utils;

import org.junit.Test;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;

public class TestRemoteApi {

    @Test
    public void shouldCallRemoteApiSuccess() throws IOException {
        ClientResource resource = new ClientResource("http://localhost:8080//pricing/calculate");
        Representation representation = resource.get();
        String text = representation.getText();
        System.out.println(text);


    }
}
