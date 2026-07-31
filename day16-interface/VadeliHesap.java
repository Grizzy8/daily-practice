public class VadeliHesap extends BankaHesabi implements Havaleyapilabilir, FaizGetirisiOlan {
    private boolean vadeDoldu;
    private double faizOrani;
    private double erkenCekimCezaOrani;

    VadeliHesap(double bakiye, boolean vadeDoldu, double faizOrani, double erkenCekimCezaOrani) {
        super(bakiye);
        this.vadeDoldu = vadeDoldu;
        this.faizOrani = faizOrani;
        this.erkenCekimCezaOrani = erkenCekimCezaOrani;
    }

    @Override
    public String paraCek(double miktar) {
        if (vadeDoldu) {
            return super.paraCek(miktar);
        } else {
            // ceza oranı istenen miktara uygulanıp hesaptan miktar + ceza düşüldü
            return super.paraCek(miktar * (1 + erkenCekimCezaOrani));
        }
    }

    @Override
    public String havaleYap(BankaHesabi hedef, double miktar) {
        double eskiBakiye = getBakiye();
        paraCek(miktar);
        double yeniBakiye = getBakiye();

        if (eskiBakiye != yeniBakiye) {
            hedef.paraYatir(miktar);
            return "Havale işlemi gerçekleşti.";
        } else {
            return "Havale başarısız oldu.";
        }
    }

    @Override
    public String faizUygula() {
        double faizGeliri = getBakiye() * faizOrani;
        bakiyeyiDegistir(faizGeliri);
        return faizGeliri + " TL faiz eklendi. Güncel bakiyeniz: " + getBakiye() + " TL.";
    }
}
