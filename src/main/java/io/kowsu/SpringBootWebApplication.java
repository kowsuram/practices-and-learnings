package io.kowsu;

import io.kowsu.feign.TodoFeignClient;
import io.kowsu.kafka.MessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@AllArgsConstructor
//@EnableFeignClients
//@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class SpringBootWebApplication implements CommandLineRunner {

	private final MessageProducer messageProducer;
	private final TodoFeignClient todoFeignClient;

	@Override
	public void run(String... args) throws Exception {
		messageProducer.sendMessage("my-topic", "Hello world!!");
		System.out.println("#####################################");
		System.out.println(todoFeignClient.getTodos());
		System.out.println("#####################################");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}
