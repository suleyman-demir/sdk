package com.cargo.sdk;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "cargo",url = "${cargo.url}")
public interface CargoServiceClient {

    @GetMapping("/cargos")
    List<Cargo> getAllCargos();

    @GetMapping("/cargo/{id}")
    Cargo getCargoById(@PathVariable("id") Long id);

    @PostMapping("/add")
    Cargo addCargo(@RequestBody Cargo cargo);

    @PostMapping("setState/{id}")
    Cargo setState(@PathVariable("id") Long id);




}
