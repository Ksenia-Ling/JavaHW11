package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.MovieInfo;
import ru.netology.repository.MovieRepository;

@NoArgsConstructor

public class MovieManager {

    private MovieRepository repository;
    private final int afficheDefaultLength = 10;
    private int afficheLength;

    public MovieManager(MovieRepository repository, int afficheLength) {
        this.repository = repository;
        this.afficheLength = afficheLength;
    }


    public void add(MovieInfo movie) {
        repository.save(movie);
    }

    public MovieInfo[] getLastAdded() {
        MovieInfo[] movies = repository.findAll();

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

