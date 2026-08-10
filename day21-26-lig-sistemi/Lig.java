import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Lig {
    private HashMap<String, Takim> takimlar;
    private ArrayList<Mac> maclar;

    public Lig() {
        this.takimlar = new HashMap<>();
        this.maclar = new ArrayList<>();
    }

    void takimEkle(Takim yeniTakim) throws TakimZatenVarException {
        // toUpperCase() JVM'in varsayılan Locale'ini kullanıyor. Türkçe locale'de "i"
        // -> "İ" olurken
        // İngilizce'de "I" olur, bu nedenle aynı isim farklı yollardan girilirse
        // harfler tutarsız büyüyebilir.
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
                if (ev != deplasman && macBul(ev.getIsim(), deplasman.getIsim()) == null) {
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
                boolean jOncelikliMi = oncelikliMi(liste.get(j), liste.get(oncelikliIndex));
                if (tersMi ? !jOncelikliMi : jOncelikliMi) {
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
                } else if (b.getAtilanGol() == a.getAtilanGol()) {
                    if (b.getIsim().compareTo(a.getIsim()) < 0) {
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

    void kaydetLig(String dosyaAdi) throws IOException {
        try (PrintWriter yaziciLig = new PrintWriter(new FileWriter("day21-26-lig-sistemi/" + dosyaAdi))) {
            for (Takim t : takimlar.values()) {
                yaziciLig.println(t.dosyaSatiri());
            }
        }
    }

    void kaydetMac(String dosyaAdi) throws IOException {
        try (PrintWriter yaziciMac = new PrintWriter(new FileWriter("day21-26-lig-sistemi/" + dosyaAdi))) {
            for (Mac m : maclar) {
                yaziciMac.println(m.dosyaSatiri());
            }
        }
    }

    int yukle(String ligDosyasi, String macDosyasi) throws IOException {
        int atlananSatir = 0;
        try (Scanner dosyaOku1 = new Scanner(new File("day21-26-lig-sistemi/" + ligDosyasi))) {
            while (dosyaOku1.hasNextLine()) {
                try {
                    String[] parcalar = dosyaOku1.nextLine().split(",");
                    Takim takim = new Takim(parcalar[0].toUpperCase(), Integer.parseInt(parcalar[2]),
                            Integer.parseInt(parcalar[3]),
                            Integer.parseInt(parcalar[4]), Integer.parseInt(parcalar[5]),
                            Integer.parseInt(parcalar[6]));
                    takimEkle(takim);
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException | TakimZatenVarException e) {
                    atlananSatir++;
                }

            }
        }

        try (Scanner dosyaOku2 = new Scanner(new File("day21-26-lig-sistemi/" + macDosyasi))) {
            while (dosyaOku2.hasNextLine()) {
                try {
                    String[] parcalar = dosyaOku2.nextLine().split(",");
                    Takim takim1 = getTakim(parcalar[0]);
                    Takim takim2 = getTakim(parcalar[2]);
                    Mac mac;
                    if ("NORMAL".equalsIgnoreCase(parcalar[4])) {
                        mac = new NormalSezonMaci(takim1, takim2);
                    } else {
                        mac = new PlayOffMaci(takim1, takim2);
                    }
                    mac.setSkor(Integer.parseInt(parcalar[1]), Integer.parseInt(parcalar[3]));
                    mac.setOynandiMi();
                    macEkle(mac);
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException | TakimBulunamadiException
                        | GecersizSkorException | BerabereSonuclanamazException e) {
                    atlananSatir++;
                }
            }
        }
        return atlananSatir;
    }

    Takim enCokGolAtanTakim() {
        return enIyisiniBul(Comparator.comparingInt(takim -> takim.getAtilanGol()));
    }

    Takim enIyiSavunma() {
        return enIyisiniBul(Comparator.comparingInt((Takim takim) -> takim.getYenilenGol()).reversed());
    }

    Takim enYuksekAveraj() {
        return enIyisiniBul(Comparator.comparingInt(takim -> takim.averajHesapla()));
    }

    Takim ligdeEnUzunSeri() {
        return enIyisiniBul(Comparator.comparingInt(takim -> birTakiminEnUzunSerisi(takim)));
    }

    private Takim enIyisiniBul(Comparator<Takim> karsilastirici) {
        if (takimlar.isEmpty()) {
            return null;
        }
        ArrayList<Takim> liste = new ArrayList<>(takimlar.values());
        Takim enIyi = liste.getFirst();
        for (int i = 1; i < liste.size(); i++) {
            Takim mevcut = liste.get(i);
            if (karsilastirici.compare(enIyi, mevcut) < 0) {
                enIyi = mevcut;
            }
        }
        return enIyi;
    }

    int birTakiminEnUzunSerisi(Takim t) {
        int seri = 0;
        int enUzunSeri = 0;
        for (Mac m : maclar) {
            if (!m.getOynandiMi()) {
                continue;
            }
            if (m.getEvSahibi() == t) {
                if (m.getDeplasmanSkor() < m.getEvSahibiSkor()) {
                    seri++;
                } else {
                    seri = 0;
                }
            } else if (m.getDeplasman() == t) {
                if (m.getEvSahibiSkor() < m.getDeplasmanSkor()) {
                    seri++;
                } else {
                    seri = 0;
                }
            }
            if (enUzunSeri < seri) {
                enUzunSeri = seri;
            }
        }
        return enUzunSeri;
    }
}