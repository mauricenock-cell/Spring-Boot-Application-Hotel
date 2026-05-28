package edu.wgu.d387_sample_code;//package com.example.sampleapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class SampleApplication {
    static ExecutorService messageExecutor = newFixedThreadPool(5);
    static CompletableFuture<String> msg1, msg2;

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
        Properties properties = new Properties();
        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);
                msg1 = CompletableFuture.supplyAsync(() -> properties.getProperty("welcome"));

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            Thread.sleep((1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);
                msg2 = CompletableFuture.supplyAsync(() -> properties.getProperty("welcome"));

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    public static String getMsg1() throws ExecutionException, InterruptedException {

        return msg1.get();
    }

    public static String getMsg2() throws ExecutionException, InterruptedException {

        return msg2.get();
    }

}

