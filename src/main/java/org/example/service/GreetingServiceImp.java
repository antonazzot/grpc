package org.example.service;

import io.grpc.stub.StreamObserver;

import com.example.GrpsFlow.GeneratingService;
import com.example.GrpsFlow.GreetingServiceGrpc;

public class GreetingServiceImp extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GeneratingService.HelloRequest request,
                         StreamObserver<GeneratingService.HelloResponse> responseObserver) {
        System.out.println(request);
        GeneratingService.HelloResponse response = GeneratingService.HelloResponse.newBuilder()
                .setAnswer(true)
                .setGirlName(request.getGirlsList().stream().findAny().orElse("Anton"))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
