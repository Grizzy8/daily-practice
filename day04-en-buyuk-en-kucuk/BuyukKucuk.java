public class BuyukKucuk {

    public static void enBuyuk(int[] dizi) {
        int enBuyuk = dizi[0];
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i] > enBuyuk) {
                enBuyuk = dizi[i];
            }
        }
        System.out.println("En büyük sayı: " + enBuyuk);
    }

    public static void enKucuk(int[] dizi) {
        int enKucuk = dizi[0];
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i] < enKucuk) {
                enKucuk = dizi[i];
            }
        }
        System.out.println("En küçük sayı: " + enKucuk);
    }

    public static void ortalama(int[] dizi) {
        int toplam = 0;
        for (int i = 0; i < dizi.length; i++) {
            toplam += dizi[i];
        }
        double ortalama = (double) toplam / dizi.length;
        System.out.printf("Ortalama: %.2f%n", ortalama);
    }

    public static void ikinciEnBuyuk(int[] dizi) {
        int enBuyuk = dizi[0];
        int ikinciEnBuyuk = dizi[1];
        for (int i = 1; i < dizi.length; i++) {
            if (dizi[i] > enBuyuk) {
                ikinciEnBuyuk = enBuyuk;
                enBuyuk = dizi[i];
            } else if (dizi[i] > ikinciEnBuyuk) {
                ikinciEnBuyuk = dizi[i];
            }
        }
        System.out.println("İkinci en büyük: " + ikinciEnBuyuk);
    }

    public static void main(String[] args) {
        int[] sayilar = { 12, 43, 65, 87, 100, 93, 49, 51, 63, 70, 81 };

        enBuyuk(sayilar);
        enKucuk(sayilar);
        ortalama(sayilar);
        ikinciEnBuyuk(sayilar);
    }
}