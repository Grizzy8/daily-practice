public class Tasit {
    private String marka;
    private String model;
    private String yakit_turu;
    private String plaka;
    private double km;

    public Tasit(String marka, String model, String yakit_turu, String plaka, double km) {
        this.marka = marka;
        this.model = model;
        this.yakit_turu = yakit_turu;
        this.plaka = plaka;
        this.km = km;
    }

    public double getKm() {
        return km;
    }

    public String getMarkaModel() {
        return marka + " " + model;
    }

    public String getYakitTuru() {
        return yakit_turu;
    }

    @Override
    public String toString() {
        return marka + " " + model + " | Plaka: " + plaka + " | Km: " + km + " | Yakıt: " + yakit_turu;
    }
}