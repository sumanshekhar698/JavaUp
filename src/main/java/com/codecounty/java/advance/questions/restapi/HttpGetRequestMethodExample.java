package com.codecounty.java.advance.questions.restapi;

import lombok.extern.java.Log;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpStatus;

import java.io.IOException;
import java.util.logging.Logger;



/**
 * This example demonstrates the use of {@link HttpGet} request method.
 * @author Ramesh Fadatare
 */

@Log
public class HttpGetRequestMethodExample {
	static Logger log = Logger.getLogger(HttpGetRequestMethodExample.class.getName());

    public static void main(String...args) throws IOException {
//        HttpClient httpClient = HttpClientBuilder.create().build();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            //HTTP GET method
            HttpGet httpGet = new HttpGet("https://dummyapi.online/api/movies");
            System.out.println("Executing request " + httpGet.getRequestUri());



            // Create a custom response handler
//            ResponseHandler <String> responseHandler = response -> {
//                int status = response.getStatusLine().getStatusCode();
//                if (status >= 200 && status < 300) {
//                    HttpEntity entity = response.getEntity();
//                    return entity != null ? EntityUtils.toString(entity) : null;
//                } else {
//                    throw new ClientProtocolException("Unexpected response status: " + status);
//                }
//            };


            ClassicHttpResponse classicHttpResponse = httpClient.execute(httpGet, response -> {
//                assertThat(response.getCode()).isEqualTo(HttpStatus.SC_OK);
                return response;
            });

//            ClassicHttpResponse classicHttpResponse = httpClient.execute(httpGet, new BasicHttpClientResponseHandler()
//            );

            String response = httpClient.execute(httpGet, new BasicHttpClientResponseHandler());
            log.info("Response -> "+ response);


//            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(classicHttpResponse);
        }
    }
}