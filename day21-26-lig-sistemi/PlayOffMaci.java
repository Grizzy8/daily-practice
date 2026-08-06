public class PlayOffMaci extends Mac {

    public PlayOffMaci(Takim evSahibi, Takim deplasman) {
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
            // TODO: playoff'ta beraberlik geçersiz, Day24'te custom exception ile ele alınacak
        }
    }
}