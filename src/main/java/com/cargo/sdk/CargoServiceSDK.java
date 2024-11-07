package com.cargo.sdk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class CargoServiceSDK {
    private final CargoServiceClient cargoServiceClient;

    @Autowired
    public CargoServiceSDK(CargoServiceClient cargoServiceClient) {
        this.cargoServiceClient = cargoServiceClient;
    }


    public List<Cargo> executeGetAllCargos() {
        return cargoServiceClient.getAllCargos();
    }

    public CompletableFuture<List<Cargo>>asyncExecuteGetAllCargos() {

        return CompletableFuture.supplyAsync(cargoServiceClient::getAllCargos);

    }



    public Cargo executeSetState(Long cargoId) {
        return cargoServiceClient.setState(cargoId);
    }

    public CompletableFuture<Cargo> asyncExecuteSetState(Long cargoId) {
        return CompletableFuture.supplyAsync(() -> cargoServiceClient.setState(cargoId));
    }

    public Cargo executeGetCargoById(Long cargoId) {
        return cargoServiceClient.getCargoById(cargoId);
    }

    public CompletableFuture<Cargo> asyncExecuteGetCargoById(Long cargoId) {
        return CompletableFuture.supplyAsync(() -> cargoServiceClient.getCargoById(cargoId));
    }

    public Cargo executeAddCargo(Cargo cargo) {
        return cargoServiceClient.addCargo(cargo);
    }

    public CompletableFuture<Cargo> asyncExecuteAddCargo(Cargo cargo) {
        return CompletableFuture.supplyAsync(() -> cargoServiceClient.addCargo(cargo));
    }
}


