package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieInfo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MovieManagerZeroMoviesTest {

    private MovieManager manager = new MovieManager();

    @Test
    void getLastAdded() {
        MovieInfo[] actual = manager.getLastAdded();
        MovieInfo[] expected = new MovieInfo[]{};

        assertArrayEquals(expected, actual);
    }

}