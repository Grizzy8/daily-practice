import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class OgrenciNotSistemi {
    private String ad, soyAd;
    private int not, ogrenciNo;

    OgrenciNotSistemi(String ad, String soyAd, int not, int ogrenciNo) {
        this.ad = ad;
        this.soyAd = soyAd;
        this.not = not;
        this.ogrenciNo = ogrenciNo;
    }

    public static int ogrenciSayisi(Scanner input) {
        int ogrenciSayisi = 1;
        System.out.printf("Kaç öğrenci eklenecek?\nCevap: ");
        while (true) {
            if (input.hasNextInt()) {
                ogrenciSayisi = input.nextInt();
                input.nextLine();
                if (ogrenciSayisi <= 0) {
                    System.out.println("Eklenecek öğrenci en az 1 olmalıdır!");
                } else {
                    break;
                }
            } else {
                System.out.println("Sayı gir!");
                input.nextLine();
            }
        }
        return ogrenciSayisi;
    }

    public static void bilgiAlKaydet(Scanner input, HashMap<Integer, OgrenciNotSistemi> ogrenciler) {
        int uzunluk = ogrenciSayisi(input);
        int ogrenciNo = 0;
        for (int i = 0; i < uzunluk; i++) {
            System.out.print("İsim: ");
            String ad = input.nextLine();
            System.out.print("Soyisim: ");
            String soyAd = input.nextLine();
            System.out.print("Not: ");
            int not = input.nextInt();
            input.nextLine();
            ogrenciNo = (i + 1);

            OgrenciNotSistemi yeniOgrenci = new OgrenciNotSistemi(ad, soyAd, not, ogrenciNo);
            ogrenciler.put(ogrenciNo, yeniOgrenci);
            System.out.println(ogrenciNo + " numaralı yeni öğrenci kaydedildi.");
        }
    }

    public String bilgiVer() {
        return "Öğrenci No: " + ogrenciNo + " | " + ad + " " + soyAd + " | Not: " + not;
    }

    public static String ogrenciBilgisiGetir(Scanner input, HashMap<Integer, OgrenciNotSistemi> ogrenciler) {
        System.out.printf("Aranan öğrencinin numarası nedir?\nÖğrenci No: ");
        int arananNo = input.nextInt();
        input.nextLine();

        if (ogrenciler.containsKey(arananNo)) {
            return ogrenciler.get(arananNo).bilgiVer();
        } else {
            return "Bu numaraya sahip öğrenci bulunamadı";
        }
    }

    public static void listeyiKaydet(HashMap<Integer, OgrenciNotSistemi> ogrenciler) throws IOException {
        try (PrintWriter yazici = new PrintWriter(new FileWriter("day14-ogrenci-not-sistemi/Ogrenciler.txt", true))) {
            for (OgrenciNotSistemi o : ogrenciler.values()) {
                String satir = o.bilgiVer();
                yazici.write(satir + "\n");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<Integer, OgrenciNotSistemi> ogrenciler = new HashMap<>();

        bilgiAlKaydet(input, ogrenciler);
        System.out.println(ogrenciBilgisiGetir(input, ogrenciler));

        try {
            listeyiKaydet(ogrenciler);
        } catch (IOException e) {
            System.out.println("Hata: " + e.getMessage());
        }

        input.close();
    }
}