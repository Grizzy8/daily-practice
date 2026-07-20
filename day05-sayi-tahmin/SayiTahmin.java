import java.util.Scanner;

public class SayiTahmin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int rastgeleSayi = (int) (Math.random() * 100);
        int denemeSayac = 0;

        while (denemeSayac < 5) {
            System.out.print("Bir sayı tahmin et (5 tahmin hakkın var): ");
            int tahminSayi = in.nextInt();

            if (rastgeleSayi == tahminSayi) {
                System.out.println((denemeSayac + 1) + ". denemede doğru buldun");
                break;
            } else {
                System.out.println("Yanlış tahmin");
                if (rastgeleSayi < tahminSayi) {
                    System.out.println("Daha küçük bir sayı tahmin et");
                } else {
                    System.out.println("Daha büyük bir sayi tahmin et");
                }
                denemeSayac++;
            }
        }
        in.close();
    }
}