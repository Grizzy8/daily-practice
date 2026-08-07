import java.util.ArrayList;
import java.util.HashMap;

public class Lig {
    private HashMap<String, Takim> takimlar;
    private ArrayList<Mac> maclar;

    public Lig() {
        this.takimlar = new HashMap<>();
        this.maclar = new ArrayList<>();
    }

    void takimEkle(Takim yeniTakim) {
        takimlar.put(yeniTakim.getIsim(), yeniTakim);
    }

    Takim getTakim(String isim) {
        return takimlar.get(isim);
    }

    void macEkle(Mac mac) {
        maclar.add(mac);
    }

    ArrayList<Mac> getMaclar() {
        return new ArrayList<>(maclar);
    }

    void tumMaclariOyna() {
        for (Mac m : getMaclar()) {
            m.setSkor(rastgeleSkorOlustur(), rastgeleSkorOlustur());
            m.sonucuIsle();
        }
    }

    void fiksturOlustur() {
        for (Takim ev : takimlar.values()) {
            for (Takim deplasman : takimlar.values()) {
                if (ev != deplasman) {
                    NormalSezonMaci sMac = new NormalSezonMaci(ev, deplasman);
                    maclar.add(sMac);
                }
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

    void puanTablosunuYazdir(boolean tersMi) {
        ArrayList<Takim> liste = siraliPuanTablosu(tersMi);
        System.out.println("________________________________________________________________________");
        System.out.printf("| %-4s | %-13s | %3s | %3s | %3s | %3s | %3s | %3s | %3s | %3s |%n", "Sıra", "Takım", "OM",
                "G", "B", "M", "AG", "YG", "A", "P");
        for (int i = 0; i < liste.size(); i++) {
            Takim t = liste.get(i);
            System.out.printf("| %4d | %-13s | %3d | %3d | %3d | %3d | %3d | %3d | %3d | %3d |%n", (i + 1), t.getIsim(),
                    t.oynananMacHesapla(), t.getGalibiyet(), t.getBeraberlik(), t.getMaglubiyet(), t.getAtilanGol(),
                    t.getYenilenGol(), t.averajHesapla(), t.puanHesapla());
        }
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

    private int rastgeleSkorOlustur() {
        return (int) (Math.random() * 6);
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
}