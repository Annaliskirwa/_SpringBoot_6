package com.example.demo;

import com.example.demo.Entities.HelloWorldBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@SpringBootApplication
@RestController
public class SpringMicroservices extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringMicroservices.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservices.class, args);
	}

//	@Bean
//	public TimedAspect timedAspect(MeterRegistry registry){
//		return new TimedAspect(registry);
//	}
//
//	@Timed(value = "greeting.time", description = "The time taken to return the greeting method")
//	public String sayHello(){
//		return "Saying hello from this side";}

	@GetMapping("/working")
	public String sayhello(){
		return "Checking if prometheus is working";
	}
	@GetMapping(path = "hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Returning hello world from a bean");
	}
	@GetMapping(path = "hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
		return new HelloWorldBean(String.format("Returning hello world from a bean, %s", name));
	}
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language", required = false)Locale locale){
		return "Hello World";
	}
}

