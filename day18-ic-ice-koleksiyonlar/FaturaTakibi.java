import java.util.Scanner;

public class FaturaTakibi {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        FaturaSistemi sistem = new FaturaSistemi();
        FaturaKullaniciArayuzu arayuz = new FaturaKullaniciArayuzu(sistem, input);
        arayuz.menuDongusu();

        input.close();
    }
}