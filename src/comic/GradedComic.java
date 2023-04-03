package comic;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Defines what a graded comic can do 
 * 
 * @author Andrew Apollo 
 */
public class GradedComic extends ConcreteComic {
    
    @JsonProperty("grade") private int Grade;
   
    public GradedComic(int Grade, Comic comic){
        super(comic);
        this.Grade = Grade;
    }

    public void addGrade(int Grade){
        this.Grade = Grade;
    }

    public int getGrade(){
        return Grade;
    }
}