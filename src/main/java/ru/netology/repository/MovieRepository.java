package ru.netology.repository;

import ru.netology.domain.MovieInfo;

public class MovieRepository {

    private MovieInfo[] movies = new MovieInfo[0];

    public void save(MovieInfo movie) {
        int length = movies.length + 1;
        MovieInfo[] tmp = new MovieInfo[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MovieInfo[] findAll() {
        return movies;
    }

    public MovieInfo findById(int id) {
        for (MovieInfo movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;

    }

    public void removeById(int id) {
        int length = movies.length - 1;
        MovieInfo[] tmp = new MovieInfo[length];
        int index = 0;
        for (MovieInfo movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        MovieInfo[] tmp = new MovieInfo[0];
        movies = tmp;
    }
}