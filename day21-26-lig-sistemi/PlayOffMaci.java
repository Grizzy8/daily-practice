public class PlayOffMaci extends Mac {

    public PlayOffMaci(Takim evSahibi, Takim deplasman) {
        super(evSahibi, deplasman);
    }

    @Override
    protected void skorlariUret() throws GecersizSkorException {
        boolean gecerliSkor = false;
        while (!gecerliSkor) {
            int evSkor = rastgeleSkorOlustur();
            int deplasmanSkor = rastgeleSkorOlustur();

            if (evSkor != deplasmanSkor) {
                setSkor(evSkor, deplasmanSkor);
                gecerliSkor = true;
            }
        }
    }

    @Override
    void sonucuHesapla() throws BerabereSonuclanamazException {
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
            throw new BerabereSonuclanamazException("Berabere sonuclanamaz.");
        }
    }
}