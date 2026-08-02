import java.util.ArrayList;
import java.util.HashMap;

public class FaturaSistemi {
    private HashMap<String, ArrayList<Integer>> tuketimVerileri;
    private final int ANORMAL_ESIK_YUZDE = 50;
    private final int SIFIRDAN_ARTIS_ESIK_KWH = 100;

    public FaturaSistemi() {
        this.tuketimVerileri = new HashMap<>();
    }

    @Override
    public String toString() {
        return tuketimVerileri.toString();
    }

    public void daireEkle(String daireAdi, ArrayList<Integer> tuketimler) {
        tuketimVerileri.put(daireAdi, tuketimler);
    }

    public double ortalamaHesapla(String daireAdi) {
        ArrayList<Integer> liste = tuketimVerileri.get(daireAdi);
        double toplam = 0;
        for (int i = 0; i < liste.size(); i++) {
            toplam += liste.get(i);
        }
        return toplam / liste.size();
    }

    public ArrayList<String> anormalTuketimleriBul() {
        ArrayList<String> sonuclar = new ArrayList<>();
        for (String daireAdi : tuketimVerileri.keySet()) {
            ArrayList<Integer> liste = tuketimVerileri.get(daireAdi);
            for (int i = 1; i < liste.size(); i++) {
                int onceki = liste.get(i - 1);
                int simdiki = liste.get(i);
                if (onceki == 0) {
                    if (simdiki > SIFIRDAN_ARTIS_ESIK_KWH) {
                        sonuclar.add(
                                "Daire " + daireAdi + " | " + (i + 1) + ". ay: 0 iken " + simdiki + " kWh'ye sıçrama");
                    }
                } else {
                    double artisYuzdesi = (simdiki - onceki) / (double) onceki * 100;
                    if (artisYuzdesi > ANORMAL_ESIK_YUZDE) {
                        sonuclar.add("Daire " + daireAdi + " | " + (i + 1) + ". ay: anormal artış %" + artisYuzdesi);
                    }
                }

            }
        }
        return sonuclar;
    }

    public boolean daireVarMi(String daireAdi) {
        return tuketimVerileri.containsKey(daireAdi);
    }
}
