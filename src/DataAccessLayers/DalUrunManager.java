package DataAccessLayers;
import Entities.*;
import java.lang.Integer;
import java.io.*;
import java.util.ArrayList;

public class DalUrunManager {

    public void urunSil(int silinecekId) {
        ArrayList<Urun> tumUrunler = urunleriGetir();

        // kontrolcü
        boolean silindi = false;

        silindi = tumUrunler.removeIf(u -> Integer.parseInt(u.getId()) == silinecekId); //parseInt(u.getId()) burası önceden sadece u.getId() idi, burası 2.KISIM İÇİN

        if (silindi) {
            try {
              File dosya = new File("src/Database/Urunler.txt");
              FileWriter yazici = new FileWriter(dosya, false);
              BufferedWriter bufferYazici = new BufferedWriter(yazici);

              for (Urun u: tumUrunler) {
                  //Urunleri tekrar yaz
                  String satir = u.getId() + "," +
                                 u.getAd() + "," +
                                 u.getTur() + "," +
                                 u.getAgirlik() + "," +
                                 u.getHacim() + "," +
                                 u.getStok();

                  bufferYazici.write(satir);
                  bufferYazici.newLine();
              }

              bufferYazici.close();
              System.out.println("Urun silindi: " +  silinecekId);

            } catch (IOException e) {
                System.out.println("Dosya yazma hatasi: " + e.getMessage());
            }


        }

        else {
            System.out.println("Urun bulunamadi!");
        }

    }

    public void urunleriKaydet(Urun yeniUrun) {
        try{
            File dosya = new File("src/Database/Urunler.txt");
            FileWriter yazici = new FileWriter(dosya, true); //append = dosyanın sonuna ekle
            BufferedWriter bufferYazici = new BufferedWriter(yazici);

            String satir = yeniUrun.getId() + "," +
                           yeniUrun.getAd() + "," +
                           yeniUrun.getTur() + "," +
                           yeniUrun.getAgirlik() + "," +
                           yeniUrun.getHacim() + "," +
                           yeniUrun.getStok();

            bufferYazici.write(satir); //satir string ini dosyaya yaz
            bufferYazici.newLine();   // alt satıra geç
            bufferYazici.close();      //bufferedwriteri kapat
            System.out.println("Urun kaydedildi...");
        }   catch (IOException e) {
            System.out.println("Dosya yazma hatasi: " + e.getMessage());
        }

    }

    public ArrayList<Urun> urunleriGetir() {
        ArrayList<Urun> urunListesi = new ArrayList<>();

        try {
            //Dosyayı bul ve okumaya başla
            File dosya = new File("src/Database/Urunler.txt");
            BufferedReader okuyucu = new BufferedReader(new FileReader(dosya));

            String satir;
            // Satir bos olana kadar oku
            while ((satir = okuyucu.readLine()) != null) {

                //Gelen satiri virgülden ayır
                String[] veri = satir.split(",");

                //Verileri degiskenlere ata
                String id = veri[0];
                String ad = veri[1];
                String tur = veri[2];
                double agirlik = Double.parseDouble(veri[3]);
                double hacim =  Double.parseDouble(veri[4]);
                int stok = Integer.parseInt(veri[5]);

                // Nesneye çevir ve listeye ekle
                Urun yeniUrun = new Urun(id, ad, tur, agirlik, hacim, stok);
                urunListesi.add(yeniUrun);
            }
            okuyucu.close();

        } catch (Exception e) {
            System.out.println("Dosya okuma hatasi: " + e.getMessage());
        }

        return urunListesi;
    }
}
