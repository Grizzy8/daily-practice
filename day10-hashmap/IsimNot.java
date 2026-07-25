import java.util.HashMap;
import java.util.Scanner;

public class IsimNot {

    public static int sayiOku(Scanner giris) {
        System.out.printf("Listede kaç kişi var?%nCevap: ");
        while (!giris.hasNextInt()) {
            giris.nextLine();
            System.out.printf("Sayı gir%nCevap: ");
        }
        int listeUzunluk = giris.nextInt();
        giris.nextLine();
        return listeUzunluk;
    }

    public static void kayitEkle(HashMap<String, Integer> liste, Scanner giris) {
        int listeUzunluk = sayiOku(giris);

        for (int i = 0; i < listeUzunluk; i++) {
            System.out.print((i + 1) + ". İsim: ");
            String isim = giris.nextLine().toLowerCase().trim();
            while(true){
                if(liste.containsKey(isim)){
                    System.out.print("Bu isim zaten kayıtlı, farklı bir isim girin: ");
                    isim = giris.nextLine().toLowerCase().trim();
                } else {
                    break;
                }
            }

            System.out.print("Notu: ");
            while (!giris.hasNextInt()) {
                giris.nextLine();
                System.out.print("Notu sayısal olarak yaz: ");
            }
            int not = giris.nextInt();
            giris.nextLine();
            liste.put(isim, not);
        }
    }

    public static void kayitAra(HashMap<String, Integer> kayit, Scanner giris) {
        System.out.printf("Aradığınız isim nedir?%nCevap: ");
        String arananIsim = giris.nextLine().toLowerCase().trim();

        if (kayit.containsKey(arananIsim)) {
            System.out.println(kayit.get(arananIsim));
        } else {
            System.out.println("Kayıtlarda bu isim yok");
        }
    }

    public static void tumKayitlariYazdir(HashMap<String, Integer> kayit) {
        System.out.println("----- Tam Liste -----");
        for (String k : kayit.keySet()) {
            System.out.println(k + " : " + kayit.get(k));
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> kayit = new HashMap<>();
        Scanner giris = new Scanner(System.in);

        kayitEkle(kayit, giris);
        kayitAra(kayit, giris);
        tumKayitlariYazdir(kayit);

        giris.close();
    }
}