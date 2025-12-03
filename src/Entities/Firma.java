package Entities;

public class Firma {

    private int id;
    private String unvan;
    private String adres;
    private String tip;

    public void Firma(int id, String unvan, String adres, String tip) {
        this.id = id;
        this.unvan = unvan;
        this.adres = adres;
        this.tip = tip;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return  id;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }
    public String getUnvan() {
        return unvan;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    public String getAdres() {
        return adres;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
    public String getTip() {
        return tip;
    }
}














