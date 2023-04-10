package search;

import java.util.List;

import comic.Comic;
import filter.ComicSorter;
import filter.SortByTitle;

public class ComicSearchResult {
    public List<Comic> resultList;
    public ComicSorter sortMethod;

    public ComicSearchResult(List<Comic> resultList){
        this.resultList = resultList;
        this.sortMethod = new SortByTitle();
        executeSort(false);
    }

    public void setSort(ComicSorter sortMethod){
        this.sortMethod = sortMethod;
    }

    public void executeSort(boolean reverse){
        sortMethod.doSort(resultList, false);
    }
}
