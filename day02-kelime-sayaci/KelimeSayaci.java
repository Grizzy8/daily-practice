import java.util.Scanner;

public class KelimeSayaci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Cümle: ");
        String cümle = input.nextLine();

        // noktalama işaretlerini kaldırma
        cümle = cümle.replaceAll("[.,'*!?]", "");
        String[] kelimeler = cümle.split("\\s+");

        // kelime sayma
        System.out.println("Toplam kelime sayısı: " + kelimeler.length);

        for (String k : kelimeler) {
            System.out.print(k + " / ");
        }

        System.out.println();

        // en uzun kelimeyi bulma
        String enUzunKelime = kelimeler[0];
        for (int i = 0; i < kelimeler.length; i++) {
            if (kelimeler[i].length() > enUzunKelime.length()) {
                enUzunKelime = kelimeler[i];
            }
        }
        System.out.println("En uzun kelime: " + enUzunKelime);

        input.close();
    }
}