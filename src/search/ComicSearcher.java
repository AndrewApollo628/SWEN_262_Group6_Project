package search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import comic.Comic;
import persistence.ComicsDAO;

public class ComicSearcher {
    private final ComicsDAO dao;
    public ComicSearcher(ComicsDAO dao){
        this.dao = dao;
    }

    public SearchResult makeSearch(String searchTerm) throws IOException{
        List<Comic> searchResultList = new ArrayList<Comic>();
        List<Comic> comicList = dao.getComics();
        for (Comic comic : comicList) {
            if(comic.getFullTitle().contains(searchTerm)
                || comic.getDescription().contains(searchTerm)
                || checkInCreators(comic, searchTerm)
                ){
                    comicList.add(comic);
                }
            }
        return new SearchResult(searchResultList);
    }

    private boolean checkInCreators(Comic c, String searchTerm){
        for(String s:c.getCreators()){
            if(s.contains(searchTerm)){
                return true;
            }
        }
        return false;
    }
}
