public class Ogrenci extends Kisi {
    private int ogrenciNo;
    private int not;
    private String sinif;

    Ogrenci(String ad, String soyAd, String telefon, String cinsiyet, int yas, int ogrenciNo, int not, String sinif) {
        super(ad, soyAd, telefon, cinsiyet, yas);
        this.ogrenciNo = ogrenciNo;
        this.not = not;
        this.sinif = sinif;
    }

    @Override
    public String bilgiVer() {
        return super.bilgiVer() + " | Öğrenci No: " + ogrenciNo + " | Not: " + not + " | Sınıf: " + sinif;
    }
}
