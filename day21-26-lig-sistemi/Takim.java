public class Takim {
    private String isim;
    private int oynananMac;
    private int galibiyet;
    private int maglubiyet;
    private int beraberlik;
    private int atilanGol;
    private int yenilenGol;

    public Takim(String isim, int oynananMac, int galibiyet, int beraberlik, int maglubiyet, int atilanGol,
            int yenilenGol) {
        this.isim = isim;
        this.oynananMac = oynananMac;
        this.galibiyet = galibiyet;
        this.beraberlik = beraberlik;
        this.maglubiyet = maglubiyet;
        this.atilanGol = atilanGol;
        this.yenilenGol = yenilenGol;
    }

    public String getIsim() {
        return isim;
    }

    public int puanHesapla() {
        return (galibiyet * 3) + beraberlik;
    }

    public int averajHesapla() {
        return atilanGol - yenilenGol;
    }

    public void oynananMacEkle() {
        oynananMac++;
    }

    public void galibiyetEkle() {
        galibiyet++;
    }

    public void maglubiyetEkle() {
        maglubiyet++;
    }

    public void beraberlikEkle() {
        beraberlik++;
    }

    public void atilanGolEkle(int atilanGol) {
        this.atilanGol += atilanGol;
    }

    public void yenilenGolEkle(int yenilenGol) {
        this.yenilenGol += yenilenGol;
    }

    @Override
    public String toString() {
        return "Takım: " + isim + " | OM: " + oynananMac + " G: " + galibiyet + " B: " + beraberlik + " M: " + maglubiyet
                + " AG: " + atilanGol + " YG: " + yenilenGol + " A: " + averajHesapla();
    }
}