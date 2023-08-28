package dev.nextstepadvisory.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController	// we will build up the new endpoint, so we have to annotate this first to declare it
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	} // when we solely run this piece of code, and go to localhost:32000 (the specified port), we will see the whitelabel error page, which is fine since we have no APIs to hit yet

	@GetMapping("/helloworld")	// create the new endpoint, which their address is localhost:32000/helloworld
	public String apiRoot() {
		return "Hello world";
	}

	// from now on, we will create the Java class, which we will seperate the information into 2 chunks of it; Movies and Reviews, which illustrated in another class.
}
