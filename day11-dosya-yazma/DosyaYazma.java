import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class DosyaYazma {

    public static String dosyaAdi(Scanner giris) {
        String secilendosyaAdi = "";
        while (true) {
            System.out.print("Dosya adını girin: ");
            secilendosyaAdi = giris.nextLine();
            if (secilendosyaAdi.isBlank()) {
                System.out.println("Dosya adında boşluk olmaz");
            } else if (secilendosyaAdi.contains("/") || secilendosyaAdi.contains("\\")) {
                // path traversal reddetmek yerine kullanıcıya sormak bilinçli bir tercih
                // solo/öğrenme reposunda kabul edilebilir bir risk olarak gördüm
                System.out.println("Bu klasörden çıkıyorsun, devam edilsin mi?(e/h)");
                String cevap = giris.nextLine();
                if (cevap.equalsIgnoreCase("e")
                        || cevap.equalsIgnoreCase("evet")) {
                    break;
                } else {
                    continue;
                }
            } else {
                break;
            }
        }
        return secilendosyaAdi;
    }

    public static void dosyaYazma(Scanner giris, String DosyaAdi) throws IOException {
        try (FileWriter yazici = new FileWriter("day11-dosya-yazma/" + DosyaAdi + ".txt", true)) {
            String bitirmek = "bitti";
            System.out.println("Yazma işlemini bitirmek için 'bitti' yazın");
            while (true) {
                System.out.println("Dosyaya ne yazılacak?");
                String satir = giris.nextLine();
                if (satir.equalsIgnoreCase(bitirmek)) {
                    break;
                } else {
                    yazici.write(satir + "\n");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in);

        try {
            String dosyaAdi = dosyaAdi(giris);
            dosyaYazma(giris, dosyaAdi);
        } catch (IOException e) {
            System.out.println("Dosyaya yazarken hata oluştu");
        }

        giris.close();
    }
}