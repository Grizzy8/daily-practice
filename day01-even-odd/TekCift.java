import java.util.Scanner;

public class TekCift {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Bir sayı giriniz: ");
        int sayi1 = input.nextInt();

        if (sayi1 % 2 == 0) {
            System.out.println("Çift");
        } else {
            System.out.println("Tek");
        }
    }
}
