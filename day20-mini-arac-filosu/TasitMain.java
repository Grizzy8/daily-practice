import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TasitMain {
    private static List<Tasit> tasitlar = new ArrayList<Tasit>();

    private static void ornekVeriOlusturma() {
        tasitlar.add(new Otomobil("Volvo", "S90", "Şarj Edilebilir Hibrit", "01 VLV 01", 105460, 500));
        tasitlar.add(new Otomobil("Volvo", "V60", "Şarj Edilebilir Hibrit", "02 VLV 02", 13452, 529));
        tasitlar.add(new Motosiklet("Yamaha", "Tenere 700", "Benzin", "01 YMH 01", 54637));
        tasitlar.add(new Motosiklet("Harley-Davidson", "Sportster S", "Benzin", "01 HDS 01", 66543));
        tasitlar.add(new Otomobil("Audi", "A6 40 TDI", "Mild Hybrid Dizel", "01 AU 01", 65321, 530));
        tasitlar.add(new Otomobil("Ford", "Mustang GT", "Benzin", "01 FRD 01", 99929, 408));
        tasitlar.add(new Motosiklet("Ducati", "890 Adventure", "Benzin", "01 DCT 01", 12234));
        tasitlar.add(new Motosiklet("Zero", "SR/F", "Elektrik", "01 ZR 01", 12043));
        tasitlar.add(new Motosiklet("Vespa", "Elettrica", "Elektrik", "01 VSP 01", 21144));
        tasitlar.add(new Otomobil("Alfa Romeo", "Tonale", "Plug-in Hybrid", "01 ALR 01", 90827, 500));
        tasitlar.add(new Otomobil("Mazda", "MX-5 Miata", "Benzin", "01 MZD 01", 89980, 130));
        tasitlar.add(new Otomobil("Lotus", "Emira", "Benzin", "01 LTS 01", 99043, 208));
        tasitlar.add(new Motosiklet("Husqvarna", "Svartpilen 401", "Benzin", "01 HQN 01", 12422));
        tasitlar.add(new Motosiklet("Energica", "Ego", "Elektrik", "01 ENC 01", 9821));
        tasitlar.add(new Motosiklet("Vespa", "Sprint 50", "Benzin", "02 VSP 02", 12092));
        tasitlar.add(new Motosiklet("Royal Enfield", "Meteor 350", "Benzin", "01 RE 01", 1705));
        tasitlar.add(new Motosiklet("CFMOTO", "250NK", "Benzin", "01 CFM 01", 12323));
        tasitlar.add(new Motosiklet("CFMOTO", "450SR", "Benzin", "02 CFM 02", 12311));
        tasitlar.add(new Otomobil("Porsche", "Taycan", "Elektrik", "01 PRS 01", 54313, 491));
        tasitlar.add(new Otomobil("Tesla", "Model 3", "Elektrik", "01 TSL 01", 12451, 594));
        tasitlar.add(new Otomobil("Skoda", "Superb", "Dizel", "01 SKD 01", 98546, 645));
        tasitlar.add(new Otomobil("Mercedes-Benz", "C 200", "Benzin", "01 MRC 01", 98213, 455));
    }

    private static void dosyayaKaydet() {
        try (PrintWriter yazici = new PrintWriter(new FileWriter("day20-mini-arac-filosu/Tasitlar.txt", true))) {
            for (int i = 0; i < tasitlar.size(); i++) {
                yazici.println(tasitlar.get(i));
            }
            System.out.println("Dosya başarıyla kaydedildi.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int okuInt(Scanner input, String mesaj) {
        while (true) {
            System.out.printf(mesaj);
            if (input.hasNextInt()) {
                int sayi = input.nextInt();
                input.nextLine();
                if (sayi < 0) {
                    System.out.println("Pozitif sayı girin");
                    input.nextLine();
                } else {
                    return sayi;
                }
            } else {
                System.out.println("Sayı girin");
                input.nextLine();
            }
        }
    }

    private static void tasitEkle(Scanner input, int ekleTercih) {
        String eklenecekTur;
        if (ekleTercih == 1) {
            eklenecekTur = "otomobil";
        } else {
            eklenecekTur = "motosiklet";
        }

        if (ekleTercih == 3) {
            return;
        } else {
            int sayac = okuInt(input, "Kaç tane " + eklenecekTur + " ekleyeceksiniz?%nCevap: ");
            while (0 < sayac) {
                System.out.print("Marka: ");
                String marka = input.nextLine();
                System.out.print("Model: ");
                String model = input.nextLine();
                System.out.print("Yakıt türü: ");
                String yakitTuru = input.nextLine();
                System.out.print("Plaka: ");
                String plaka = input.nextLine();
                int km = okuInt(input, "KM: ");
                int bagajHacmi = okuInt(input, "Bagaj Hacmi: ");

                if (ekleTercih == 1) {
                    tasitlar.add(new Otomobil(marka, model, yakitTuru, plaka, km, bagajHacmi));
                } else if (ekleTercih == 2) {
                    tasitlar.add(new Motosiklet(marka, model, yakitTuru, plaka, km));
                }
                sayac--;
            }
        }
    }

    private static void tasitSil(Scanner input, String mesaj) {
        System.out.printf(mesaj);
        String silinecekPlaka = input.nextLine();
        for (int i = 0; i < tasitlar.size(); i++) {
            if (tasitlar.get(i).getPlaka().equalsIgnoreCase(silinecekPlaka)) {
                tasitlar.remove(i);
                System.out.println(silinecekPlaka + " plakalı araç listeden başarıyla silindi.");
                return;
            }
        }
        System.out.println(silinecekPlaka + " plakalı taşıt bulunamadı!");
    }

    private static void menuDongusu(Scanner input) {
        while (true) {
            int tercih = okuInt(input,
                    "Hangi işlemi yapmak istiyorsun?%n1) Taşıt ekle%n2) Taşıt sil%n3) Listeyi göster%n4) Listeyi sırala%n5) Listeyi kaydet%n6) Çıkış%nTercih: ");

            switch (tercih) {
                case 1:
                    int ekleTercih = okuInt(input,
                            "Ne tür taşıt ekleyeceksin?%n1) Otomobil%n2) Motosiklet%n3) Üst Menüye Dön%nTercih: ");
                    tasitEkle(input, ekleTercih);
                    break;
                case 2:
                    tasitSil(input, "Silinecek olan taşıtın plakası nedir?%nPlaka: ");
                    break;
                case 3:
                    for (Tasit t : tasitlar) {
                        System.out.println(t);
                    }
                    break;
                case 4:
                    int siralaTercih = okuInt(input,
                            "Hangi kritere göre sıralamak istiyorsun?%n1) Marka/Model%n2) KM%n3) Yakıt Türü%n4) Bagaj Hacmi%n5) Üst Menüye Dön%nTercih: ");
                    if (siralaTercih == 1) {
                        Collections.sort(tasitlar, Comparator.comparing(t -> t.getMarkaModel()));
                    } else if (siralaTercih == 2) {
                        Collections.sort(tasitlar, Comparator.comparing(t -> t.getKm()));
                    } else if (siralaTercih == 3) {
                        Collections.sort(tasitlar, Comparator.comparing(t -> t.getYakitTuru()));
                    } else if (siralaTercih == 4) {
                        List<Otomobil> otomobil = new ArrayList<>();
                        for (Tasit t : tasitlar) {
                            if (t instanceof Otomobil) {
                                otomobil.add((Otomobil) t);
                            }
                        }
                        Collections.sort(otomobil, Comparator.comparing(o -> o.getBagajHacmi()));
                        for (Otomobil o : otomobil) {
                            System.out.println(o);
                        }
                    }
                    break;
                case 5:
                    dosyayaKaydet();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Menü numaralarından bir tanesini yazın");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ornekVeriOlusturma();

        menuDongusu(input);

    }
}