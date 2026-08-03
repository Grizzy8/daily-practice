import java.util.Comparator;

public class PuanComparator implements Comparator<Film> {
    @Override
    public int compare(Film f1, Film f2) {
        return Double.compare(f1.getPuan(), f2.getPuan());
    }
}