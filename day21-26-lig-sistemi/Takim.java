public class Takim {
    private String isim;
    private int galibiyet;
    private int beraberlik;
    private int maglubiyet;
    private int atilanGol;
    private int yenilenGol;

    public Takim(String isim, int galibiyet, int beraberlik, int maglubiyet, int atilanGol,
            int yenilenGol) {
        this.isim = isim;
        this.galibiyet = galibiyet;
        this.beraberlik = beraberlik;
        this.maglubiyet = maglubiyet;
        this.atilanGol = atilanGol;
        this.yenilenGol = yenilenGol;
    }

    void galibiyetEkle() {
        galibiyet++;
    }

    void beraberlikEkle() {
        beraberlik++;
    }

    void maglubiyetEkle() {
        maglubiyet++;
    }

    void atilanGolEkle(int atilanGol) {
        this.atilanGol += atilanGol;
    }

    void yenilenGolEkle(int yenilenGol) {
        this.yenilenGol += yenilenGol;
    }

    String getIsim() {
        return isim;
    }

    int oynananMacHesapla() {
        return galibiyet + beraberlik + maglubiyet;
    }

    int getGalibiyet() {
        return galibiyet;
    }

    int getBeraberlik() {
        return beraberlik;
    }

    int getMaglubiyet() {
        return maglubiyet;
    }

    int getAtilanGol() {
        return atilanGol;
    }

    int getYenilenGol() {
        return yenilenGol;
    }

    int averajHesapla() {
        return atilanGol - yenilenGol;
    }

    int puanHesapla() {
        return (galibiyet * 3) + beraberlik;
    }

    @Override
    public String toString() {
        return "Takım: " + isim + " | OM: " + oynananMacHesapla() + " G: " + galibiyet + " B: " + beraberlik + " M: "
                + maglubiyet
                + " AG: " + atilanGol + " YG: " + yenilenGol + " A: " + averajHesapla();
    }
}