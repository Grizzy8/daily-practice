import java.util.Scanner;

public class Not {
    public static double toplamHesapla(double[] notlar) {
        double toplam = 0;
        for (int i = 0; i < notlar.length; i++) {
            toplam += notlar[i];
        }
        return toplam;
    }

    public static int enKucukNotIndeksBulma(double[] notlar) {
        double enKucuk = notlar[0];
        int enKucukIndeks = 0;
        for (int i = 0; i < notlar.length; i++) {
            if (notlar[i] < enKucuk) {
                enKucuk = notlar[i];
                enKucukIndeks = i;
            }
        }
        return enKucukIndeks;
    }

    public static double ortalama(double[] notlar) {
        return toplamHesapla(notlar) / notlar.length;
    }

    public static double ortalamaEnDusukHaric(double[] notlar) {
        int enKucukIndeks = enKucukNotIndeksBulma(notlar);
        return (toplamHesapla(notlar) - notlar[enKucukIndeks]) / (notlar.length - 1);
    }

    public static void harfNotu(double ortalama) {
        if (ortalama >= 90) {
            System.out.println("Harf Notu: A");
        } else if (ortalama >= 80) {
            System.out.println("Harf Notu: B");
        } else if (ortalama >= 70) {
            System.out.println("Harf Notu: C");
        } else if (ortalama >= 60) {
            System.out.println("Harf Notu: D");
        } else if (ortalama >= 50) {
            System.out.println("Harf Notu: E");
        } else {
            System.out.println("Harf Notu: F");
        }
    }

    public static String gecmeDurumu(double ortalama) {
        if (ortalama < 50) {
            return "Kaldı";
        } else {
            return "Geçti";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Girilecek not sayısı: ");
        int notSayisi = input.nextInt();

        double[] notlar = new double[notSayisi];

        int sayac = 0;
        for (int i = 0; i < notlar.length; i++) {
            sayac++;
            System.out.print(sayac + ". Not: ");
            notlar[i] = input.nextDouble();
        }

        double ortalama = ortalama(notlar);

        harfNotu(ortalama);
        System.out.printf("Ortalama: %.2f | %s%n", ortalama, gecmeDurumu(ortalama));
        System.out.printf("En düşük not hariç ortalama: %.2f", ortalamaEnDusukHaric(notlar));

        input.close();
    }
}