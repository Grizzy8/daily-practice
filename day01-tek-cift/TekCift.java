import java.util.Scanner;

public class TekCift {

    public static String tekCiftKontrol(int sayi) {
        // negatif sayılar içinde çalışıyor o nedenle negatif/pozitif kontrolü yok
        if (sayi % 2 == 0) {
            return "Çift";
        } else {
            return "Tek";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Bir sayı giriniz: ");
        while (!input.hasNextInt()) {
            input.nextLine();
            System.out.printf("Sayı girsene lan .xd%nYeni sayı: ");
        }
        int sayi = input.nextInt();
        System.out.println(tekCiftKontrol(sayi));

        input.close();
    }
}