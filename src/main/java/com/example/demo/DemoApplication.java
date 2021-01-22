package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Приложение будет запускаться как spring boot
//Для всего что у нас есть в файле зависимостей pom.xml нужно подключить авто конфигурацию
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
