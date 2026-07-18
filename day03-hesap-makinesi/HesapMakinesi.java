import java.util.Scanner;

public class HesapMakinesi {

    public static double toplama(int sayi1, int sayi2) {
        return sayi1 + sayi2;
    }

    public static double cikarma(int sayi1, int sayi2) {
        return sayi1 - sayi2;
    }

    public static double carpma(int sayi1, int sayi2) {
        return sayi1 * sayi2;
    }

    public static double bolme(int sayi1, int sayi2) {
        return (double) sayi1 / sayi2;
    }

    public static int sayiOku(Scanner in, String etiket) {
        while (true) {
            System.out.print(etiket);
            if (in.hasNextInt()) {
                return in.nextInt();
            }
            System.out.println("Hesaplamak için sayı girmen gerekmez mi hahahah");
            in.next();
        }
    }

    public static void islemOku(String islem, int sayi1, int sayi2) {
        switch (islem) {
            case "+":
                System.out.println(toplama(sayi1, sayi2));
                break;
            case "-":
                System.out.println(cikarma(sayi1, sayi2));
                break;
            case "*":
                System.out.println(carpma(sayi1, sayi2));
                break;
            case "x":
                System.out.println(carpma(sayi1, sayi2));
                break;
            case "/":
                if (sayi2 == 0) {
                    System.out.println("Sıfıra bölme yapılmaz yalnız akıllı ol :D");
                } else {
                    System.out.println(bolme(sayi1, sayi2));
                }
                break;
            default:
                System.out.println("yanlış işlemler yapıyorsun");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int sayi1 = sayiOku(in, "1. sayı: ");
        int sayi2 = sayiOku(in, "2. sayı: ");
        in.nextLine();
        
        System.out.print("İşlem?");
        String islem = in.nextLine();

        islemOku(islem, sayi1, sayi2);

        in.close();
    }
}