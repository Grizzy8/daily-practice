import java.util.Scanner;

public class HesapMakinesi {

    public static double toplama(double sayi1, double sayi2) {
        return sayi1 + sayi2;
    }

    public static double cikarma(double sayi1, double sayi2) {
        return sayi1 - sayi2;
    }

    public static double carpma(double sayi1, double sayi2) {
        return sayi1 * sayi2;
    }

    public static double bolme(double sayi1, double sayi2) throws ArithmeticException {
        if (sayi2 == 0)
            throw new ArithmeticException("Sıfıra bölme işlemi tanımsızdır.");
        return sayi1 / sayi2;
    }

    public static double mod(double sayi1, double sayi2) {
        return sayi1 % sayi2;
    }

    public static double us(double sayi1, int sayi2) {
        double us = 1;
        for (int i = 0; i < sayi2; i++) {
            us *= sayi1;
        }
        return us;
    }

    public static double sayiOku(Scanner in, String etiket) {
        while (true) {
            System.out.print(etiket);
            if (in.hasNextDouble()) {
                return in.nextDouble();
            }
            System.out.println("Hesaplamak için sayı girmelisin");
            in.nextLine();
        }
    }

    public static void islemOku(Scanner in, double sayi1, double sayi2) {

        while (true) {
            System.out.print("İşlem seçin (+, -, x, /, %, ^): ");
            String islem = in.nextLine();

            switch (islem) {
                case "+":
                    System.out.println(toplama(sayi1, sayi2));
                    return;
                case "-":
                    System.out.println(cikarma(sayi1, sayi2));
                    return;
                case "*", "x":
                    System.out.println(carpma(sayi1, sayi2));
                    return;
                case "/":
                    try {
                        System.out.println(bolme(sayi1, sayi2));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    return;
                case "%":
                    System.out.println(mod(sayi1, sayi2));
                    return;
                case "^":
                    System.out.println(us(sayi1, (int) sayi2));
                    return;
                default:
                    System.out.println("Yanlış işlem yapıyorsun");

            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double sayi1 = sayiOku(in, "1. sayı: ");
        double sayi2 = sayiOku(in, "2. sayı (Üslü işlemlerde sadece tam sayılar kabul edilir): ");
        in.nextLine();

        islemOku(in, sayi1, sayi2);

        in.close();
    }
}