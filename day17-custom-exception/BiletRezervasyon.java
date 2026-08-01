import java.util.Scanner;

public class BiletRezervasyon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        BiletSistemi sistem = new BiletSistemi(20);
        KullaniciArayuzu arayuz = new KullaniciArayuzu(sistem, input);
        arayuz.menuDongusu();

        input.close();
    }
}
