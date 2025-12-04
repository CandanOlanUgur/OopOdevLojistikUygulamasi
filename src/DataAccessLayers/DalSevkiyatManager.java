package DataAccessLayers;
import Entities.Sevkiyat;
import Entities.Urun;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DalSevkiyatManager {

    public void sevkiyatEkle(Sevkiyat s) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/Database/Sevkiyatlar.txt",true));

            StringBuilder urunIdleri = new StringBuilder();
            if (s.getTasinanUrunler() != null) {
                for (Urun u: s.getTasinanUrunler()) {
                    urunIdleri.append(u.getId()).append(",");
                }
            }

            //Nesnelerin kimlik bilgilerini al
            String satir = s.getSevkiyatKodu() + "," +
                           s.getGonderici() + "," +
                           s.getAlici() + "," +
                           urunIdleri.toString() +
                           s.getTasiyanArac().getPlaka() + "," +
                           s.getCikisTarihi() + "," +
                           s.getVarisTarihi() + ",";

            writer.write(satir);
            writer.newLine();
            writer.close();




        } catch (IOException e) {
            System.out.println("Kayıt hatası: " + e.getMessage());
        }
    }





}
