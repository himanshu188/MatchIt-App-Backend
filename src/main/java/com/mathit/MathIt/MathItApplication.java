package com.mathit.MathIt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MathItApplication {

//	@Autowired S3Storage s3Storage;
	public static void main(String[] args) {
		SpringApplication.run(MathItApplication.class, args);
	}

}
