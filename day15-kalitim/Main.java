import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Kisi kisiOku(Scanner input) {
        System.out.print("İsim: ");
        String ad = input.nextLine();
        System.out.print("Soyisim: ");
        String soyAd = input.nextLine();
        System.out.print("Telefon No: ");
        String telefon = input.nextLine();
        System.out.print("Cinsiyet: ");
        String cinsiyet = input.nextLine();

        int yas = 1;
        while (true) {
            System.out.print("Yaş: ");
            if (input.hasNextInt()) {
                yas = input.nextInt();
                input.nextLine();
                if (yas <= 0) {
                    System.out.println("En az 1 yaşında olmalısınız");
                } else {
                    break;
                }
            } else {
                System.out.println("Yaşınızı sayılarla girin!");
                input.nextLine();
            }
        }

        return new Kisi(ad, soyAd, telefon, cinsiyet, yas);
    }

    public static Ogretmen ogretmenOku(Scanner input) {
        Kisi temel = kisiOku(input);

        System.out.print("Branş: ");
        String brans = input.nextLine();
        System.out.print("Sicil No: ");
        String sicilNo = input.nextLine();
        System.out.print("Unvan: ");
        String unvan = input.nextLine();

        return new Ogretmen(temel.getAd(), temel.getSoyAd(), temel.getTelefon(), temel.getCinsiyet(), temel.getYas(),
                brans, sicilNo, unvan);
    }

    public static Ogrenci ogrenciOku(Scanner input) {
        Kisi temel = kisiOku(input);

        int ogrenciNo = 0;
        int not = 0;

        while (true) {
            System.out.print("Öğrenci No: ");
            if (input.hasNextInt()) {
                ogrenciNo = input.nextInt();
                input.nextLine();
                if (ogrenciNo < 0) {
                    System.out.println("Öğrenci numaranız sadece pozitif olabilir");
                } else {
                    break;
                }
            } else {
                System.out.println("Öğrenci numaranızı sayılarla girin!");
                input.nextLine();
            }
        }

        while (true) {
            System.out.print("Not: ");
            if (input.hasNextInt()) {
                not = input.nextInt();
                input.nextLine();
                if (not < 0 || 100 < not) {
                    System.out.println("Notunuz 0-100 aralığında olmalıdır.");
                } else {
                    break;
                }
            } else {
                System.out.println("Notunuzu sayılarla girin!");
                input.nextLine();
            }
        }

        System.out.print("Sınıf: ");
        String sinif = input.nextLine();

        return new Ogrenci(temel.getAd(), temel.getSoyAd(), temel.getTelefon(), temel.getCinsiyet(), temel.getYas(),
                ogrenciNo,
                not, sinif);
    }

    public static void listeyiYazdir(ArrayList<Kisi> kisiler) {
        for (Kisi k : kisiler) {
            System.out.println(k.bilgiVer());
        }
    }

    public static void main(String[] args) {
        ArrayList<Kisi> kisiler = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        while (true) {
            int secim = 1;

            while (true) {
                System.out.printf(
                        "1) Kişi%n2) Öğretmen%n3) Öğrenci%n4) Bitir ve Listele%nHangisini eklemek istiyorsun?%nCevap: ");
                if (input.hasNextInt()) {
                    secim = input.nextInt();
                    input.nextLine();
                    break;
                } else {
                    System.out.println("1/2/3/4 numaralarından birini seçin!");
                    input.nextLine();
                }
            }
            if (secim == 1) {
                kisiler.add(kisiOku(input));
            } else if (secim == 2) {
                kisiler.add(ogretmenOku(input));
            } else if (secim == 3) {
                kisiler.add(ogrenciOku(input));
            } else {
                break;
            }
        }

        listeyiYazdir(kisiler);

        input.close();
    }
}