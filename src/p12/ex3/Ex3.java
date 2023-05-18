package p12.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Ex3 {
    private static void loadMovies(String path, Set<Movie> movieSet) throws FileNotFoundException {
        Scanner input = new Scanner(new File(path));
        input.useDelimiter("[\\t\\r\\n]+");

        input.nextLine(); // ignore header

        while(input.hasNext()) {
            movieSet.add(
                new Movie(
                    input.next(),
                    Double.parseDouble(input.next()),
                    input.next(),
                    input.next(),
                    Integer.parseInt(input.next())
                )
            );
        }
    }

    public static void main(String[] args) {
        Set<Movie> movieSet = new TreeSet<>();

        try {
            loadMovies("resources/movies.txt", movieSet);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println(movieSet);

        List<Movie> movieList = new ArrayList<>(movieSet.stream().toList());

        // Sort scoreList by score, in descending order
        movieList.sort((m1, m2) -> Double.compare(m2.getScore(), m1.getScore()));
        System.out.println("\nScore ------------------");
        System.out.println(movieList);

        // Sort scoreList by running time, in ascending order
        movieList.sort(Comparator.comparingDouble(Movie::getRunningTime));
        System.out.println("\nRunning time -----------");
        System.out.println(movieList);

        // List genres
        Map<String, Integer> genreMap = new HashMap<>();
        for (Movie movie: movieList) {
            String genre = movie.getGenre();
            if (genreMap.containsKey(genre)) {
                int i = genreMap.get(genre);
                genreMap.put(genre, ++i);
            } else {
                genreMap.put(genre, 1);
            }
        }
        System.out.println("\nGenres -----------------");
        System.out.println(genreMap);

        // e) Write to file
        String wantedGenre = "suspense";
        try (PrintWriter out = new PrintWriter("resources/myselection.txt")) {
            for (Movie movie : movieSet) {
                if (movie.getScore() > 60 && movie.getGenre().equals(wantedGenre)) {
                    out.println(movie);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Exiting...");
            System.exit(1);
        }
    }
}
