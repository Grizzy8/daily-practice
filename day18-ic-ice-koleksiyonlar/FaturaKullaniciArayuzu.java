import java.util.ArrayList;
import java.util.Scanner;

public class FaturaKullaniciArayuzu {
    private FaturaSistemi sistem;
    private Scanner input;

    FaturaKullaniciArayuzu(FaturaSistemi sistem, Scanner input) {
        this.sistem = sistem;
        this.input = input;
    }

    public void menuDongusu() {
        while (true) {
            System.out.print(
                    "1) Daire ekle\n2) Dairenin ortalamasını göster\n3) Anormal tüketimleri göster\n4) Çıkış\nCevap: ");
            int secim = input.nextInt();
            input.nextLine();
            switch (secim) {
                case 1:
                    ArrayList<Integer> liste = new ArrayList<>();
                    System.out.print("Daire Adı: ");
                    String daireAdi = input.nextLine();
                    System.out.print("Kaç aylık bilgi gireceksiniz?\nCevap: ");
                    int eklenecekDaire = input.nextInt();
                    input.nextLine();
                    for (int i = 0; i < eklenecekDaire; i++) {
                        System.out.print((i + 1) + ". ay verisi: ");
                        int veri = input.nextInt();
                        input.nextLine();
                        liste.add(veri);
                    }
                    sistem.daireEkle(daireAdi, liste);
                    break;
                case 2:
                    System.out.print("Daire adı: ");
                    daireAdi = input.nextLine();
                    if (sistem.daireVarMi(daireAdi)) {
                        System.out.println(sistem.ortalamaHesapla(daireAdi));
                    } else {
                        System.out.println("Böyle bir daire bulunamadı.");
                    }

                    break;
                case 3:
                    ArrayList<String> anormallikler = sistem.anormalTuketimleriBul();

                    if (anormallikler.isEmpty()) {
                        System.out.println("Anormal tüketim yok.");
                    } else {
                        for (String a : anormallikler) {
                            System.out.println(a);
                        }
                    }
                    break;
                case 4:
                    return;
            }
        }
    }
}
