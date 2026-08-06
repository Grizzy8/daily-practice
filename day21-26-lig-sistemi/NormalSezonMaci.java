public class NormalSezonMaci extends Mac {

    public NormalSezonMaci(Takim evSahibi, Takim deplasman) {
        super(evSahibi, deplasman);
    }

    @Override
    void sonucuIsle() {
        if (getEvSahibiSkor() < getDeplasmanSkor()) {
            getDeplasman().oynananMacEkle();
            getDeplasman().galibiyetEkle();
            getDeplasman().atilanGolEkle(getDeplasmanSkor());
            getDeplasman().yenilenGolEkle(getEvSahibiSkor());

            getEvSahibi().oynananMacEkle();
            getEvSahibi().maglubiyetEkle();
            getEvSahibi().atilanGolEkle(getEvSahibiSkor());
            getEvSahibi().yenilenGolEkle(getDeplasmanSkor());
        } else if (getDeplasmanSkor() < getEvSahibiSkor()) {
            getEvSahibi().oynananMacEkle();
            getEvSahibi().galibiyetEkle();
            getEvSahibi().atilanGolEkle(getEvSahibiSkor());
            getEvSahibi().yenilenGolEkle(getDeplasmanSkor());

            getDeplasman().oynananMacEkle();
            getDeplasman().maglubiyetEkle();
            getDeplasman().atilanGolEkle(getDeplasmanSkor());
            getDeplasman().yenilenGolEkle(getEvSahibiSkor());
        } else {
            getEvSahibi().oynananMacEkle();
            getEvSahibi().beraberlikEkle();
            getEvSahibi().atilanGolEkle(getEvSahibiSkor());
            getEvSahibi().yenilenGolEkle(getDeplasmanSkor());

            getDeplasman().oynananMacEkle();
            getDeplasman().beraberlikEkle();
            getDeplasman().atilanGolEkle(getDeplasmanSkor());
            getDeplasman().yenilenGolEkle(getEvSahibiSkor());
        }
    }
}