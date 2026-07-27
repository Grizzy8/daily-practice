import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DosyaOkuma {

    public static String dosyaAdi(Scanner giris) {
        System.out.printf("Aradığınız dosyanın adı nedir?%nCevap: ");
        String dosyaAdi = giris.nextLine();

        return "day11-dosya-yazma/" + dosyaAdi + ".txt";
    }

    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in);
        try {
            Scanner dosyaOkuyucu = new Scanner(new File(dosyaAdi(giris)));

            int satirSayisi = 0;
            while (dosyaOkuyucu.hasNextLine()) {
                System.out.println(dosyaOkuyucu.nextLine());
                satirSayisi++;
            }
            System.out.println("Toplam satır sayısı: " + satirSayisi);
            dosyaOkuyucu.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya okunurken bir hata oluştu.");
        }

        giris.close();
    }
}