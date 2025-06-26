package lucas.dev.itau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lucas.dev.itau.controller.TransactionController;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class ItauApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ItauApplication.class, args);

		Thread.sleep(3000);
		demoHttpClientUsage();
	}

	private static void demoHttpClientUsage() throws Exception {
		HttpClient client = HttpClient.newHttpClient();

		String json = "{\"valor\": 100.0}";

		HttpRequest postRequest = HttpRequest.newBuilder()
			.uri(URI.create("http://localhost:8080/transactions"))
			.header("Content-Type", "application/json")
			.POST(HttpRequest.BodyPublishers.ofString(json))
			.build();

		HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
		System.out.println("POST response: " + postResponse.body());

		HttpRequest getRequest = HttpRequest.newBuilder()
			.uri(URI.create("http://localhost:8080/transactions"))
			.GET()
			.build();

		HttpResponse<String> getResponse = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
		System.out.println("GET response: " + getResponse.body());
	}

}
