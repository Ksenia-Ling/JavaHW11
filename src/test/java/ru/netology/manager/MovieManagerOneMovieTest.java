package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieInfo;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class MovieManagerOneMovieTest {

    @Mock
    MovieRepository repository;

    @InjectMocks
    private MovieManager manager;

    private MovieInfo first = new MovieInfo(1, "Номер Один", "Комедия", "url1");


    @Test
    void getLastAdded() {

        MovieInfo[] returned = new MovieInfo[]{first};
        doReturn(returned).when(repository).findAll();

        MovieInfo[] actual = manager.getLastAdded();
        MovieInfo[] expected = new MovieInfo[]{first};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void getLastIfAfficheLengthIsNotZero() {

        MovieManager manager = new MovieManager(repository,1);

        MovieInfo[] returned = new MovieInfo[]{first};
        doReturn(returned).when(repository).findAll();

        MovieInfo[] actual = manager.getLastAdded();
        MovieInfo[] expected = new MovieInfo[]{first};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();

    }


    @Test
    void getLastIfAfficheLengthIsOverLimit() {

        MovieManager manager = new MovieManager(repository,5);

        MovieInfo[] returned = new MovieInfo[]{first};
        doReturn(returned).when(repository).findAll();

        MovieInfo[] actual = manager.getLastAdded();
        MovieInfo[] expected = new MovieInfo[]{first};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();

    }

}