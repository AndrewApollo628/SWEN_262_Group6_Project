package filter;

import java.util.List;
import comic.Comic;

/**
 * Defines the Comic sorting interface
 * 
 * @author charlie
 */
public interface ComicSorter {
    public void doSort(List<Comic> comicList, boolean reverse);
}
