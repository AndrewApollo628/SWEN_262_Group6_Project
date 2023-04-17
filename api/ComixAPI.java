package api;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import collection.AddComic;
import collection.GradeComic;
import collection.RemoveComic;
import collection.SignComic;
import collection.SlabComic;
import comic.Comic;
import filter.ComicSorter;
import filter.SortByDate;
import filter.SortByPublisher;
import filter.SortByTitle;
import persistence.ComicsDAO;
import persistence.ComicsJsonDAO;
import persistence.UsersDAO;
import persistence.UsersJsonDAO;
import search.ComicSearchResult;
import search.ComicSearcher;

public class ComixAPI implements IComix {
    private UsersDAO usersDAO;
    private ComicsDAO comicsDAO;

    private String currentUser;
    public String getCurrentUser() { return currentUser; }

    public ComixAPI() {
        usersDAO = new UsersJsonDAO("db/users.json");
        comicsDAO = new ComicsJsonDAO("db/testData.json");
        // comicsDAO = new ComicsJsonDAO("db/comics.json"); // TODO: this is the real one
    }

    public boolean login(String username, String password) {
        try {
            if (usersDAO.check(username, password)) {
                currentUser = username;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void logout() { currentUser = null; }


    @Override
    public ArrayList<Comic> getAllComics() throws IOException {
        return comicsDAO.getComics();
    }

    @Override
    public ArrayList<Comic> getUserCollection() throws Exception {
        return usersDAO.getCollection(currentUser).getContents();
    }

    @Override
    public void addToCollection(int comic) throws Exception {
        Comic comicToAdd = comicsDAO.getComics().get(comic);
        AddComic addComic = new AddComic(comicToAdd, usersDAO, currentUser);
        addComic.execute();
    }

    @Override
    public void addToCollection(Comic comic) throws Exception {
        AddComic addComic = new AddComic(comic, usersDAO, currentUser);
        addComic.execute();
    }

    @Override
    public Comic removeFromCollection(int comic) throws Exception {
        Comic comicToRemove = usersDAO.getCollection(currentUser).getContents().get(comic);
        RemoveComic removeComic = new RemoveComic(comicToRemove, usersDAO, currentUser);
        removeComic.execute();
        return comicToRemove;
    }

    @Override
    public List<Comic> searchComic(String query, String Context, String sort, String reverse) throws IOException {
        ComicSearcher searcher = new ComicSearcher(comicsDAO);
        SortByDate sortDate =  new SortByDate();
        SortByPublisher sortPub = new SortByPublisher();
        SortByTitle sortTitle = new SortByTitle();
        List<Comic> comicsList = new ArrayList<>();

        if(query.length() != 0){
            ComicSearchResult searchedComics = searcher.makeSearch(query);

            comicsList = searchedComics.resultList; 

            if(sort.toLowerCase() == "date" && reverse.toLowerCase() == "f"){
                sortDate.doSort(comicsList, false);
            }
            else if(sort.toLowerCase() == "date" && reverse.toLowerCase() == "t"){
                sortDate.doSort(comicsList, true);
            }
            else if(sort.toLowerCase() == "publisher" && reverse.toLowerCase() == "f"){
                sortPub.doSort(comicsList, false);
            }
            else if(sort.toLowerCase() == "publisher" && reverse.toLowerCase() == "t"){
                sortPub.doSort(comicsList, true);
            }
            else if(sort.toLowerCase() == "title" && reverse.toLowerCase() == "f"){
                sortTitle.doSort(comicsList, false);
            }
            else if(sort.toLowerCase() == "title" && reverse.toLowerCase() == "t"){
                sortTitle.doSort(comicsList, true);
            }
        }

        else{
            System.out.println("Invalid search");
        }

        return comicsList;
    }

    @Override
    public void gradeComic(int comic, int grade) throws Exception {
        Comic comicToGrade = usersDAO.getCollection(currentUser).getContents().get(comic);
        GradeComic gradeComic = new GradeComic(comicToGrade, usersDAO, currentUser, grade, comic);
        gradeComic.execute();
    }

    @Override
    public void slabComic(int comic) throws Exception {
        Comic comicToSlab = usersDAO.getCollection(currentUser).getContents().get(comic);
        SlabComic slabComic = new SlabComic(comicToSlab, usersDAO, currentUser, comic);
        slabComic.execute();

    }

    @Override
    public void unGradeComic(int comic) throws Exception {
        Comic comicToUnGrade = usersDAO.getCollection(currentUser).getContents().get(comic);
        GradeComic unGradeComic = new GradeComic(comicToUnGrade, usersDAO, currentUser, 0, comic);
        unGradeComic.undo();
    }

    @Override
    public void unSlabComic(int comic) throws Exception {
        Comic comicToUnSlab = usersDAO.getCollection(currentUser).getContents().get(comic);
        SlabComic unSlabComic = new SlabComic(comicToUnSlab, usersDAO, currentUser, comic);
        unSlabComic.undo();
    }

    @Override
    public void signComic(int comic) throws Exception {
        Comic comicToSign = usersDAO.getCollection(currentUser).getContents().get(comic);
        SignComic signComic = new SignComic(comicToSign, usersDAO, currentUser, comic);
        signComic.execute();
    }

    @Override
    public void unSignComic(int comic) throws Exception {
        Comic comicToUnSign = usersDAO.getCollection(currentUser).getContents().get(comic);
        SignComic unSignComic = new SignComic(comicToUnSign, usersDAO, currentUser, comic);
        unSignComic.undo();
    }

}
