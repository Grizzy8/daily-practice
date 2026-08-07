import java.util.Scanner;

public class LigMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Lig lig1 = new Lig();

        Takim takim1 = new Takim("a", 0, 0, 0, 0, 0);
        Takim takim2 = new Takim("b", 0, 0, 0, 0, 0);
        Takim takim3 = new Takim("c", 0, 0, 0, 0, 0);
        lig1.takimEkle(takim1);
        lig1.takimEkle(takim2);
        lig1.takimEkle(takim3);

        lig1.fiksturOlustur();

        lig1.tumMaclariOyna();

        System.out.print("Puan tablosu nasıl sıralansın?\n1) Büyük -> Küçük\n2) Küçük -> Büyük\nTercih: ");
        int tercih = input.nextInt();
        boolean tersMi = (tercih != 1);

        lig1.puanTablosunuYazdir(tersMi);

        input.close();
    }
}