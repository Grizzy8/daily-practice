/* VadesizHesap, VadeliHesap ve KrediHesabi'nin ortak Hesap arayuzu uzerinden
 * nasil farkli davrandigini test eden senaryolar: limit kontrolu, erken cekim
 * cezasi, faiz uygulama ve havale islemleri.
 *
 * Not: Kullanicidan girdi alan etkilesimli bir akis yok; tum degerler
 * (bakiye, limit, cekim/yatirim miktarlari) senaryoyu gostermek icin
 * kod icinde sabit (hardcoded) olarak tanimlandi.
*/

public class BankaMain {
    public static void main(String[] args) {
        VadesizHesap vadesiz = new VadesizHesap(150000, 8000);
        VadeliHesap vadeli = new VadeliHesap(230000, false, 0.05, 0.1);
        KrediHesabi kredi = new KrediHesabi(10000, 5000, 0.05);

        // Tek çekim limitini (8000) aşıyor, reddedilmeli.
        System.out.println("Vadesiz para çekim (limit aşımı): " + vadesiz.paraCek(8100));

        // Vade dolmadı (false), erken çekim cezası (%10) uygulanıp hesaptan 10000 * 1.1 = 11000 düşülmeli.
        System.out.println("Vadeli para çekim (erken çekim cezalı): " + vadeli.paraCek(10000));

        // Bakiye 10000, limit 5000 -> 13000 çekilirse bakiye -3000 olur, limit aşılmadığı için izin verilmeli.
        System.out.println("Kredi para çekim (limit içinde): " + kredi.paraCek(13000));

        // Bakiye -3000 iken 2100 daha çekilirse -5100 olur, limit (5000) aşıldığı için reddedilmeli.
        System.out.println("Kredi para çekim (limit aşımı): " + kredi.paraCek(2100));

        // Havale: Vadesiz'in tek çekim limiti (8000) 10000'i karşılamıyor, kendi paraCek'i reddedeceği için havale de başarısız olmalı.
        System.out.println("Havale (vadesiz -> vadeli, başarısız beklenir): " + vadesiz.havaleYap(vadeli, 10000));

        // Havale başarısız olduğu için iki tarafın bakiyesi de değişmemiş olmalı (vadeli hâlâ ilk çekimden kalan 219000, vadesiz hiç dokunulmamış 150000).
        System.out.println("Bakiye kontrolü -> Vadeli: " + vadeli.getBakiye() + " | Vadesiz: " + vadesiz.getBakiye());

        // Vadeli hesaba faiz uygulanıyor: 219000 * 0.05 = 10950 TL eklenmeli, yeni bakiye 229950 olmalı.
        System.out.println("Vadeli hesaba faiz uygula: " + vadeli.faizUygula());

        // Kredi hesabına para yatırılıyor: bakiye -3000 + 10000 = 7000 olmalı.
        System.out.println("Kredi para yatır: " + kredi.paraYatir(10000));

        // Kredi bakiyesi artık pozitif (7000), borç olmadığı için faiz işlenmemeli.
        System.out.println("Kredide borca faiz işle (borç yok beklenir): " + kredi.borcaFaizIsle());

        // Kredi: bakiye 7000, limit 5000 -> 6000 çekilirse bakiye 1000 olur, limit aşılmadığı için izin verilmeli.
        System.out.println("Kredi para çek (limit içinde): " + kredi.paraCek(6000));
    }
}
