public class PlayOffMaci extends Mac {

    public PlayOffMaci(Takim evSahibi, Takim deplasman) {
        super(evSahibi, deplasman);
    }

    @Override
    void setSkor(int evSahibiSkor, int deplasmanSkor) throws GecersizSkorException, BerabereSonuclanamazException {
        if (evSahibiSkor == deplasmanSkor) {
            throw new BerabereSonuclanamazException("Berabere sonuçlanamaz.");
        }
        super.setSkor(evSahibiSkor, deplasmanSkor);
    }

    @Override
    protected void skorlariUret() throws GecersizSkorException, BerabereSonuclanamazException {
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
            // setSkor() zaten berabereyi engelliyor, buraya normalde ulaşılmaması gerekiyor
            throw new BerabereSonuclanamazException("Berabere sonuclanamaz.");
        }
    }

    @Override
    protected String macTipi() {
        return "PLAYOFF";
    }
}