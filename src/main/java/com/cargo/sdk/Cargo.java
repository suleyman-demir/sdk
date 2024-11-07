package com.cargo.sdk;

public class Cargo {

    private String id;

    private String gondericiAdi;
    private String gondericiAdresi;
    private int desi;
    private String aliciAdi;
    private String aliciAdresi;
    Object state;

    public Cargo(String id, String gondericiAdi, String gondericiAdresi, int desi, String aliciAdi, String aliciAdresi, Object state) {
        this.id = id;
        this.gondericiAdi = gondericiAdi;
        this.gondericiAdresi = gondericiAdresi;
        this.desi = desi;
        this.aliciAdi = aliciAdi;
        this.aliciAdresi = aliciAdresi;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGondericiAdi() {
        return gondericiAdi;
    }

    public void setGondericiAdi(String gondericiAdi) {
        this.gondericiAdi = gondericiAdi;
    }

    public String getGondericiAdresi() {
        return gondericiAdresi;
    }

    public void setGondericiAdresi(String gondericiAdresi) {
        this.gondericiAdresi = gondericiAdresi;
    }

    public int getDesi() {
        return desi;
    }

    public void setDesi(int desi) {
        this.desi = desi;
    }

    public String getAliciAdi() {
        return aliciAdi;
    }

    public void setAliciAdi(String aliciAdi) {
        this.aliciAdi = aliciAdi;
    }

    public String getAliciAdresi() {
        return aliciAdresi;
    }

    public void setAliciAdresi(String aliciAdresi) {
        this.aliciAdresi = aliciAdresi;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

}
