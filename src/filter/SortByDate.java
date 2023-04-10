package filter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import comic.Comic;

/**
 * Defines the concrete class for sorting by publish date
 * 
 * @author charlie
 */
public class SortByDate implements ComicSorter{
    @Override
    public void doSort(List<Comic> comicList, boolean reverse){

        if(reverse==false){
            Collections.sort(comicList, Comparator.comparing(Comic::getPublicationDate));
        }
        else{
            Collections.sort(comicList, Comparator.comparing(Comic::getPublicationDate).reversed());
        }
    }
}
