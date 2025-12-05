package UI;

import DataAccessLayers.DalSevkiyatManager;
import Entities.*;
import DataAccessLayers.DalUrunManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void Start() {
        Scanner scanner = new  Scanner(System.in);

        while (true) {
            System.out.println("-----------------UGUR LOJISTIK-----------------");
            System.out.print("Kullanici Adi: ");
            String kullaniciAdi = scanner.nextLine();



            System.out.print("Sifre: ");
            String sifre = scanner.nextLine();
            break;
        }

        /*
        List<Urun> urunList = new ArrayList<>();
        urunList.add(new Urun("011", "JumboTuvaletKagit20Li", "Temizlik", 0.5, 0.8, 100));

        Sevkiyat sevkiyat0 = new Sevkiyat("011", "11.12.2025", "5.12.2025",urunList, "48GHJ345", "A101MILAS", "PAPIATemizlikUrunleri");
        DalSevkiyatManager dalSevkiyatManager = new DalSevkiyatManager();
        dalSevkiyatManager.sevkiyatEkle(sevkiyat0);

         */

        DalSevkiyatManager Sevkmanager = new DalSevkiyatManager();
        Sevkmanager.sevkiyatSil("011");
    }
}






