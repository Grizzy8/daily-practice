abstract class Mac {
    private Takim evSahibi;
    private Takim deplasman;
    private int evSahibiSkor;
    private int deplasmanSkor;

    abstract void sonucuIsle();

    protected Takim getEvSahibi() {
        return evSahibi;
    }

    protected Takim getDeplasman() {
        return deplasman;
    }

    protected int getEvSahibiSkor() {
        return evSahibiSkor;
    }

    protected int getDeplasmanSkor() {
        return deplasmanSkor;
    }
}