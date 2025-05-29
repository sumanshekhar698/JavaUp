package dev.codecounty.java.questions.interview.restapi;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.EntityUtils;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClientBuilder;


public
class RetryHttpClient {

    private static final int MAX_RETRIES = 3;
    private static final int RETRY_DELAY_MS = 1000;

    public static void main(String[] args) {

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://dummyapi.online/api/movies");

        int retries = 0;
        while (retries < MAX_RETRIES) {
            try {
                HttpResponse response = httpClient.execute(request);

                // Print status code
//                System.out.println("Response status code: " + response.getStatusLine().getStatusCode());

                // Print response headers
                response.headerIterator().forEachRemaining(header -> System.out.println(header.getName() + ": " + header.getValue()));

                // Print response body (if available)
//                if (response.get != null) {
//                    String responseBody = EntityUtils.toString(response.getEntity());
//                    System.out.println("Response body: " + responseBody);
//                }
                // Handle successful response
                break;
            } catch (Exception e) {
                // Handle error, potentially retry
                retries++;
                if (retries < MAX_RETRIES) {
                    System.out.println("Retrying request in " + RETRY_DELAY_MS + "ms...");
                    try {
                        Thread.sleep(RETRY_DELAY_MS);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }

        if (retries == MAX_RETRIES) {
            System.out.println("Maximum retries reached.");
        }
    }
}