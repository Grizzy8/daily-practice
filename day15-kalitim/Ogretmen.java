public class Ogretmen extends Kisi {
    private String brans, sicilNo, unvan;

    Ogretmen(String ad, String soyAd, String telefon, String cinsiyet, int yas, String brans, String sicilNo,
            String unvan) {
        super(ad, soyAd, telefon, cinsiyet, yas);
        this.brans = brans;
        this.sicilNo = sicilNo;
        this.unvan = unvan;
    }

    @Override
    public String bilgiVer() {
        return super.bilgiVer() + " | Branş: " + brans + " | Sicil No: " + sicilNo + " | Unvan: " + unvan;
    }
}