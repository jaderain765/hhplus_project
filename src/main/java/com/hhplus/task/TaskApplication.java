package com.hhplus.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableJpaAuditing
@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

}

@Controller
class TestController{

	@Autowired
	private Environment environment;

	@ResponseBody
	@GetMapping
	public String test(){
		String result = "설정 정보 : " + String.join("\n", environment.getActiveProfiles());
		System.out.println(result);
		return result;
	}
}
