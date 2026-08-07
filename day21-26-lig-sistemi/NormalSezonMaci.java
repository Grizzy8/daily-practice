public class NormalSezonMaci extends Mac {

    public NormalSezonMaci(Takim evSahibi, Takim deplasman) {
        super(evSahibi, deplasman);
    }

    @Override
    void sonucuIsle() {
        if (getEvSahibiSkor() < getDeplasmanSkor()) {
            getDeplasman().galibiyetEkle();
            getDeplasman().atilanGolEkle(getDeplasmanSkor());
            getDeplasman().yenilenGolEkle(getEvSahibiSkor());

            getEvSahibi().maglubiyetEkle();
            getEvSahibi().atilanGolEkle(getEvSahibiSkor());
            getEvSahibi().yenilenGolEkle(getDeplasmanSkor());
        } else if (getDeplasmanSkor() < getEvSahibiSkor()) {
            getEvSahibi().galibiyetEkle();
            getEvSahibi().atilanGolEkle(getEvSahibiSkor());
            getEvSahibi().yenilenGolEkle(getDeplasmanSkor());

            getDeplasman().maglubiyetEkle();
            getDeplasman().atilanGolEkle(getDeplasmanSkor());
            getDeplasman().yenilenGolEkle(getEvSahibiSkor());
        } else {
            getEvSahibi().beraberlikEkle();
            getEvSahibi().atilanGolEkle(getEvSahibiSkor());
            getEvSahibi().yenilenGolEkle(getDeplasmanSkor());

            getDeplasman().beraberlikEkle();
            getDeplasman().atilanGolEkle(getDeplasmanSkor());
            getDeplasman().yenilenGolEkle(getEvSahibiSkor());
        }
    }
}