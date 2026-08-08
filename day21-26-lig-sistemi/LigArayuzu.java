import java.util.ArrayList;
import java.util.Scanner;

public class LigArayuzu {
    private Lig lig;

    LigArayuzu(Lig lig) {
        this.lig = lig;
    }

    void calistir(Scanner input) {
        System.out.print("Takım ismi: ");
        String isim = input.nextLine().trim().toUpperCase();
        Takim takim1 = new Takim(isim, 0, 0, 0, 0, 0);
        try {
            lig.takimEkle(takim1);
        } catch (TakimZatenVarException e) {
            System.out.println(e);
        }

        System.out.print("Takım ismi: ");
        isim = input.nextLine().trim().toUpperCase();
        Takim takim2 = new Takim(isim, 0, 0, 0, 0, 0);
        try {
            lig.takimEkle(takim2);
        } catch (TakimZatenVarException e) {
            System.out.println(e);
        }

        System.out.print("Takım ismi: ");
        isim = input.nextLine().trim().toUpperCase();
        Takim takim3 = new Takim(isim, 0, 0, 0, 0, 0);
        try {
            lig.takimEkle(takim3);
        } catch (TakimZatenVarException e) {
            System.out.println(e);
        }

        lig.fiksturOlustur();

        System.out.print("Puan tablosu nasıl sıralansın?\n1) Büyük -> Küçük\n2) Küçük -> Büyük\nTercih: ");
        int tercih = input.nextInt();
        input.nextLine();
        boolean tersMi = (tercih != 1);

        puanTablosunuYazdir(tersMi);

        System.out.print("Evsahibi takım: ");
        String evIsim = input.nextLine().trim().toUpperCase();
        System.out.print("Deplasman takım: ");
        String deplasmanIsim = input.nextLine().trim().toUpperCase();
        System.out.print("Ev sahibi takımın skoru: ");
        int evSkor = input.nextInt();
        input.nextLine();
        System.out.print("Deplasman takımın skoru: ");
        int deplasmanSkor = input.nextInt();
        input.nextLine();
        try {
            lig.macSkorGir(evIsim, deplasmanIsim, evSkor, deplasmanSkor);
        } catch (MacBulunamadiException | MacZatenOynandiException | GecersizSkorException
                | BerabereSonuclanamazException e) {
            System.out.println(e);
        }

        try {
            lig.tumMaclariOyna();
        } catch (GecersizSkorException | BerabereSonuclanamazException e) {
            System.out.println(e);
        }

        System.out.print("Puan tablosu nasıl sıralansın?\n1) Büyük -> Küçük\n2) Küçük -> Büyük\nTercih: ");
        tercih = input.nextInt();
        input.nextLine();
        tersMi = (tercih != 1);

        puanTablosunuYazdir(tersMi);
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
}
