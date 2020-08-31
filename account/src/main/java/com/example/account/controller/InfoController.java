package com.example.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

@RestController
@RequestMapping("")
public class InfoController {

    @Autowired
    Environment environment;

    @GetMapping
    public Mono<Map<String, String>> index() throws UnknownHostException {
        return info();
    }

    @GetMapping("/info")
    public Mono<Map<String, String>> info() throws UnknownHostException {

        InetAddress localhost = InetAddress.getLocalHost();

        Map<String, String> response = Map.of(
                "port", environment.getProperty("server.port"),
                "hostAddress", localhost.getHostAddress(),
                "hostName", localhost.getHostName(),
                "containerName", environment.getProperty("app.container-name"));

        return Mono.just(response);
    }
}
