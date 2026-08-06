import java.util.ArrayList;
import java.util.HashMap;

public class Lig {
    private HashMap<String, Takim> takimlar;
    private ArrayList<Mac> maclar;

    public Lig() {
        this.takimlar = new HashMap<>();
        this.maclar = new ArrayList<>();
    }

    public void takimEkle(Takim yeniTakim) {
        takimlar.put(yeniTakim.getIsim(), yeniTakim);
    }

    public Takim getTakim(String isim) {
        return takimlar.get(isim);
    }

    public void macEkle(Mac mac) {
        maclar.add(mac);
    }

    public ArrayList<Mac> getMaclar() {
        return new ArrayList<>(maclar);
    }

    private int rastgeleSkorOlustur() {
        return (int) (Math.random() * 6);
    }

    public void tumMaclariOyna() {
        for (Mac m : getMaclar()) {
            m.setSkor(rastgeleSkorOlustur(), rastgeleSkorOlustur());
            m.sonucuIsle();
        }
    }

    public void fiksturOlustur() {
        for (Takim ev : takimlar.values()) {
            for (Takim deplasman : takimlar.values()) {
                if (ev != deplasman) {
                    NormalSezonMaci sMac = new NormalSezonMaci(ev, deplasman);
                    maclar.add(sMac);
                }
            }
        }
    }

    public Mac macBul(String evIsim, String deplasmanIsim) {
        for (Mac m : maclar) {
            if (m.getEvSahibi().getIsim().equalsIgnoreCase(evIsim)
                    && m.getDeplasman().getIsim().equalsIgnoreCase(deplasmanIsim)) {
                return m;
            }
        }
        return null;
    }
}