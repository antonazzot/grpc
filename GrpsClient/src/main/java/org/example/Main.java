package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.List;

import com.example.GrpsFlow.GeneratingService;
import com.example.GrpsFlow.GreetingServiceGrpc;

public class Main {
    public static void main(String[] args) {
        ManagedChannel channel =  ManagedChannelBuilder
                .forTarget("localhost:9797")
                .usePlaintext()
                .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        GeneratingService.HelloRequest request = GeneratingService.HelloRequest.newBuilder()
                .setAge(12)
                .setName("Sisky")
                .addAllGirls(List.of("Syka1", "Syla2"))
                .build();

        GeneratingService.HelloResponse helloResponse = stub.greeting(request);
        System.out.println(helloResponse);
        channel.shutdownNow();

    }
}