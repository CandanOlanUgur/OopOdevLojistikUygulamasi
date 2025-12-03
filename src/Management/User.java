package Management;

public class User {

    private String kullaniciAdi;
    private String sifre;
    private String yetki;

    public User(String kullaniciAdi, String sifre, String yetki) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.yetki = yetki;
    }

    public void setKullaniciAdi() {
        this.kullaniciAdi = kullaniciAdi;
    }
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setSifre() {
        this.sifre = sifre;
    }
    public String getSifre() {
        return yetki;
    }

    public void setYetki() {
        this.yetki = yetki;
    }
    public String getYetki() {
        return yetki;
    }
}

