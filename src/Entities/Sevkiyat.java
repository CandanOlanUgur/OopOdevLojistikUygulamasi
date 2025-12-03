package Entities;

import java.sql.Date;
import java.util.List;

public class Sevkiyat {

    private String sevkiyatKodu;
    private Firma gonderici;
    private Firma alici;
    private List<Urun> tasinanUrunler;
    private Arac tasiyanArac;
    private Date cikisTarihi;
    private Date varisTarihi;

    public Sevkiyat(String sevkiyatKodu, Date varisTarihi, Date cikisTarihi, List<Urun> tasinanUrunler, Arac tasiyanArac, Firma alici, Firma gonderici) {
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

    public Date getVarisTarihi() {
        return varisTarihi;
    }

    public void setVarisTarihi(Date varisTarihi) {
        this.varisTarihi = varisTarihi;
    }

    public Date getCikisTarihi() {
        return cikisTarihi;
    }

    public void setCikisTarihi(Date cikisTarihi) {
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

    public Firma getAlici() {
        return alici;
    }

    public void setAlici(Firma alici) {
        this.alici = alici;
    }

    public Firma getGonderici() {
        return gonderici;
    }

    public void setGonderici(Firma gonderici) {
        this.gonderici = gonderici;
    }
}
