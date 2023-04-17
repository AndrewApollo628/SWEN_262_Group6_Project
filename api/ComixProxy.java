package api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import comic.Comic;

public class ComixProxy implements IComix {
    private ComixAPI api = new ComixAPI();
    private boolean loggedIn = false;

    public String getCurrentUser() {
        if (!loggedIn) { return null; }
        else { return api.getCurrentUser(); }
    }

    public boolean login(String username, String password) {
        loggedIn = api.login(username, password);
        return loggedIn;
    }

    public void logout() {
        if (loggedIn) {
            api.logout();
            loggedIn=false;
        }
    }

    @Override
    public ArrayList<Comic> getUserCollection() throws Exception {
        if (!loggedIn) {
            throw new UnsupportedOperationException("User not logged in\n");
        } else {
            return api.getUserCollection();
        }
    }

    @Override
    public void addToCollection(int comic) throws Exception {
        if (!loggedIn) {
            throw new UnsupportedOperationException("User not logged in");
        } else {
            api.addToCollection(comic);
        }
    }

    @Override
    public void addToCollection(Comic comic) throws Exception {
        if (!loggedIn) {
            throw new UnsupportedOperationException("User not logged in");
        } else {
            api.addToCollection(comic);
        }
    }

    @Override
    public Comic removeFromCollection(int comic) throws Exception {
        if (!loggedIn) {
            throw new UnsupportedOperationException("User not logged in");
        } else {
            return api.removeFromCollection(comic);
        }
    }

    @Override
    public List<Comic> searchComic(String query, String Context, String sort, String reverse) throws Exception {
        if(!loggedIn){
            if (Context.toLowerCase().equals("collection")) {
                throw new UnsupportedOperationException("User Not Logged In");
            }
            System.out.println("<<GUEST MODE>>");
        }
        return api.searchComic(query.toLowerCase(), Context, sort.toLowerCase(), ""+reverse.toLowerCase().charAt(0));
    }

    @Override
    public ArrayList<Comic> getAllComics() throws IOException {
        if (!loggedIn) {
            System.out.println("<<GUEST MODE>>");
        }
        return api.getAllComics();
    }

    @Override
    public void gradeComic(int comic, int grade) throws Exception {
        if (!loggedIn) {
            throw new UnsupportedOperationException("User not logged in");
        } else {
            api.gradeComic(comic, grade);
        }
    }

    @Override
    public void slabComic(int comic)  throws Exception {
        if (!loggedIn) {
            throw new UnsupportedOperationException("User not logged in");
        } else {
            api.slabComic(comic);
        }
    }

    @Override
    public void unGradeComic(int comic) throws Exception {
        if (!loggedIn) {
            throw new UnsupportedOperationException("User not logged in");
        } else {
            api.unGradeComic(comic);
        }
    }

    @Override
    public void unSlabComic(int comic) throws Exception {
        if (!loggedIn) {
            throw new UnsupportedOperationException("User not logged in");
        } else {
            api.unSlabComic(comic);
        }
    }

    @Override
    public void signComic(int comic) throws Exception {
        if (!loggedIn) {
            throw new UnsupportedOperationException("User not logged in");
        } else {
            api.signComic(comic);
        }
    }

    @Override
    public void unSignComic(int comic) throws Exception {
        if (!loggedIn) {
            throw new UnsupportedOperationException("User not logged in");
        } else {
            api.unSignComic(comic);
        }
    }

}