import java.util.ArrayList;
import java.util.Scanner;

public class KelimeSayaci {

    public static String[] temizleVeAyir(String cumle) {
        return cumle.replaceAll("[.,'*!?]", "").split("\\s+");
    }

    public static ArrayList<String> enUzunKelimelerBul(String[] kelimeler) {
        ArrayList<String> enUzunKelimeler = new ArrayList<>();
        int enUzunUzunluk = kelimeler[0].length();
        for (int i = 0; i < kelimeler.length; i++) {
            if (enUzunUzunluk < kelimeler[i].length()) {
                enUzunKelimeler.clear();
                enUzunUzunluk = kelimeler[i].length();
                enUzunKelimeler.add(kelimeler[i]);
            } else if (enUzunUzunluk == kelimeler[i].length()) {
                enUzunKelimeler.add(kelimeler[i]);
            }
        }
        return enUzunKelimeler;
    }

    public static void enUzunKelimeleriYazdir(ArrayList<String> kelimeler){
        for (int i = 0; i < kelimeler.size(); i++){
            System.out.println((i+1) + ". bulunan en uzun kelime: " + kelimeler.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Cümle: ");
        String cümle = input.nextLine();
        String[] kelimeler = temizleVeAyir(cümle);

        System.out.println("Toplam kelime sayısı: " + kelimeler.length);

        enUzunKelimeleriYazdir(enUzunKelimelerBul(kelimeler));

        input.close();
    }
}