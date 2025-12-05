package DataAccessLayers;
import Entities.Sevkiyat;
import Entities.Urun;

import java.io.*;
import java.util.ArrayList;

public class DalSevkiyatManager {

    public void sevkiyatEkle(Sevkiyat s) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/Database/Sevkiyatlar.txt",true));

            StringBuilder urunIdleri = new StringBuilder();
            if (s.getTasinanUrunler() != null) {
                for (Urun u: s.getTasinanUrunler()) {
                    urunIdleri.append(u.getId()).append("-");
                }
            }

            //Nesnelerin kimlik bilgilerini al
            String satir = s.getSevkiyatKodu() + "," +
                           s.getGonderici() + "," +
                           s.getAlici() + "," +
                           urunIdleri.toString() + "," +
                           s.getTasiyanArac() + "," +
                           s.getCikisTarihi() + "," +
                           s.getVarisTarihi() + ",";

            writer.write(satir);
            writer.newLine();
            writer.close();




        } catch (IOException e) {
            System.out.println("Kayıt hatası: " + e.getMessage());
        }
    }


    public ArrayList<Sevkiyat> sevkiyatlariGetir() {
        ArrayList<Sevkiyat> sevkiyatListesi = new ArrayList<>();
        File dosya = new File("src/Database/Sevkiyatlar.txt");

        if (!dosya.exists()) { // dosya boş sa boş döndür
            return sevkiyatListesi;
        }

        DalUrunManager urunManager = new DalUrunManager(); //urunlere ulaş
        ArrayList<Urun> tumUrunler = urunManager.urunleriGetir();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(dosya));
            String satir;

            while ((satir = reader.readLine()) != null) {
                String[] veri = satir.split(",");

                if (veri.length < 7) { continue; } // 7.ci değere kadar almaya devam et

                String sevkiyatKodu = veri[0];
                String gonderici = veri[1];
                String alici = veri[2];

                String hamUrunString = veri[3]; // örn "1003-1004"
                String[] urunIdDizisi = hamUrunString.split(","); //urunler ayrıldı

                ArrayList<Urun> tasinanUrunlerListesi = new ArrayList<>();

                for (String arananId : urunIdDizisi) {
                    if (!arananId.isEmpty()) {

                        for (Urun u: tumUrunler) {
                            if (u.getId().equals(arananId)) {
                                tasinanUrunlerListesi.add(u);
                                break; // sıradaki Id yi kontrol et
                            }
                        }
                    }
                }

                String plaka = veri[4];
                String cikisTarihi = veri[5];
                String varisTarihi = veri[6];

                Sevkiyat s = new Sevkiyat(sevkiyatKodu, varisTarihi, cikisTarihi, tasinanUrunlerListesi, plaka, alici, gonderici);
                sevkiyatListesi.add(s);

            }

            reader.close();


        } catch (Exception e) {
            System.out.println("Sevkyatlar okunurken hata: " + e.getMessage());
            e.printStackTrace();
        }

        return sevkiyatListesi;
    }

    public void sevkiyatSil(String silinecekKod) {

        ArrayList<Sevkiyat> tumSevkiyatlar = sevkiyatlariGetir();

        boolean silindi = tumSevkiyatlar.removeIf(s -> s.getSevkiyatKodu().equals(silinecekKod));

        if (silindi) {
            try {
                File dosya = new File("src/Database/Sevkiyatlar.txt");
                BufferedWriter writer = new BufferedWriter(new FileWriter(dosya, false));

                for (Sevkiyat s: tumSevkiyatlar) {

                    StringBuilder urunIdleri = new StringBuilder();
                    if (s.getTasinanUrunler() != null) {
                        for (Urun u: s.getTasinanUrunler()) {
                            urunIdleri.append(u.getId()).append("-");
                        }
                    }

                    String satir = s.getSevkiyatKodu() + "," +
                                    s.getGonderici() + "," +
                                    s.getAlici() + "," +
                                    urunIdleri.toString() + "," +
                                    s.getTasiyanArac() + "," +
                                    s.getCikisTarihi() + "," +
                                    s.getVarisTarihi();

                    writer.write(satir);
                    writer.newLine();
                }

                writer.close();
                System.out.println("Sevkiyat silindi: " + silinecekKod);

            } catch (IOException e) {
                System.out.println("Dosya guncellenirken hata olustu: "+ e.getMessage());
            }
        }

        else {
            System.out.println("Silinecek sevkiyat bulunamadi: " +  silinecekKod);
        }
    }





}
