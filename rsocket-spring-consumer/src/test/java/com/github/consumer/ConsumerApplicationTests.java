package com.github.consumer;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConsumerApplicationTests {


    @Autowired
    ApplicationContext context;
    @LocalServerPort
    private int port;

    private WebTestClient webClient;

    @BeforeEach
    public void setup() {
        this.webClient = WebTestClient.bindToApplicationContext(context)
                .configureClient().baseUrl("http://localhost:"+port).build();
    }

    @Test
    public void hello() {
        webClient.get()
                .uri("/greet/ABC")
                .exchange()
                .expectStatus().is2xxSuccessful();
    }

}
