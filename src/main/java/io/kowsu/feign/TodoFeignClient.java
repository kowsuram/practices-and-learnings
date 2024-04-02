package io.kowsu.feign;

/*
    @created March/26/2024 - 9:25 PM
    @project spring-boot-web
    @author k.ramanjineyulu
*/

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "todos", path = "https://jsonplaceholder.typicode.com/")
public interface TodoFeignClient {

    @GetMapping(value = "todos", produces = "application/json", name = "getAllTodos")
    String getTodos();
}
