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

        Urun urun0 = new Urun("1003", "IcımAycicekYag1L", "GIDA", 1, 0.2, 1);
        Urun urun1 = new Urun("1004", "KeskinogluYumurta15Li", "GIDA", 10, 2, 50 );
        List<Urun> urunList0 = new ArrayList<>();
        urunList0.add(urun0);
        urunList0.add(urun1);

        Sevkiyat sevkiyat0 = new Sevkiyat("011", "10.12.2025", "4.12.2025",urunList0, "arac0", "MILASA101", "ICIMGIDA");
        DalSevkiyatManager dalSevkiyatManager = new DalSevkiyatManager();
        dalSevkiyatManager.sevkiyatEkle(sevkiyat0);

    }
}






