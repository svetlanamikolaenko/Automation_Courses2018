package lesson14;


import java.util.ArrayList;
import java.util.List;

public class Movie {


    public String title;
    public double rating;
    public double metascore;
    public int year;
    public String director;
    public List<String> actors = new ArrayList<>();

    @Override
    public java.lang.String toString() {
        return "Movie{" + "title=" + title +
                ", rating=" + rating + "," +
                " metascore="    + metascore + "," +
                "year=" + year + "," +
                " director=" + director + "," +
                " actors=" + actors + '}';
    }

}
