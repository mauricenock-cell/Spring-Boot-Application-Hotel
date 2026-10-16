package edu.wgu.d387_sample_code;//package com.example.sampleapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Threads {
    static ExecutorService messageExecutor = newFixedThreadPool(5);
    static CompletableFuture<String> msg1, msg2;
    public String[] messages = new String[2];
    public Threads() {

        Properties properties = new Properties();

        msg1 = CompletableFuture.supplyAsync(() -> {

            try {

                InputStream stream = new ClassPathResource("translation_en_US.properties").getInputStream();
                properties.load(stream);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return properties.getProperty("welcome");

        }, messageExecutor);

        msg2 = CompletableFuture.supplyAsync(() -> {

            try {

                InputStream stream = new ClassPathResource("translation_fr_CA.properties").getInputStream();
                properties.load(stream);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return properties.getProperty("welcome");

        }, messageExecutor);

        try {

            messages[0] = msg1.get();
            messages[1] = msg2.get();

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

