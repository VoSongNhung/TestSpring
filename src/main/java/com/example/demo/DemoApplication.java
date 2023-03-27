package com.example.demo;

import com.example.demo.Entity.Infomation;
import com.example.demo.Responsitory.InformationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
		private InformationRespository informationRespository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ArrayList<Infomation> arrayList = (ArrayList<Infomation>) informationRespository.findAll();
		for (Infomation i: arrayList) {
			System.out.println("ID:"+i.getId()+" Name:"+i.getFirstname()+" "+i.getLastname()+" live in "+i.getAddress());
		}
	}

}
