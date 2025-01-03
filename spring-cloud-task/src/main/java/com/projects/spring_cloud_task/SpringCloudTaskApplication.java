package com.projects.spring_cloud_task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringCloudTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner () {
		return new HelloCommandLineRunner();
	}

	@BeforeTask
	public void beforeTask(TaskExecution taskExecution) {
		System.out.println("Before task");
		System.out.println("Start time: "  + taskExecution.getStartTime());
	}

	@AfterTask
	public void afterTask(TaskExecution taskExecution) {
		System.out.println("After task");
		System.out.println("Start time: " + taskExecution.getStartTime());
	}

	public static class HelloCommandLineRunner implements CommandLineRunner {
		@Override
		public void run(String... args) throws Exception {
			System.out.println("Hello from HelloCommandLineRunner class");
		}
	}
}
