abstract class Mac {
    private Takim evSahibi;
    private Takim deplasman;
    private int evSahibiSkor;
    private int deplasmanSkor;

    Mac(Takim evSahibi, Takim deplasman) {
        this.evSahibi = evSahibi;
        this.deplasman = deplasman;
    }

    abstract void sonucuIsle();

    Takim getEvSahibi() {
        return evSahibi;
    }

    Takim getDeplasman() {
        return deplasman;
    }

    protected int getEvSahibiSkor() {
        return evSahibiSkor;
    }

    protected int getDeplasmanSkor() {
        return deplasmanSkor;
    }

    void setSkor(int evSahibiSkor, int deplasmanSkor) {
        this.evSahibiSkor = evSahibiSkor;
        this.deplasmanSkor = deplasmanSkor;
    }
}