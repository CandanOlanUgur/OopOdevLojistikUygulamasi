package Entities;

public class Arac {
    private String plaka;
    private String soforIsmi;
    private String durum;
    private String konum;

    public Arac(String plaka, String soforIsmi, String durum, String konum) {
        this.plaka = plaka;
        this.soforIsmi = soforIsmi;
        this.durum = durum;
        this.konum = konum;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }
    public String getPlaka() {
        return plaka;
    }

    public void setSoforIsmi(String soforIsmi) {
        this.soforIsmi = soforIsmi;
    }
    public String getSoforIsmi() {
        return soforIsmi;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
    public String getDurum() {
        return durum;
    }

    public void setKonum(String konum) {
        this.konum = konum;
    }
    public String getKonum() {
        return konum;
    }
}













