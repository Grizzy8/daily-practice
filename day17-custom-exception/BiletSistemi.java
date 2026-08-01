public class BiletSistemi {
    private final int kapasite;
    private Musteri[] koltuklar;

    public BiletSistemi(int kapasite) {
        this.kapasite = kapasite;
        koltuklar = new Musteri[kapasite];
    }

    public int getKapasite() {
        return kapasite;
    }

    public int getBosKoltukSayisi() {
        int sayac = 0;
        for (Musteri m : koltuklar) {
            if (m == null) {
                sayac++;
            }
        }
        return sayac;
    }

    public boolean koltukBosMu(int index) {
        return koltuklar[index] == null;
    }

    public void rezervasyonYap(Musteri musteri, int koltukNo)
            throws GecersizKoltukException, KoltukDoluException {
        if (koltukNo < 0 || koltuklar.length <= koltukNo) {
            throw new GecersizKoltukException(
                    "Geçersiz koltuk numarası. Lütfen 1 ile " + kapasite + " arasında bir numara girin.");
        } else if (koltuklar[koltukNo] != null) {
            throw new KoltukDoluException(
                    "Seçtiğiniz koltuk başka bir müşteri tarafından satın alınmıştır. Lütfen başka bir koltuk seçin");
        } else {
            koltuklar[koltukNo] = musteri;
        }
    }
}

class KoltukDoluException extends Exception {
    KoltukDoluException(String mesaj) {
        super(mesaj);
    }
}

class GecersizKoltukException extends Exception {
    GecersizKoltukException(String mesaj) {
        super(mesaj);
    }
}
