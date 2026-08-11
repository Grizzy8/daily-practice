public class EnUzunSeriSonucu {
    private Takim takim;
    private int seri;

    EnUzunSeriSonucu(Takim takim, int seri) {
        this.takim = takim;
        this.seri = seri;
    }

    Takim getTakim() {
        return takim;
    }

    int getSeri() {
        return seri;
    }
}