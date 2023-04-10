package filter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import comic.Comic;

/**
 * Defines the concrete class for sorting by author
 * 
 * @author charlie
 */
public class SortByPublisher implements ComicSorter{
    @Override
    public void doSort(List<Comic> comicList, boolean reverse){
        
        if(reverse==false){
            Collections.sort(comicList, Comparator.comparing(Comic::getPublisher));
        }
        else{
            Collections.sort(comicList, Comparator.comparing(Comic::getPublisher).reversed());
        }
    }
}
