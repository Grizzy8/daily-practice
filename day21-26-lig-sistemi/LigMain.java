import java.util.Scanner;

public class LigMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Lig lig1 = new Lig();

        Takim takim1 = new Takim("a", 0, 0, 0, 0, 0, 0);
        Takim takim2 = new Takim("b", 0, 0, 0, 0, 0, 0);
        Takim takim3 = new Takim("c", 0, 0, 0, 0, 0, 0);
        lig1.takimEkle(takim1);
        lig1.takimEkle(takim2);
        lig1.takimEkle(takim3);

        System.out.println(lig1.getTakim("a"));
        System.out.println(lig1.getTakim("b"));
        System.out.println(lig1.getTakim("c"));

        lig1.fiksturOlustur();

        lig1.tumMaclariOyna();

        System.out.println("\ntumMaclariOyna()'dan sonra\n");
        System.out.println(lig1.getTakim("a"));
        System.out.println(lig1.getTakim("b"));
        System.out.println(lig1.getTakim("c"));

        input.close();
    }
}