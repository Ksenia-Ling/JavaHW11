package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieInfo;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {

    private MovieRepository repository = new MovieRepository();


    private MovieInfo first = new MovieInfo(1, "Номер Один", "Комедия", "url1");
    private MovieInfo second = new MovieInfo(2, "Тролли", "Мультфильм", "url2");
    private MovieInfo third = new MovieInfo(3, "Человек-невидимка", "Ужасы", "url3");
    private MovieInfo fourth = new MovieInfo(4, "Джентельмены", "Боевик", "url4");
    private MovieInfo fifth = new MovieInfo(5, "Отель Белград", "Комедия", "url5");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
    }
        @Test
        void shouldSaveAndFind() {

            MovieInfo sixth = new MovieInfo(6, "Вперёд", "Мультфильм", "url6");
            repository.save(sixth);

            MovieInfo[] actual = repository.findAll();
            MovieInfo[] expected = new MovieInfo[]{first, second, third, fourth, fifth, sixth};

            assertArrayEquals(expected, actual);
        }

    @Test
    void shouldFindById() {
        int id = 5;
        repository.findById(id);

        MovieInfo actual = repository.findById(id);
        MovieInfo expected = fifth;

        assertEquals(expected, actual);

    }

    @Test
    void shouldFindByIdIfNotExist() {
        int id = 6;
        repository.findById(id);

        MovieInfo actual = repository.findById(id);
        MovieInfo expected = null;

        assertEquals(expected, actual);

    }

    @Test
    void shouldRemoveById() {
        int id = 2;
        repository.removeById(id);

        MovieInfo[] actual = repository.findAll();
        MovieInfo[] expected = new MovieInfo[]{first, third, fourth, fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {

        repository.removeAll();

        MovieInfo[] actual = repository.findAll();
        MovieInfo[] expected = new MovieInfo[]{};

        assertArrayEquals(expected, actual);

    }
}