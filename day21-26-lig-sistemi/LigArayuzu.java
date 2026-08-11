import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LigArayuzu {
    private Lig lig;

    LigArayuzu(Lig lig) {
        this.lig = lig;
    }

    void menuDongusu(Scanner input) {
        int atlanan = 0;
        try {
            atlanan = lig.yukle("Lig.txt", "Mac.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
        if (0 < atlanan) {
            System.out.println("Lig yeniden yüklenirken " + atlanan + " satır atlandı.");
        }

        while (true) {
            int tercih = okuInt(input,
                    "Ne yapmak istiyorsunuz?%n1) Takım Ekle%n2) Fikstür oluştur%n3) Maç Skorlarını Gir%n4) Sezonu Simüle Et%n5) Puan Tablosunu Göster%n6) Kaydet%n7) İstatistik Raporu%n8) Çıkış%nTercih: ");
            switch (tercih) {
                case 1:
                    System.out.print("Takım ismi: ");
                    String isim = input.nextLine().trim().toUpperCase();
                    Takim takim1 = new Takim(isim, 0, 0, 0, 0, 0);
                    try {
                        lig.takimEkle(takim1);
                        System.out.println("Takım eklendi.");
                    } catch (TakimZatenVarException e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    int eklenenMac = lig.fiksturOlustur();
                    if (eklenenMac != 0) {
                        System.out.println("Fikstür oluşturuldu.");
                    } else {
                        System.out.println("Fikstür zaten oluşturulmuş.");
                    }
                    break;
                case 3:
                    System.out.print("Evsahibi takım: ");
                    String evIsim = input.nextLine().trim().toUpperCase();
                    System.out.print("Deplasman takım: ");
                    String deplasmanIsim = input.nextLine().trim().toUpperCase();
                    int evSkor = okuInt(input, "Ev sahibi takımın skoru: ");
                    int deplasmanSkor = okuInt(input, "Deplasman takımın skoru: ");
                    try {
                        lig.macSkorGir(evIsim, deplasmanIsim, evSkor, deplasmanSkor);
                        System.out.println("Maç bilgileri başarıyla işlendi.");
                    } catch (MacBulunamadiException | MacZatenOynandiException | GecersizSkorException
                            | BerabereSonuclanamazException e) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    try {
                        lig.tumMaclariOyna();
                        System.out.println("Sezon rastgele skorlarla simüle edildi.");
                    } catch (GecersizSkorException | BerabereSonuclanamazException e) {
                        System.out.println(e);
                    }
                    break;
                case 5:
                    int ters = okuInt(input,
                            "Puan tablosu nasıl sıralansın?\n1) Büyük -> Küçük\n2) Küçük -> Büyük\nTercih: ");
                    boolean tersMi = (ters != 1);
                    puanTablosunuYazdir(tersMi);
                    break;
                case 6:
                    try {
                        lig.kaydetLig("Lig.txt");
                        lig.kaydetMac("Mac.txt");
                        System.out.println("Lig bilgileri başarıyla kaydedildi.");
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    break;
                case 7:
                    istatistikRaporuYazdir();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Lütfen menü numaralarından birini seçin");
            }
        }
    }

    void puanTablosunuYazdir(boolean tersMi) {
        ArrayList<Takim> liste = lig.siraliPuanTablosu(tersMi);
        System.out.println("________________________________________________________________________");
        System.out.printf("| %-4s | %-40s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", "Sıra", "Takım", "OM",
                "G", "B", "M", "AG", "YG", "A", "P");
        for (int i = 0; i < liste.size(); i++) {
            Takim t = liste.get(i);
            System.out.printf("| %4d | %-40s | %3d | %3d | %3d | %3d | %3d | %3d | %3d | %3d |%n", (i + 1), t.getIsim(),
                    t.oynananMacHesapla(), t.getGalibiyet(), t.getBeraberlik(), t.getMaglubiyet(), t.getAtilanGol(),
                    t.getYenilenGol(), t.averajHesapla(), t.puanHesapla());
        }
    }

    void istatistikRaporuYazdir() {
        Takim gollu = lig.enCokGolAtanTakim();
        Takim enAzGolYiyen = lig.enIyiSavunma();
        Takim averajli = lig.enYuksekAveraj();
        EnUzunSeriSonucu serili = lig.ligdeEnUzunSeri();
        if (gollu == null) {
            System.out.println("Henüz takım eklenmedi.");
            return;
        }
        System.out.println(
                "Golcü takım: " + gollu.getIsim() + " ( " + gollu.getAtilanGol() + " gol )");
        System.out.println(
                "En az gol yiyen takım: " + enAzGolYiyen.getIsim() + " ( " + enAzGolYiyen.getYenilenGol() + " gol )");
        System.out.println(
                "En yüksek averajlı takım: " + averajli.getIsim() + " ( " + averajli.averajHesapla() + " )");
        System.out.println(
                "En uzun galibiyet serisi: " + serili.getTakim().getIsim() + " ( " + serili.getSeri() + " maç )");
    }

    private int okuInt(Scanner input, String mesaj) {
        int sayi;
        while (true) {
            System.out.printf(mesaj);
            if (input.hasNextInt()) {
                sayi = input.nextInt();
                input.nextLine();
                break;
            } else {
                System.out.println("Lütfen sayı girin!");
                input.nextLine();
            }
        }
        return sayi;
    }
}