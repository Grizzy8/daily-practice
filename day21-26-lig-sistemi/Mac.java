abstract class Mac {
    private Takim evSahibi;
    private Takim deplasman;
    private int evSahibiSkor;
    private int deplasmanSkor;
    private boolean oynandiMi;

    Mac(Takim evSahibi, Takim deplasman) {
        this.evSahibi = evSahibi;
        this.deplasman = deplasman;
        oynandiMi = false;
    }

    void setSkor(int evSahibiSkor, int deplasmanSkor) throws GecersizSkorException {
        if (evSahibiSkor < 0 || deplasmanSkor < 0) {
            throw new GecersizSkorException("Negatif skor olamaz");
        } else {
            this.evSahibiSkor = evSahibiSkor;
            this.deplasmanSkor = deplasmanSkor;
        }
    }

    final void sonucuIsle() throws BerabereSonuclanamazException {
        sonucuHesapla();
        oynandiMi = true;
    }

    abstract void sonucuHesapla() throws BerabereSonuclanamazException;

    protected int getEvSahibiSkor() {
        return evSahibiSkor;
    }

    protected int getDeplasmanSkor() {
        return deplasmanSkor;
    }

    Takim getEvSahibi() {
        return evSahibi;
    }

    Takim getDeplasman() {
        return deplasman;
    }

    boolean getOynandiMi() {
        return oynandiMi;
    }

    abstract void skorlariUret() throws GecersizSkorException;

    protected int rastgeleSkorOlustur() {
        return (int) (Math.random() * 6);
    }
}