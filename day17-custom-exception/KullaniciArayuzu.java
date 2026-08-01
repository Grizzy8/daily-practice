import java.util.InputMismatchException;
import java.util.Scanner;

public class KullaniciArayuzu {
    private static final int SATIR_UZUNLUGU = 10;
    private BiletSistemi sistem;
    private final Scanner input;

    public KullaniciArayuzu(BiletSistemi sistem, Scanner input) {
        this.sistem = sistem;
        this.input = input;
    }

    private void cerceveliYazdir(String mesaj) {
        String cizgi = "-".repeat(mesaj.length() + 4);
        System.out.println("\n" + cizgi);
        System.out.println("| " + mesaj + " |");
        System.out.println(cizgi + "\n");
    }

    private int okuInt(String mesaj) {
        while (true) {
            System.out.print(mesaj);
            try {
                int sayi = input.nextInt();
                input.nextLine();
                return sayi;
            } catch (InputMismatchException e) {
                cerceveliYazdir("Sayı girin!");
                input.nextLine();
            }
        }
    }

    private void koltuklariGoster() {
        System.out.println("\n----------------- Koltuk Durumu -----------------");
        for (int i = 0; i < sistem.getKapasite(); i++) {
            if (sistem.koltukBosMu(i)) {
                System.out.printf("[%2d] ", (i + 1));
            } else {
                System.out.print("[ X] ");
            }
            if ((i + 1) % SATIR_UZUNLUGU == 0) {
                System.out.println();
            }
        }
        if (sistem.getKapasite() % SATIR_UZUNLUGU != 0) {
            System.out.println();
        }
        System.out.println("Boş koltuk: " + sistem.getBosKoltukSayisi() + "/" + sistem.getKapasite() + "\n");
    }

    public void menuDongusu() {
        while (true) {
            if (sistem.getBosKoltukSayisi() == 0) {
                cerceveliYazdir("Tüm koltuklar doldu. Bilet satışı sona ermiştir.");
                break;
            }
            int secim = okuInt("Yeni bilet alacak mısınız?\n1) Evet\n2) Hayır\nSeçiminiz: ");
            if (secim == 2) {
                break;
            } else if (secim != 1) {
                cerceveliYazdir("Lütfen 1 veya 2 girin.");
            } else {
                int yas = okuInt("Yaş: ");
                if (yas < 18) {
                    cerceveliYazdir("Bu işlem 18 yaş ve üzeri kullanıcılar içindir.");
                    continue;
                }
                String isim;
                while (true) {
                    System.out.print("İsim: ");
                    isim = input.nextLine().trim();
                    if (isim.isEmpty()) {
                        cerceveliYazdir("İsmi boş bırakamazsınız!");
                    } else {
                        break;
                    }
                }
                Musteri musteri = new Musteri(isim, yas);
                koltuklariGoster();
                while (true) {
                    int koltukNo = (okuInt("Koltuk No: ") - 1);
                    try {
                        sistem.rezervasyonYap(musteri, koltukNo);
                        System.out.println(musteri.getIsim() + " için " + (koltukNo + 1) + ". koltuk ayrıldı.");
                        break;
                    } catch (GecersizKoltukException | KoltukDoluException e) {
                        cerceveliYazdir(e.getMessage());
                        koltuklariGoster();
                    }
                }
            }
        }
    }
}
