package Entities;

public class Urun {

    private String id;
    private String ad;
    private String tur;
    private double agirlik;
    private double hacim;
    private int stok;

    public Urun(String id, String ad, String tur, double agirlik, double hacim, int stok) {
        this.id = id;
        this.ad = ad;
        this.tur = tur;
        this.agirlik = agirlik;
        this.hacim = hacim;
        this.stok = stok;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return  id;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
    public String getAd() {
        return  ad;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }
    public String getTur() {
        return tur;
    }

    public void setAgirlik(double agirlik) {
        this.agirlik = agirlik;
    }
    public double getAgirlik() {
        return  agirlik;
    }

    public void setHacim(double hacim) {
        this.hacim = hacim;
    }
    public double getHacim() {
        return   hacim;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    public int getStok() {
        return  stok;
    }
}




















