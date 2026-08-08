import java.util.Scanner;

public class LigMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Lig lig1 = new Lig();
        LigArayuzu arayuz = new LigArayuzu(lig1);
        arayuz.calistir(input);

        input.close();
    }
}