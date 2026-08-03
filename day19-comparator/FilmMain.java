import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FilmMain {

    private static void listeyiYazdir(List<Film> liste) {
        System.out.printf("%-40s%-6s%-5s%n", "İsim", "Yıl", "Puan");
        for (Film f : liste) {
            System.out.printf("%-40s%-6d%-5.1f%n", f.getIsim(), f.getYil(), f.getPuan());
        }
        System.out.println();
    }

    private static int okuInt(Scanner input, String mesaj) {
        while (true) {
            System.out.printf(mesaj);
            if (input.hasNextInt()) {
                int sayi = input.nextInt();
                input.nextLine();
                return sayi;
            } else {
                System.out.println("Sayı girin!");
                System.out.println();
                input.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Film> liste = new ArrayList<Film>();
        liste.add(new Film("Dev Avcısı Jack", 2013, 10));
        liste.add(new Film("Örümcek Adam: Eve Dönüş Yok", 2021, 8.5));
        liste.add(new Film("Örümcek Adam: Evden Uzakta", 2019, 9));
        liste.add(new Film("Bumble Bee", 2018, 7));
        liste.add(new Film("Transformers 3: Ayın Karanlık Yüzü", 2011, 10));
        liste.add(new Film("Transformers 5", 2017, 8));

        listeyiYazdir(liste);
        System.out.println();
        while (true) {
            int secim = okuInt(input,
                    "Hangi kritere göre sıralamak istiyorsun?%n1) İsme göre%n2) Yıla göre%n3) Puana göre%n4) Çıkış%nCevap: ");
            System.out.println();
            switch (secim) {
                case 1:
                    Collections.sort(liste, new IsimComparator());
                    listeyiYazdir(liste);
                    break;
                case 2:
                    Collections.sort(liste, new YilComparator());
                    listeyiYazdir(liste);
                    break;
                case 3:
                    Collections.sort(liste, new PuanComparator());
                    listeyiYazdir(liste);
                    break;
                case 4:
                    input.close();
                    return;
                default:
                    System.out.println("Lütfen 1 ve 4 arasında tercih yapın");
                    System.out.println();
                    break;
            }
        }
    }
}