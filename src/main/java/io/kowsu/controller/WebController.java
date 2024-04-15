package io.kowsu.controller;

import io.kowsu.model.Request;
import io.kowsu.service.IWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    private IWebService webService;

    @GetMapping("/greet")
    public String greet() {
        return "Hello world";
    }

    @PostMapping("/postRequest")
    public String postRequest(@RequestBody Request request) {
        return request.getHost();
    }


    @PutMapping("/putRequest")
    public String putRequest(@RequestBody Request request) {
        return request.getHost();
    }

    @DeleteMapping("/deleteRequest/{id}")
    public String deleteRequest(@PathVariable("id") String requestId) {
        return requestId;
    }

    @GetMapping("/getReqParam")
    public String getRequestWithQueryParams(@RequestParam("param") String param) {
        return param;
    }

    @GetMapping("/stockPrice")
    public String getStockPrice(@RequestParam("stock") String stock) {
        return String.valueOf(webService.stockPrice(stock));
    }

}
