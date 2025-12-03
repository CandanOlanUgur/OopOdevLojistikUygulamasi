package DataAccessLayers;
import Entities.Sevkiyat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DalSevkiyatManager {

    public void sevkiyatEkle(Sevkiyat s) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/Database/Sevkiyatlar.txt", true));
            String satir = s.getSevkiyatKodu() + "," +
                           s.getGonderici() + "," +
                           s.getAlici() + "," +
                           s.getTasinanUrunler() + "," +
                           s.getTasiyanArac() + "," +
                           s.getCikisTarihi() + "," +
                           s.getVarisTarihi();

            writer.write(satir);
            writer.newLine();
            System.out.println("Sevkiyat olusturuldu: " + s.getSevkiyatKodu());
        } catch (IOException e) {
            System.out.println("Kayıt hatası: " + e.getMessage());
        }
    }





}
