import java.util.Scanner;

public class TekCift {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Bir sayı giriniz: ");
        if (input.hasNextInt()) {
            int sayi = input.nextInt();
            // yazdığım kontrol negatif sayılar içinde çalışıyor o nedenle negatif/pozitif kontrolü yok
            if (sayi % 2 == 0) {
                System.out.println("Çift");
            } else {
                System.out.println("Tek");
            }
        } else {
            System.out.println("Sayı girsene lan .xd");
        }

        input.close();
    }
}