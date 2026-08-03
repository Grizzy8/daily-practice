public class Film {
    private String isim;
    private int yil;
    private double puan;

    public Film(String isim, int yil, double puan) {
        this.isim = isim;
        this.yil = yil;
        this.puan = puan;
    }

    public String getIsim() {
        return isim;
    }

    public int getYil() {
        return yil;
    }

    public double getPuan() {
        return puan;
    }

    @Override
    public String toString() {
        return "İsim: " + isim + " | Yıl: " + yil + " | Puan: " + puan;
    }
}