package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import persistence.ComicsJsonDAO;
import persistence.UsersDAO;
import persistence.UsersJsonDAO;
import search.ComicSearchResult;
import search.ComicSearcher;

@Testable
public class SearchSortTest {

    ComicSearcher searcher;

    @Test
    public void test1(){
        //searching for term "Title" which should return entire test data list
        try{
            searcher = new ComicSearcher(new ComicsJsonDAO("db/testData.json"));
            ComicSearchResult result = searcher.makeSearch("Title");
            assertEquals(5, result.resultList.size());
        } catch(Exception e) {
            System.out.println("TEST1 FAIL: UNABLE TO EXECUTE SEARCH");
        }
    }

    @Test
    public void testFileExists(){
        assertTrue(new File("db/testData.json").exists());
    }
}
