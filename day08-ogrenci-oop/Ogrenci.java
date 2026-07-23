import java.util.Scanner;

public class Ogrenci {
    String ad, soyAd;
    int not;

    Ogrenci(String ad, String soyAd, int not) {
        this.ad = ad;
        this.soyAd = soyAd;
        this.not = not;
    }

    public String bilgiVer() {
        return ad + " " + soyAd + " | Not: " + not;
    }

    public void notGuncelle(int yeniNot) {
        this.not = yeniNot;
    }

    public static void main(String[] args) {

        Scanner inputt = new Scanner(System.in);

        Ogrenci[] ogrenciler = new Ogrenci[6];

        ogrenciler[0] = new Ogrenci("Derin", "Deniz", 78);
        ogrenciler[1] = new Ogrenci("Rüzgar", "Karacan", 69);
        ogrenciler[2] = new Ogrenci("Aylin", "Erdem", 90);
        ogrenciler[3] = new Ogrenci("Selen", "Akdeniz", 83);
        ogrenciler[4] = new Ogrenci("Emre", "Yaman", 100);
        ogrenciler[5] = new Ogrenci("Barış", "Soylu", 60);

        for (int i = 0; i < ogrenciler.length; i++) {
            System.out.println(ogrenciler[i].bilgiVer());
        }

        ogrenciler[1].notGuncelle(76);
        System.out.println(ogrenciler[1].ad + "'ın yeni notu: " + ogrenciler[1].not);

        inputt.close();
    }
}