package filter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import comic.Comic;

/**
 * Defines the concrete class for sorting by title
 * 
 * @author charlie
 */
public class SortByTitle implements ComicSorter{
    @Override
    public void doSort(List<Comic> comicList, boolean reverse){
        if(reverse==false){
            Collections.sort(comicList, Comparator.comparing(Comic::getFullTitle).thenComparing(Comparator.comparing(Comic::getIssue)));
        }
        else{
            Collections.sort(comicList, Comparator.comparing(Comic::getFullTitle).reversed().thenComparing(Comparator.comparing(Comic::getIssue).reversed()));
        }
    }
}
