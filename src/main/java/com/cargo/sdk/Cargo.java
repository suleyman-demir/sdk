package com.cargo.sdk;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor


public class Cargo {

    private String id;
    private String gondericiAdi;
    private String gondericiAdresi;
    private int desi;
    private String aliciAdi;
    private String aliciAdresi;
    Object state;
}
