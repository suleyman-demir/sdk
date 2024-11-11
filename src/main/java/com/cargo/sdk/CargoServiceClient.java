package com.cargo.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Arrays;

/**
 * Client for interacting with the Cargo microservice.
 * Provides methods to fetch, add, and update cargo details via HTTP requests.
 */
public class CargoServiceClient {

    private final String baseUrl;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    /**
     * Constructs a CargoServiceClient with the specified base URL.
     *
     * @param baseUrl the base URL of the Cargo microservice
     */
    public CargoServiceClient(String baseUrl) {
        this.baseUrl = baseUrl;
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Retrieves a list of all cargos.
     *
     * @return a list of Cargo objects
     * @throws Exception if an error occurs while fetching the cargos
     */
    public List<Cargo> getAllCargos() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/cargos"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request,
                HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to get cargos: " + response.statusCode());
        }

        return Arrays.asList(objectMapper.readValue(response.body(), Cargo[].class));
    }

    /**
     * Retrieves a specific cargo by its ID.
     *
     * @param id the ID of the cargo to retrieve
     * @return the Cargo object with the specified ID
     * @throws Exception if an error occurs while fetching the cargo
     */
    public Cargo getCargoById(Long id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/cargo/" + id))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request,
                HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to get cargo: " + response.statusCode());
        }

        return objectMapper.readValue(response.body(), Cargo.class);
    }

    /**
     * Adds a new cargo to the system.
     *
     * @param cargo the Cargo object to add
     * @return the added Cargo with generated details
     * @throws Exception if an error occurs while adding the cargo
     */
    public Cargo addCargo(Cargo cargo) throws Exception {
        String requestBody = objectMapper.writeValueAsString(cargo);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/add"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(request,
                HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to add cargo: " + response.statusCode());
        }

        return objectMapper.readValue(response.body(), Cargo.class);
    }

    /**
     * Updates the state of a specific cargo by its ID.
     *
     * @param id the ID of the cargo to update
     * @return the updated Cargo object with the new state
     * @throws Exception if an error occurs while updating the cargo state
     */
    public Cargo setState(Long id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/setState/" + id))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = httpClient.send(request,
                HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Failed to set state: " + response.statusCode());
        }

        return objectMapper.readValue(response.body(), Cargo.class);
    }
}
