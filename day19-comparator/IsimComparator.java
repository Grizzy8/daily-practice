import java.util.Comparator;

public class IsimComparator implements Comparator<Film> {
    @Override
    public int compare(Film f1, Film f2) {
        return f1.getIsim().compareTo(f2.getIsim());
    }
}

/*
 * Collections.sort(liste, Comparator.comparing(f -> f.getIsim()))
 * şeklinde de yapılabildiğini sonradan öğrendim ama bu sınıflarıda
 * değiştirmedim, amacım zaten bu sınıfları deneyimlemekti.
 */