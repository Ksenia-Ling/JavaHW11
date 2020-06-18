package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.MovieInfo;

@NoArgsConstructor

public class MovieManager {

    private MovieInfo[] movies = new MovieInfo[0];

    private final int afficheDefaultLength = 10;
    private int afficheLength;


    public MovieManager(int afficheLength) {
        this.afficheLength = afficheLength;
    }


    public void add(MovieInfo movie) {
        int length = movies.length + 1;
        MovieInfo[] tmp = new MovieInfo[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public MovieInfo[] getLastAdded() {

        int movieCount = movies.length;
        if ((afficheDefaultLength < movies.length) && (afficheLength == 0)) {
            movieCount = afficheDefaultLength;
        } else if ((afficheLength > 0) && (afficheLength < movies.length)) {
            movieCount = afficheLength;
        }
        MovieInfo[] result = new MovieInfo[movieCount];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];

        }
        return result;
    }
}

