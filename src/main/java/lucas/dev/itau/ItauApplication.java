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

		double[] values = {100.0, 50.5, 200.75, 10.0, 300.0, 5.25, 80.0, 150.0, 60.0, 90.9};
		for (double value : values) {
			String json = String.format("{\"valor\": %.2f}", value);
			HttpRequest postRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/transactions"))
				.header("Content-Type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.build();
			HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
			System.out.println("POST response: " + postResponse.body());
		}

		HttpRequest statisticsRequest = HttpRequest.newBuilder()
			.uri(URI.create("http://localhost:8080/statistics"))
			.GET()
			.build();
		HttpResponse<String> statisticsResponse = client.send(statisticsRequest, HttpResponse.BodyHandlers.ofString());
		System.out.println("STATISTICS response: " + statisticsResponse.body());
	}

}
