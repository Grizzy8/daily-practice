public class KrediHesabi extends BankaHesabi implements Havaleyapilabilir {
    private double krediLimiti;
    private double faizOrani;

    KrediHesabi(double bakiye, double krediLimiti, double faizOrani) {
        super(bakiye);
        this.krediLimiti = krediLimiti;
        this.faizOrani = faizOrani;
    }

    public String borcaFaizIsle() {
        if (getBakiye() < 0) {
            double faiz = getBakiye() * faizOrani;
            bakiyeyiDegistir(faiz);
            return "Borcunuza " + faiz + " TL eklendi. Güncel borcunuz: " + (-getBakiye());
        } else {
            return "Borcunuz bulunmadığı için faiz işlenmedi.";
        }
    }

    @Override
    public String paraCek(double miktar) {
        if (krediLimiti >= miktar - getBakiye()) {
            bakiyeyiDegistir(-miktar);
            return "Kredinizden para çekildi.";
        } else {
            return "Kredi limitinizi aştınız";
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
}
