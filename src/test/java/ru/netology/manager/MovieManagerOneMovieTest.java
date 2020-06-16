package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieInfo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MovieManagerOneMovieTest {

    private MovieManager manager = new MovieManager();
    private MovieInfo first = new MovieInfo(1, "Номер Один", "Комедия", "url1");

    public void setUp(MovieManager manager) {
        manager.add(first);
    }

    @Test
    void getLastAdded() {

        setUp(manager);
        MovieInfo[] actual = manager.getLastAdded();
        MovieInfo[] expected = new MovieInfo[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastIfAfficheLengthIsOverLimit() {
        MovieManager manager = new MovieManager(5);
        setUp(manager);

        MovieInfo[] actual = manager.getLastAdded();
        MovieInfo[] expected = new MovieInfo[]{first};

        assertArrayEquals(expected, actual);
    }

}