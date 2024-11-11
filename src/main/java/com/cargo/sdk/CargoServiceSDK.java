package com.cargo.sdk;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * SDK for managing cargo operations with the Cargo microservice.
 * This SDK provides synchronous and asynchronous methods for interacting with cargo data.
 * By using this SDK, clients can manage and retrieve cargo details without directly interacting
 * with HTTP requests or the CargoServiceClient implementation.
 */
public class CargoServiceSDK {

    /**
     * The base URL for the Cargo microservice.
     */
    public static final String BASE_URL = "http://localhost:8080/v1/api/delivery";

    private final CargoServiceClient cargoServiceClient;

    /**
     * Constructs the CargoServiceSDK with a custom {@link CargoServiceClient}.
     *
     * @param cargoServiceClient the client used to perform operations on cargo data
     */
    public CargoServiceSDK(CargoServiceClient cargoServiceClient) {
        this.cargoServiceClient = cargoServiceClient;
    }

    /**
     * Constructs the CargoServiceSDK with the default {@link CargoServiceClient}
     * configured with {@link #BASE_URL}.
     */
    public CargoServiceSDK() {
        this.cargoServiceClient = new CargoServiceClient(BASE_URL);
    }

    /**
     * Retrieves all cargos synchronously.
     *
     * @return a list of all cargos
     * @throws Exception if an error occurs while fetching the cargo data
     */
    public List<Cargo> executeGetAllCargos() throws Exception {
        return cargoServiceClient.getAllCargos();
    }

    /**
     * Retrieves all cargos asynchronously.
     *
     * @return a CompletableFuture containing a list of all cargos
     */
    public CompletableFuture<List<Cargo>> asyncExecuteGetAllCargos() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return cargoServiceClient.getAllCargos();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Sets the state of a specified cargo synchronously.
     *
     * @param cargoId the ID of the cargo to update
     * @return the updated cargo with the new state
     * @throws Exception if an error occurs while updating the cargo state
     */
    public Cargo executeSetState(Long cargoId) throws Exception {
        return cargoServiceClient.setState(cargoId);
    }

    /**
     * Sets the state of a specified cargo asynchronously.
     *
     * @param cargoId the ID of the cargo to update
     * @return a CompletableFuture containing the updated cargo with the new state
     */
    public CompletableFuture<Cargo> asyncExecuteSetState(Long cargoId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return cargoServiceClient.setState(cargoId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Retrieves a specific cargo by ID synchronously.
     *
     * @param cargoId the ID of the cargo to retrieve
     * @return the cargo with the specified ID
     * @throws Exception if an error occurs while fetching the cargo
     */
    public Cargo executeGetCargoById(Long cargoId) throws Exception {
        return cargoServiceClient.getCargoById(cargoId);
    }

    /**
     * Retrieves a specific cargo by ID asynchronously.
     *
     * @param cargoId the ID of the cargo to retrieve
     * @return a CompletableFuture containing the cargo with the specified ID
     */
    public CompletableFuture<Cargo> asyncExecuteGetCargoById(Long cargoId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return cargoServiceClient.getCargoById(cargoId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Adds a new cargo synchronously.
     *
     * @param cargo the cargo to be added
     * @return the added cargo with generated details
     * @throws Exception if an error occurs while adding the cargo
     */
    public Cargo executeAddCargo(Cargo cargo) throws Exception {
        return cargoServiceClient.addCargo(cargo);
    }

    /**
     * Adds a new cargo asynchronously.
     *
     * @param cargo the cargo to be added
     * @return a CompletableFuture containing the added cargo with generated details
     */
    public CompletableFuture<Cargo> asyncExecuteAddCargo(Cargo cargo) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return cargoServiceClient.addCargo(cargo);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
