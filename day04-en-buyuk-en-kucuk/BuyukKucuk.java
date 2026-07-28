import java.util.Scanner;

public class BuyukKucuk {

    public static int enBuyuk(int[] dizi) {
        int enBuyuk = dizi[0];
        for (int i = 1; i < dizi.length; i++) {
            if (dizi[i] > enBuyuk) {
                enBuyuk = dizi[i];
            }
        }
        return enBuyuk;
    }

    public static int enKucuk(int[] dizi) {
        int enKucuk = dizi[0];
        for (int i = 1; i < dizi.length; i++) {
            if (dizi[i] < enKucuk) {
                enKucuk = dizi[i];
            }
        }
        return enKucuk;
    }

    public static double ortalama(int[] dizi) {
        int toplam = 0;
        for (int i = 0; i < dizi.length; i++) {
            toplam += dizi[i];
        }
        return (double) toplam / dizi.length;
    }

    public static int ikinciEnBuyuk(int[] dizi) {
        int enBuyuk = dizi[0];
        int ikinciEnBuyuk = dizi[0];
        for (int i = 1; i < dizi.length; i++) {
            if (dizi[i] > enBuyuk) {
                ikinciEnBuyuk = enBuyuk;
                enBuyuk = dizi[i];
            } else if (dizi[i] > ikinciEnBuyuk) {
                ikinciEnBuyuk = dizi[i];
            }
        }
        return ikinciEnBuyuk;
    }

    public static int diziBoyutAl(Scanner giriss) {
        int diziUzunluk = 0;
        while (true) {
            System.out.print("Girilecek sayı adeti: ");
            if (giriss.hasNextInt()) {
                diziUzunluk = giriss.nextInt();
                giriss.nextLine();
                if (0 < diziUzunluk) {
                    break;
                } else {
                    System.out.println("Sayı adeti negatif olamaz");
                }
            } else {
                System.out.println("Adet sayısal olmalıdır!");
                giriss.nextLine();
            }
        }
        return diziUzunluk;
    }

    public static int[] diziDoldur(Scanner giriss) {
        int boyut = diziBoyutAl(giriss);
        int[] sayilar = new int[boyut];

        for (int i = 0; i < boyut; i++) {
            System.out.print((i + 1) + ". sayı: ");
            while (true) {
                if (giriss.hasNextInt()) {
                    sayilar[i] = giriss.nextInt();
                    break;
                } else {
                    System.out.println("Tam sayı girin!");
                    giriss.nextLine();
                }
            }
        }
        return sayilar;
    }

    public static void main(String[] args) {
        Scanner giriss = new Scanner(System.in);

        int[] sayilar = diziDoldur(giriss);

        System.out.println("En büyük sayı: " + enBuyuk(sayilar));
        System.out.println("En küçük sayı: " + enKucuk(sayilar));
        System.out.printf("Ortalama: %.2f%n", ortalama(sayilar));
        System.out.println("İkinci en büyük: " + ikinciEnBuyuk(sayilar));

        giriss.close();
    }
}