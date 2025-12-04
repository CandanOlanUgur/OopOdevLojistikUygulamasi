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

        try {
            BufferedReader reader = new BufferedReader(new FileReader(dosya));
            String satir;

            while ((satir = reader.readLine()) != null) { //satır boş değilse döngüye devam et
                String[] veri = satir.split(","); // virgüle göre stringi parçala

                //[0]Kodu, [1]GonderenID, [2]AliciID, [3]UrunIDler(101-102-), [4]Plaka, [5]Cikis, [6]Varis

                //eksik satır varmı yokmu diye dosya kontrolü
                if(veri.length == 7) continue;

                String sevkiyatKodu = veri[0];
                String gönderici = veri[1];
                String alici = veri[2];

                String hamUrunString = veri[3];   //101-102-103 urun id lerini string olarak alır
                String[] urunIdDizisi = hamUrunString.split("-"); // her id yi tek bir array e atar

                ArrayList<String> urunIdlListesi = new ArrayList<>(); // urun listesi arayı oluştur ve urunIdizisine eşitle
                for (String id: urunIdDizisi) {
                    if (!id.isEmpty()) {
                        urunIdlListesi.add(id);
                    }
                }

                String plaka = veri[4];
                String cikisTarihi = veri[5];
                String varisTarihi = veri[6];

                Sevkiyat s = new Sevkiyat(sevkiyatKodu, varisTarihi, cikisTarihi, urunIdlListesi );
            }


        } catch (Exception e) {
            System.out.println("Sevkyatlar okunurken hata: " + e.getMessage());
            e.printStackTrace();
        }

        return sevkiyatListesi;
    }



}
