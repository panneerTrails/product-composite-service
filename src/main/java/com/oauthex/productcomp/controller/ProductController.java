package com.oauthex.productcomp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ProductComp")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${url.productServiceURL}")
    private String productServiceURL;


    @GetMapping("/status")
    public String getStatus() {
        LOGGER.info("Hi Product Team");
        return "Hi Product Team";
    }

    @GetMapping("/productStatus")
    public String getProductStatus() {
        LOGGER.info("Hi Product Status Team");
        LOGGER.info("productServiceURL:::" + productServiceURL);
        String result  =  restTemplate.getForObject(productServiceURL, String.class);
        LOGGER.info("Result:::" + result);
        return result;
    }
}
