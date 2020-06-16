package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieInfo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MovieManagerSomeMoviesTest {

    private MovieManager manager = new MovieManager();
    private MovieInfo first = new MovieInfo(1, "Номер Один", "Комедия", "url1");
    private MovieInfo second = new MovieInfo(2, "Тролли", "Мультфильм", "url2");
    private MovieInfo third = new MovieInfo(3, "Человек-невидимка", "Ужасы", "url3");
    private MovieInfo fourth = new MovieInfo(4, "Джентельмены", "Боевик", "url4");
    private MovieInfo fifth = new MovieInfo(5, "Отель Белград", "Комедия", "url5");
    private MovieInfo sixth = new MovieInfo(6, "Вперёд", "Мультфильм", "url6");
    private MovieInfo seventh = new MovieInfo(7, "Бладшот", "Боевик", "url7");
    private MovieInfo eighth = new MovieInfo(8, "Король Лев", "Мультфильм", "url8");
    private MovieInfo ninth = new MovieInfo(9, "Аквамен", "Приключения", "url9");
    private MovieInfo tenth = new MovieInfo(10, "Сайлент Хилл", "Ужасы", "url10");
    private MovieInfo eleventh = new MovieInfo(11, "Аватар", "Приключения", "url11");
    private MovieInfo twelfth = new MovieInfo(12, "Форма воды", "Драма", "url12");

    public void setUp(MovieManager manager) {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
    }

    @Test
    void addAndGet() {

        setUp(manager);
        MovieInfo thirteenth = new MovieInfo(13, "Убить Билла", "Боевик", "url13");
        manager.add(thirteenth);

        MovieInfo[] actual = manager.getLastAdded();
        MovieInfo[] expected = new MovieInfo[]{thirteenth, twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void getLast() {
        MovieManager manager = new MovieManager(5);
        setUp(manager);

        MovieInfo[] actual = manager.getLastAdded();
        MovieInfo[] expected = new MovieInfo[]{twelfth, eleventh, tenth, ninth, eighth};

        assertArrayEquals(expected, actual);
    }
}
