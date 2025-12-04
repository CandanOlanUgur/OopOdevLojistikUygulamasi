package Entities;

import java.sql.Date;
import java.util.List;

public class Sevkiyat {

    private String sevkiyatKodu;
    private String gonderici;
    private String alici;
    private List<Urun> tasinanUrunler;
    private Arac tasiyanArac;
    private String cikisTarihi;
    private String varisTarihi;

    public Sevkiyat(String sevkiyatKodu, String varisTarihi, String cikisTarihi, List<Urun> tasinanUrunler, Arac tasiyanArac, String alici, String gonderici) {
        this.sevkiyatKodu = sevkiyatKodu;
        this.varisTarihi = varisTarihi;
        this.cikisTarihi = cikisTarihi;
        this.tasinanUrunler = tasinanUrunler;
        this.tasiyanArac = tasiyanArac;
        this.alici = alici;
        this.gonderici = gonderici;
    }

    public String getSevkiyatKodu() {
        return sevkiyatKodu;
    }

    public void setSevkiyatKodu(String sevkiyatKodu) {
        this.sevkiyatKodu = sevkiyatKodu;
    }

    public String getVarisTarihi() {
        return varisTarihi;
    }

    public void setVarisTarihi(String varisTarihi) {
        this.varisTarihi = varisTarihi;
    }

    public String getCikisTarihi() {
        return cikisTarihi;
    }

    public void setCikisTarihi(String cikisTarihi) {
        this.cikisTarihi = cikisTarihi;
    }

    public Arac getTasiyanArac() {
        return tasiyanArac;
    }

    public void setTasiyanArac(Arac tasiyanArac) {
        this.tasiyanArac = tasiyanArac;
    }

    public List<Urun> getTasinanUrunler() {
        return tasinanUrunler;
    }

    public void setTasinanUrunler(List<Urun> tasinanUrunler) {
        this.tasinanUrunler = tasinanUrunler;
    }

    public String getAlici() {
        return alici;
    }

    public void setAlici(String alici) {
        this.alici = alici;
    }

    public String getGonderici() {
        return gonderici;
    }

    public void setGonderici(String gonderici) {
        this.gonderici = gonderici;
    }
}
