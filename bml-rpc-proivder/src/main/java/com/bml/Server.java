package com.bml;

import com.bml.registry.server.AbstractServer;
import com.bml.registry.server.jdkobject.DefaultObjectNettyServer;

public class Server {

    public static void main(String[] args) {
        AbstractServer server = new DefaultObjectNettyServer(3000);

        server.star();
    }
}
