import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class IsimListesi {

    public static void isimEkle(ArrayList<String> liste, Scanner input) {
        System.out.printf("Listede kaç isim var?%nCevap: ");
        while (!input.hasNextInt()) {
            input.nextLine();
            System.out.printf("Sayı girmelisin%nCevap: ");
        }
        int listeUzunluk = input.nextInt();
        input.nextLine();

        for (int i = 0; i < listeUzunluk; i++) {
            System.out.printf("%d. isim: ",(i + 1));
            String isim = input.nextLine().toLowerCase();
            liste.add(isim);
        }
    }

    public static void isimKaldir(ArrayList<String> liste, Scanner input) {
        System.out.printf("Listeden hangi ismi çıkaracaksınız: ");
        String cikarilacakIsim = input.nextLine().toLowerCase();
        if (liste.contains(cikarilacakIsim)) {
            liste.remove(cikarilacakIsim);
        } else {
            System.out.printf("Listede bu isim yok!%n");
        }
    }

    public static void isimYazdir(ArrayList<String> liste) {
        System.out.printf("===Liste===%n");
        for (int i = 0; i < liste.size(); i++) {
            System.out.printf("%d. isim: %s%n", (i + 1), liste.get(i));
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<String> isimler = new ArrayList<>();

        isimEkle(isimler, input);
        isimKaldir(isimler, input);
        Collections.sort(isimler);
        isimYazdir(isimler);

        input.close();
    }
}