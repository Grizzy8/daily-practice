public class Kisi {
    private String ad, soyAd;
    private String telefon;
    private String cinsiyet;
    private int yas;

    Kisi(String ad, String soyAd, String telefon, String cinsiyet, int yas) {
        this.ad = ad;
        this.soyAd = soyAd;
        this.telefon = telefon;
        this.cinsiyet = cinsiyet;
        this.yas = yas;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyAd() {
        return soyAd;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public int getYas() {
        return yas;
    }

    public String bilgiVer() {
        return "Ad: " + ad + " | Soyad: " + soyAd + " | Cinsiyet: " + cinsiyet + " | Yaş: " + yas + " | Telefon No: "
                + telefon;
    }
}
