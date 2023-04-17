package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.commons.annotation.Testable;

import com.fasterxml.jackson.databind.ObjectMapper;

import comic.Comic;
import comic.ConcreteComic;
import persistence.ComicsJsonDAO;
import search.ComicSearchResult;
import search.ComicSearcher;

@Testable
public class SearchSortTest {

    ComicSearcher searcher;
    Comic[] testComics;
    ComicsJsonDAO dao;

    ObjectMapper mockMapper;

    @BeforeEach
    public void setup() throws Exception {
        mockMapper = mock(ObjectMapper.class);
        testComics = new Comic[5];
        testComics[0] = new ConcreteComic("Series1", 1, "Title1 vol. 1", "", "Publisher1", "January 1, 2001", "Comic", "January 1, 2001", "Creator1 | Creator2",1);
        testComics[1] = new ConcreteComic("Series2", 1, "Title2 vol. 1", "", "Publisher2", "January 2, 2001", "Comic", "January 2, 2001", "Creator2 | Creator3",1);
        testComics[2] = new ConcreteComic("Series3", 1, "Title3 vol. 1", "", "Publisher3", "January 3, 2001", "Comic", "January 1, 2001", "Creator3 | Creator4",1);
        testComics[3] = new ConcreteComic("Series4", 1, "Title4 vol. 1", "", "Publisher4", "January 4, 2001", "Comic", "January 1, 2001", "Creator4 | Creator5",1);

        when(mockMapper.readValue(
            new File("never gonna give you up.json"),
            Comic[].class
        )).thenReturn(testComics);

        dao = new ComicsJsonDAO("never gonna give you up.json", mockMapper);
    }

    @Test
    public void test1(){
        //searching for term "Title" which should return entire test data list
        try{
            searcher = new ComicSearcher(new ComicsJsonDAO("db/testData.json").getComics());
            ComicSearchResult result = searcher.makeSearch("Title");
            assertEquals(5, result.resultList.size());
        } catch(Exception e) {
            System.out.println("TEST1 FAIL: UNABLE TO EXECUTE SEARCH");
        }
    }

    public static void main(String[] args) throws Exception {
        SearchSortTest test = new SearchSortTest();
        test.setup();
        test.test1();

    }

}
