package com.anshika.server;

import com.anshika.StudentResponse;
import com.anshika.StudentServiceGrpc;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@GRpcService
public class Server extends StudentServiceGrpc.StudentServiceImplBase  {

    Logger logger = LoggerFactory.getLogger(Server.class);
    public void getStudent(com.anshika.StudentRequest request,
                           io.grpc.stub.StreamObserver<com.anshika.StudentResponse> responseObserver) {

        logger.info("got request = "+request.getId());
        StudentResponse studentResponse = StudentResponse.newBuilder().setAge(10).setName("Anshika").build();

        responseObserver.onNext(studentResponse);
        responseObserver.onCompleted();
    }

}
