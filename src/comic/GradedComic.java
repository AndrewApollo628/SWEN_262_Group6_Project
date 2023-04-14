package comic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Defines what a graded comic can do 
 * 
 * @author Andrew Apollo 
 */
public class GradedComic extends ComicDec {
    
    @JsonProperty("grade") private int grade;
   
    public GradedComic(int Grade, Comic comic){
        super(comic);
        this.grade = Grade;
    }

    public int getGrade(){
        return grade;
    }

    @Override
    public String toString() {
        return "GRADED(" + grade + ")"+super.toString();
    }

}