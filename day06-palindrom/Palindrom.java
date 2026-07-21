import java.util.Scanner;

public class Palindrom {

    public static void palindromKontrol(String cumle) {
        int i = 0;
        int j = cumle.length() - 1;

        while (i < j) {
            if (cumle.charAt(i) != cumle.charAt(j)) {
                System.out.println("Palindrom degil");
                return;
            } else {
                i++;
                j--;
            }
        }
        System.out.println("Palindrom");
    }

    public static void main(String[] args) {
        Scanner inn = new Scanner(System.in);

        System.out.print("Cümle gir: ");
        String kelime = inn.nextLine().toLowerCase().replaceAll("\\s+", "");

        palindromKontrol(kelime);

        inn.close();
    }
}