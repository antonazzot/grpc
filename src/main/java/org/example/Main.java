package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

import org.example.service.GreetingServiceImp;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server =  ServerBuilder.forPort(9797).addService(new GreetingServiceImp()).build();
        server.start();
        server.awaitTermination();
    }
}