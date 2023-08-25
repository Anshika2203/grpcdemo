package com.anshika.client;

import com.anshika.StudentRequest;
import com.anshika.StudentResponse;
import com.anshika.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Client {
    static Logger logger = LoggerFactory.getLogger(Client.class);
    public static void main(String[] args) {

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);

        StudentResponse studentResponse = blockingStub.getStudent(StudentRequest.newBuilder().setId(1).build());

        logger.info("response ="+ studentResponse.getName()+" "+studentResponse.getAge());

    }
}
