abstract class BankaHesabi {
    private static int sonHesapNo;
    private final int hesapNo;
    private double bakiye = 0;

    BankaHesabi(double bakiye) {
        hesapNo = sonHesapNo++;
        this.bakiye = bakiye;
    }

    public double getBakiye() {
        return bakiye;
    }

    public String paraCek(double miktar) {
        if (miktar <= 0) {
            return "0'dan daha büyük bir harcama yapın";
        } else if (bakiye < miktar) {
            return "Yetersiz bakiye!";
        } else {
            bakiye -= miktar;
            return miktar + " TL çekildi.";
        }
    }

    protected void bakiyeyiDegistir(double fark) {
        bakiye += fark;
    }

    public String paraYatir(double miktar) {
        if (0 < miktar) {
            bakiye += miktar;
            return miktar + " TL yatırıldı.";
        } else {
            return "Paranız tanımlanamadı.";
        }
    }

    @Override
    public String toString() {
        return "Hesap No: " + hesapNo + " | Bakiye: " + bakiye;
    }
}

interface Havaleyapilabilir {
    String havaleYap(BankaHesabi hedef, double miktar);
}

interface FaizGetirisiOlan {
    String faizUygula();
}