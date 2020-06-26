
/**
 * Write a description of MovieRunnerWithFilters here.
 *
 */

import java.util.*;

public class MovieRunnerWithFilters {
    public void printAverageRatings () {
        ThirdRatings thirdRatings = new ThirdRatings ("ratings_short");
        //ThirdRatings thirdRatings = new ThirdRatings ("ratings");
        MovieDatabase.initialize("ratedmovies_short");
        //MovieDatabase.initialize("ratedmoviesfull");

        System.out.println("Read data for " + thirdRatings.getRaterSize() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int minNumOfRatings = 1; // variable
        ArrayList<Rating> averageRatings = thirdRatings.getAverageRatings(minNumOfRatings);
        System.out.println("There are " + averageRatings.size() + " movies with " +
        minNumOfRatings + " or more rating(s):");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByYearAfter () {
        ThirdRatings thirdRatings = new ThirdRatings ("ratings_short");
        //ThirdRatings thirdRatings = new ThirdRatings ("ratings");
        MovieDatabase.initialize("ratedmovies_short");
        //MovieDatabase.initialize("ratedmoviesfull");

        System.out.println("Read data for " + thirdRatings.getRaterSize() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int year = 2000; // variable
        YearAfterFilter yaf = new YearAfterFilter (year);

        int minNumOfRatings = 1; // variable
        ArrayList<Rating> averageRatings = thirdRatings.getAverageRatingsByFilter(minNumOfRatings, yaf);
        System.out.println("There are " + averageRatings.size() + " movies released after "
        + year + " with " + minNumOfRatings + " or more rating(s): ");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getYear(rating.getItem())
            + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByGenre () {
        ThirdRatings thirdRatings = new ThirdRatings ("ratings_short");
        //ThirdRatings thirdRatings = new ThirdRatings ("ratings");
        MovieDatabase.initialize("ratedmovies_short");
        //MovieDatabase.initialize("ratedmoviesfull");

        System.out.println("Read data for " + thirdRatings.getRaterSize() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        String genre = "Crime"; // variable
        GenreFilter gf = new GenreFilter (genre);

        int minNumOfRatings = 1; // variable
        ArrayList<Rating> averageRatings = thirdRatings.getAverageRatingsByFilter(minNumOfRatings, gf);
        System.out.println("There are " + averageRatings.size() + " movies  in genre of \""
        + genre + "\" with " + minNumOfRatings + " or more rating(s):");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Genre(s): " + MovieDatabase.getGenres(rating.getItem()));
        }
    }

    public void printAverageRatingsByMinutes () {
        ThirdRatings thirdRatings = new ThirdRatings ("ratings_short");
        //ThirdRatings thirdRatings = new ThirdRatings ("ratings");
        MovieDatabase.initialize("ratedmovies_short");
        //MovieDatabase.initialize("ratedmoviesfull");

        System.out.println("Read data for " + thirdRatings.getRaterSize() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int minMinutes = 110; // variable
        int maxMinutes = 170; // variable
        MinutesFilter mf = new MinutesFilter (minMinutes, maxMinutes);

        int minNumOfRatings = 1; // variable
        ArrayList<Rating> averageRatings = thirdRatings.getAverageRatingsByFilter(minNumOfRatings, mf);
        System.out.println("There are " + averageRatings.size() + " movies that are between "
        + minMinutes + " and " + maxMinutes + " length with " + minNumOfRatings + " or more rating(s):");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " Time: " + MovieDatabase.getMinutes(rating.getItem())
            + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByDirectors () {
        ThirdRatings thirdRatings = new ThirdRatings ("ratings_short");
        //ThirdRatings thirdRatings = new ThirdRatings ("ratings");
        MovieDatabase.initialize("ratedmovies_short");
        //MovieDatabase.initialize("ratedmoviesfull");

        System.out.println("Read data for " + thirdRatings.getRaterSize() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        String directorsList = "Charles Chaplin,Michael Mann,Spike Jonze"; // variable
        DirectorsFilter df = new DirectorsFilter (directorsList);

        int minNumOfRatings = 1; // variable
        ArrayList<Rating> averageRatings = thirdRatings.getAverageRatingsByFilter(minNumOfRatings, df);
        System.out.println("There are " + averageRatings.size() + " movies that were directed "
        + "by either of those directors: " +  directorsList + ", with " + minNumOfRatings
        + " or more rating(s):");

        Collections.sort(averageRatings);
        for (Rating rating : averageRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Directed by: " + MovieDatabase.getDirector(rating.getItem()));
        }
    }

    public void printAverageRatingsByYearAfterAndGenre () {
        ThirdRatings thirdRatings = new ThirdRatings ("ratings_short");
        //ThirdRatings thirdRatings = new ThirdRatings ("ratings");
        MovieDatabase.initialize("ratedmovies_short");
        //MovieDatabase.initialize("ratedmoviesfull");

        System.out.println("Read data for " + thirdRatings.getRaterSize() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        int year = 1980; // variable
        YearAfterFilter yaf = new YearAfterFilter (year);

        String genre = "Romance"; // variable
        GenreFilter gf = new GenreFilter (genre);

        AllFilters af = new AllFilters();
        af.addFilter(yaf);
        af.addFilter(gf);

        int minNumOfRatings = 1; // variable
        ArrayList<Rating> avgRatings = thirdRatings.getAverageRatingsByFilter(minNumOfRatings, af);
        System.out.println("There is(are) " + avgRatings.size() + " movie(s)  in genre of \""
        + genre + "\" that was(were) directed after " + year + " with " + minNumOfRatings
        + " or more rating(s):");

        Collections.sort(avgRatings);
        for (Rating rating : avgRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getYear(rating.getItem())
            + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Genre: " + MovieDatabase.getGenres(rating.getItem()));
        }
    }

    public void printAverageRatingsByDirectorsAndMinutes () {
        ThirdRatings thirdRatings = new ThirdRatings ("ratings_short");
        //ThirdRatings thirdRatings = new ThirdRatings ("ratings");
        MovieDatabase.initialize("ratedmovies_short");
        //MovieDatabase.initialize("ratedmoviesfull");

        System.out.println("Read data for " + thirdRatings.getRaterSize() + " raters");
        System.out.println("Read data for " + MovieDatabase.size() + " movies");

        String directorsList = "Spike Jonze,Michael Mann,Charles Chaplin,Francis Ford Coppola"; // variable
        DirectorsFilter df = new DirectorsFilter (directorsList);

        int minMinutes = 30; // variable
        int maxMinutes = 170; // variable
        MinutesFilter mf = new MinutesFilter (minMinutes, maxMinutes);

        AllFilters af = new AllFilters();
        af.addFilter(df);
        af.addFilter(mf);

        int minNumOfRatings = 1; // variable
        ArrayList<Rating> avgRatings = thirdRatings.getAverageRatingsByFilter(minNumOfRatings, af);
        System.out.println("There is(are) " + avgRatings.size() + " movie(s) that were filmed by"
        + " either one of these directors: " + directorsList + "; and between "
        + minMinutes + " and " + maxMinutes + " in length, with " + minNumOfRatings
        + " or more rating(s):");

        Collections.sort(avgRatings);
        for (Rating rating : avgRatings) {
            System.out.println(rating.getValue() + " Time: " + MovieDatabase.getMinutes(rating.getItem())
            + " " + MovieDatabase.getTitle(rating.getItem()));
            System.out.println("Directed by: " + MovieDatabase.getDirector(rating.getItem()));
        }
    }
}
