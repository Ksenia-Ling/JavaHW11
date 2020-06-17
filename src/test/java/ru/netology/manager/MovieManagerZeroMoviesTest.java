package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieInfo;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

class MovieManagerZeroMoviesTest {

    @Mock
    MovieRepository repository;

    @InjectMocks
    private MovieManager manager;

    @Test
    void getLastAdded() {

        MovieInfo[] returned = new MovieInfo[]{};
        doReturn(returned).when(repository).findAll();


        MovieInfo[] actual = manager.getLastAdded();
        MovieInfo[] expected = new MovieInfo[]{};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void getLastAddedIfAfficheLengthBelowZero() {

        MovieManager manager = new MovieManager(repository, 0);

        MovieInfo[] returned = new MovieInfo[]{};
        doReturn(returned).when(repository).findAll();


        MovieInfo[] actual = manager.getLastAdded();
        MovieInfo[] expected = new MovieInfo[]{};

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

}