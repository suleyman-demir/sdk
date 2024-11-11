package com.cargo.sdk;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class CargoServiceSDK {
    public static final String BASE_URL = "http://localhost:8080/v1/api/delivery";
    private final CargoServiceClient cargoServiceClient;


    public CargoServiceSDK(CargoServiceClient cargoServiceClient) {
        this.cargoServiceClient = cargoServiceClient;
    }

    public CargoServiceSDK() {
        this.cargoServiceClient = new CargoServiceClient(BASE_URL);
    }


    public List<Cargo> executeGetAllCargos() throws Exception {
        return cargoServiceClient.getAllCargos();
    }

    public CompletableFuture<List<Cargo>> asyncExecuteGetAllCargos() {

        return CompletableFuture.supplyAsync(() -> {
            try {
                return cargoServiceClient.getAllCargos();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }


    public Cargo executeSetState(Long cargoId) throws Exception {
        return cargoServiceClient.setState(cargoId);
    }

    public CompletableFuture<Cargo> asyncExecuteSetState(Long cargoId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return cargoServiceClient.setState(cargoId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Cargo executeGetCargoById(Long cargoId) throws Exception {
        return cargoServiceClient.getCargoById(cargoId);
    }

    public CompletableFuture<Cargo> asyncExecuteGetCargoById(Long cargoId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return cargoServiceClient.getCargoById(cargoId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Cargo executeAddCargo(Cargo cargo) throws Exception {
        return cargoServiceClient.addCargo(cargo);
    }

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


