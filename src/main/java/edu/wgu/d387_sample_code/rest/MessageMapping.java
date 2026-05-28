package edu.wgu.d387_sample_code.rest;
import edu.wgu.d387_sample_code.SampleApplication;
//import edu.wgu.d387_sample_code.Threads;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//import static edu.wgu.d387_sample_code.D387SampleCodeApplication.getMessages;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MessageMapping {

   SampleApplication sampleApplication;

    @RequestMapping(path = "/message1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String showMessage1() throws ExecutionException, InterruptedException {

        String finalMessage = sampleApplication.getMsg1();

        return finalMessage;
    }

    @RequestMapping(path = "/message2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String showMessage2() throws ExecutionException, InterruptedException {

        String finalMessage = sampleApplication.getMsg2();
        return finalMessage;
    }
}
