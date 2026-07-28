import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Kitap {
    private String kitapAdi, kitapTuru, yazarAdi;
    private int sayfaSayisi;

    Kitap(String kitapAdi, String kitapTuru, String yazarAdi, int sayfaSayisi) {
        this.kitapAdi = kitapAdi;
        this.kitapTuru = kitapTuru;
        this.yazarAdi = yazarAdi;
        this.sayfaSayisi = sayfaSayisi;
    }

    @Override
    public String toString() {
        return "Adı: " + kitapAdi + " | Tür: " + kitapTuru + " | Yazar: " + yazarAdi + " | Sayfa: " + sayfaSayisi;
    }

    public static void kitapEkle(ArrayList<Kitap> kitaplik, Scanner giris) {
        int eklenecekKitap = 1;
        while (true) {
            System.out.print("Eklenecek kitap sayısı: ");
            if (giris.hasNextInt()) {
                eklenecekKitap = giris.nextInt();
                giris.nextLine();
                if (0 < eklenecekKitap) {
                    break;
                } else {
                    System.out.println("En az 1 kitap eklemelisin");
                }
            } else {
                System.out.println("Sayı gir!");
                giris.nextLine();
            }
        }

        for (int i = 0; i < eklenecekKitap; i++) {
            System.out.print("Kitap adı: ");
            String kitapAdi = giris.nextLine().toLowerCase();
            System.out.print("Kitabın türü: ");
            String kitapTuru = giris.nextLine().toLowerCase();
            System.out.print("Yazarın adı: ");
            String yazarAdi = giris.nextLine().toLowerCase();
            int sayfaSayisi = 0;
            while (true) {
                System.out.print("Sayfa sayısı: ");
                if (giris.hasNextInt()) {
                    sayfaSayisi = giris.nextInt();
                    giris.nextLine();
                    if (0 < sayfaSayisi) {
                        break;
                    } else {
                        System.out.println("Sayfa sayısı en az 1 olmalı");
                    }
                } else {
                    System.out.println("Sayfa sayısını sayısal olarak belirtin");
                    giris.nextLine();
                }
            }
            Kitap yeniKitap = new Kitap(kitapAdi, kitapTuru, yazarAdi, sayfaSayisi);
            kitaplik.add(yeniKitap);
        }
    }

    public static void bilgileriYazdir(ArrayList<Kitap> kitaplik) {
        for (Kitap k : kitaplik) {
            System.out.println(k.toString());
        }
    }

    public static void kitapAdiAra(ArrayList<Kitap> kitaplik, Scanner giris) {
        System.out.print("Aranan kitap adı: ");
        String arananKitap = giris.nextLine().toLowerCase();

        boolean bulundu = false;
        for (Kitap k : kitaplik) {
            if (k.kitapAdi.equals(arananKitap)) {
                bulundu = true;
                break;
            }
        }
        if (bulundu) {
            System.out.println("Kitaplıkta var :D");
        } else {
            System.out.println("kitap bulunamadı :(");
        }
    }

    public static void dosyayaKaydetmek(ArrayList<Kitap> kitaplik) throws IOException {
        try (PrintWriter yazdir = new PrintWriter(new FileWriter("day13-kitaplik-sistemi/Liste.txt", true))) {
            for (Kitap k : kitaplik) {
                yazdir.print(k.toString() + "\n");
            }
            System.out.println("Kitaplar Liste.txt dosyasına kaydedildi.");
        }
    }

    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in);
        ArrayList<Kitap> kitaplik = new ArrayList<>();

        kitapEkle(kitaplik, giris);
        bilgileriYazdir(kitaplik);
        kitapAdiAra(kitaplik, giris);
        try {
            dosyayaKaydetmek(kitaplik);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(
                    "Liste.txt kaydedilemedi, programı proje kök dizininden (daily-practice) çalıştırdığınızdan emin olun");
        }

        giris.close();
    }
}