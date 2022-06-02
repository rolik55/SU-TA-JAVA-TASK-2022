package com.assignment.su22;

import com.assignment.su22.game.impl.HummingbirdGameImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootApplication
public class HummingbirdApplication {

	public static void main(String[] args) throws IOException {
		Resource map = new ClassPathResource("hummingbird_map.txt");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.assignment.su22");
		context.refresh();
		HummingbirdGameImpl game = context.getBean(HummingbirdGameImpl.class);
		game.hummingbirdGame(map);
		context.close();
	}
}
