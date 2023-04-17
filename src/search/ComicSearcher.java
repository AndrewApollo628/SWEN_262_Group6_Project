package search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import comic.Comic;

public class ComicSearcher {
    private List<Comic> comicList;

    public ComicSearcher(ArrayList<Comic> comicList) {
        this.comicList = new CopyOnWriteArrayList<Comic>(comicList);
    }

    public ComicSearchResult makeSearch(String searchTerm) throws IOException{
        List<Comic> searchResultList = new ArrayList<Comic>();
        for (Comic comic : comicList) {
            if(comic.getFullTitle().toLowerCase().contains(searchTerm)
                || comic.getVariantDescription().toLowerCase().contains(searchTerm)
                || checkInCreators(comic, searchTerm)
                ){
                    searchResultList.add(comic);
                }
            }
        return new ComicSearchResult(searchResultList);
    }

    private boolean checkInCreators(Comic c, String searchTerm){
        for(String s:c.getCreator()){
            if(s.toLowerCase().contains(searchTerm)){
                return true;
            }
        }
        return false;
    }
}
