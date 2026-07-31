public class VadesizHesap extends BankaHesabi implements Havaleyapilabilir {
    private double tekCekimLimiti;

    VadesizHesap(double bakiye, double tekCekimLimiti) {
        super(bakiye);
        this.tekCekimLimiti = tekCekimLimiti;
    }

    @Override
    public String paraCek(double miktar) {
        if (tekCekimLimiti < miktar) {
            return "Tek çekimlik limitinizi aştınız.";
        } else {
            return super.paraCek(miktar);
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
