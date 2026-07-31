import java.util.ArrayList;
import java.util.Scanner;

public class OgrenciOop {
    private String ad, soyAd;
    private int not;
    private int ogrenciNo;

    OgrenciOop(String ad, String soyAd, int not, int ogrenciNo) {
        this.ad = ad;
        this.soyAd = soyAd;
        this.not = not;
        this.ogrenciNo = ogrenciNo;
    }

    public String bilgiVer() {
        return "Öğrenci No: " + ogrenciNo + " | İsim Soyisim: " + ad + " " + soyAd + " | Not: " + not;
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public boolean notGuncelle(int yeniNot) {
        if (yeniNot < 0 || 100 < yeniNot) {
            return false;
        } else {
            this.not = yeniNot;
            return true;
        }
    }

    public static int gecerliSayiAl(Scanner input, String mesaj, int min, int max) {
        while (true) {
            System.out.printf(mesaj);
            if (input.hasNextInt()) {
                int gecerliSayi = input.nextInt();
                input.nextLine();

                if (gecerliSayi < min || max < gecerliSayi) {
                    System.out.println("Girişlerinizi " + min + " ve " + max + " değerleri arasında yapın.");
                } else {
                    return gecerliSayi;
                }
            } else {
                System.out.println("Sayı girmelisiniz");
                input.nextLine();
            }
        }
    }

    public static int ogrenciSayisiAl(Scanner input) {
        return gecerliSayiAl(input, "Eklenecek öğrenci sayısı: ", 1, Integer.MAX_VALUE);
    }

    public static String bosOlmayanGirdiAl(Scanner input, String mesaj) {
        while (true) {
            System.out.print(mesaj);
            String girdi = input.nextLine();
            if (girdi.trim().isEmpty()) {
                System.out.println("Burayı boş bırakamazsın");
            } else {
                return girdi;
            }
        }
    }

    public static void ogrenciOku(ArrayList<OgrenciOop> ogrenciler, Scanner input) {
        int diziUzunluk = ogrenciSayisiAl(input);

        for (int i = 0; i < diziUzunluk; i++) {
            String ad = bosOlmayanGirdiAl(input, "İsim: ");
            String soyAd = bosOlmayanGirdiAl(input, "Soyisim: ");
            int not = gecerliSayiAl(input, "Not: ", 0, 100);
            int ogrenciNo = (ogrenciler.size() + 1);
            OgrenciOop yeniOgrenci = new OgrenciOop(ad, soyAd, not, ogrenciNo);
            ogrenciler.add(yeniOgrenci);
        }
    }

    public static int ogrenciBul(ArrayList<OgrenciOop> ogrenciler, int arananNo) {
        for (int i = 0; i < ogrenciler.size(); i++) {
            if (ogrenciler.get(i).getOgrenciNo() == arananNo) {
                return i;
            }
        }
        return -1;
    }

    public static void listeyiYazdir(ArrayList<OgrenciOop> ogrenciler) {
        for (OgrenciOop o : ogrenciler) {
            System.out.println(o.bilgiVer());
        }
    }

    public static void notGuncellemeAkisi(Scanner input, ArrayList<OgrenciOop> ogrenciler) {
        int arananNo = gecerliSayiAl(input, "Notu güncellenecek öğrencinin numarası: ", 1, Integer.MAX_VALUE);
        int ogrenciIndex = ogrenciBul(ogrenciler, arananNo);
        if (ogrenciIndex == -1) {
            System.out.println("Öğrenci bulunamadı.");
        } else {
            int yeniNot = gecerliSayiAl(input, "Yeni not: ", 0, 100);

            if (ogrenciler.get(ogrenciIndex).notGuncelle(yeniNot)) {
                System.out.println("Not güncellendi.");
            } else {
                System.out.println("Geçersiz not, 0-100 arasında olmalı.");
            }
        }
    }

    public static void menuDongusu(ArrayList<OgrenciOop> ogrenciler, Scanner input) {
        while (true) {
            int secim = gecerliSayiAl(input,
                    "%n===MENU===%n1) Öğrenci Ekle%n2) Öğrenci kaydını listele%n3) Not Güncelle%n4) Çıkış%nTercih: ",
                    1, 4);
            switch (secim) {
                case 1:
                    ogrenciOku(ogrenciler, input);
                    break;
                case 2:
                    System.out.printf("%n===Kayıtlı Öğrenciler===%n");
                    listeyiYazdir(ogrenciler);
                    break;
                case 3:
                    notGuncellemeAkisi(input, ogrenciler);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<OgrenciOop> ogrenciler = new ArrayList<>();

        menuDongusu(ogrenciler, input);

        input.close();
    }
}