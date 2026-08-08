import java.util.ArrayList;
import java.util.HashMap;

public class Lig {
    private HashMap<String, Takim> takimlar;
    private ArrayList<Mac> maclar;

    public Lig() {
        this.takimlar = new HashMap<>();
        this.maclar = new ArrayList<>();
    }

    void takimEkle(Takim yeniTakim) throws TakimZatenVarException {
        if (takimlar.containsKey(yeniTakim.getIsim().toUpperCase())) {
            throw new TakimZatenVarException("Takım zaten var");
        } else {
            takimlar.put(yeniTakim.getIsim().toUpperCase(), yeniTakim);
        }
    }

    Takim getTakim(String isim) throws TakimBulunamadiException {
        String aramaIsim = isim.toUpperCase();
        if (takimlar.get(aramaIsim) == null) {
            throw new TakimBulunamadiException("Takım bulunamadı.");
        } else {
            return takimlar.get(aramaIsim);
        }
    }

    void fiksturOlustur() {
        for (Takim ev : takimlar.values()) {
            for (Takim deplasman : takimlar.values()) {
                if (ev != deplasman) {
                    NormalSezonMaci sMac = new NormalSezonMaci(ev, deplasman);
                    macEkle(sMac);
                }
            }
        }
    }

    void macEkle(Mac mac) {
        maclar.add(mac);
    }

    ArrayList<Takim> siraliPuanTablosu(boolean tersMi) {
        ArrayList<Takim> liste = new ArrayList<>(takimlar.values());
        for (int i = 0; i < liste.size() - 1; i++) {
            int oncelikliIndex = i;
            for (int j = i + 1; j < liste.size(); j++) {
                boolean sonuc = oncelikliMi(liste.get(j), liste.get(oncelikliIndex));
                if (tersMi ? !sonuc : sonuc) {
                    oncelikliIndex = j;
                }
            }
            if (liste.get(oncelikliIndex) != liste.get(i)) {
                Takim gecici = liste.get(i);
                liste.set(i, liste.get(oncelikliIndex));
                liste.set(oncelikliIndex, gecici);
            }
        }
        return liste;
    }

    private boolean oncelikliMi(Takim a, Takim b) {
        if (b.puanHesapla() < a.puanHesapla()) {
            return true;
        } else if (b.puanHesapla() == a.puanHesapla()) {
            if (b.averajHesapla() < a.averajHesapla()) {
                return true;
            } else if (b.averajHesapla() == a.averajHesapla()) {
                if (b.getAtilanGol() < a.getAtilanGol()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    void macSkorGir(String evIsim, String deplasmanIsim, int evSkor, int deplasmanSkor)
            throws MacBulunamadiException, MacZatenOynandiException, GecersizSkorException,
            BerabereSonuclanamazException {
        Mac m = macBul(evIsim, deplasmanIsim);
        if (m == null) {
            throw new MacBulunamadiException("Maç bulunamadı.");
        } else {
            if (m.getOynandiMi()) {
                throw new MacZatenOynandiException("Maç oynandı skorları değiştiremezsiniz.");
            } else {
                m.setSkor(evSkor, deplasmanSkor);
                m.sonucuIsle();
            }
        }
    }

    Mac macBul(String evIsim, String deplasmanIsim) {
        for (Mac m : maclar) {
            if (m.getEvSahibi().getIsim().equalsIgnoreCase(evIsim)
                    && m.getDeplasman().getIsim().equalsIgnoreCase(deplasmanIsim)) {
                return m;
            }
        }
        return null;
    }

    void tumMaclariOyna() throws GecersizSkorException, BerabereSonuclanamazException {
        for (Mac m : getMaclar()) {
            if (!m.getOynandiMi()) {
                m.skorlariUret();
                m.sonucuIsle();
            }
        }
    }

    ArrayList<Mac> getMaclar() {
        return new ArrayList<>(maclar);
    }
}