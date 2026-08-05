public class Otomobil extends Tasit {
    private int bagajHacmi;

    public Otomobil(String marka, String model, String yakit_turu, String plaka, double km, int bagajHacmi) {
        super(marka, model, yakit_turu, plaka, km);
        this.bagajHacmi = bagajHacmi;
    }

    public int getBagajHacmi() {
        return bagajHacmi;
    }

    @Override
    public String toString() {
        return super.toString() + " | Bagaj Hacmi: " + bagajHacmi;
    }
}