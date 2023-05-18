package p12.ex3;

import java.util.Objects;

public class Movie implements Comparable<Movie> {
    private final String name, rating, genre;
    private final int runningTime;
    private final double score;

    public String getName() {
        return this.name;
    }

    public Movie(String name, double score, String rating, String genre, int runningTime) {
        this.name = name;
        this.rating = rating;
        this.genre = genre;
        this.score = score;
        this.runningTime = runningTime;
    }

    @Override
    public int compareTo(Movie that) {
        return this.name.compareToIgnoreCase(that.getName());
    }

    public int getRunningTime() {
        return runningTime;
    }

    public double getScore() {
        return score;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
               "name='" + name + '\'' +
               ", rating='" + rating + '\'' +
               ", genre='" + genre + '\'' +
               ", score=" + score +
               ", runningTime=" + runningTime +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return score == movie.score && runningTime == movie.runningTime && Objects.equals(name, movie.name) && Objects.equals(rating, movie.rating) && Objects.equals(genre, movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating, genre, score, runningTime);
    }
}
