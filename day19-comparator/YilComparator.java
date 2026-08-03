import java.util.Comparator;

public class YilComparator implements Comparator<Film> {
    @Override
    public int compare(Film f1, Film f2) {
        return Integer.compare(f1.getYil(), f2.getYil());
    }
}