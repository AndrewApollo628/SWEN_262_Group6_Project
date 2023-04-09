package filter;

import java.util.ArrayList;
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
            Collections.sort(comicList, Comparator.comparing(Comic::getName).thenComparing(Comparator.comparing(Comic::getIssueNumber)));
        }
        else{
            Collections.sort(comicList, Comparator.comparing(Comic::getName).reversed().thenComparing(Comparator.comparing(Comic::getIssueNumber).reversed()));
        }
    }
}
