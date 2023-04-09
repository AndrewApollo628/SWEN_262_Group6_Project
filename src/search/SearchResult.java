package search;

import java.util.List;

import comic.Comic;
import filter.ComicSorter;
import filter.SortByTitle;

public class SearchResult {
    public List<Comic> resultList;
    public ComicSorter sortMethod;

    public SearchResult(List<Comic> resultList){
        this.resultList = resultList;
        this.sortMethod = new SortByTitle();
    }

    public void setSort(ComicSorter sortMethod){
        this.sortMethod = sortMethod;
    }

    public void executeSort(){
        sortMethod.doSort(resultList, false);
    }
}
