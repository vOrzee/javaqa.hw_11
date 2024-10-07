package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.dto.Poster;

class PosterManagerTest {
    PosterManager posterManager;

    void setUpValues() {
        posterManager = new PosterManager();
        fillValues();
    }

    void setUpValues(int outputLimit) {
        posterManager = new PosterManager(outputLimit);
        fillValues();
    }

    void fillValues() {
        posterManager.addPoster(new Poster("The Shawshank Redemption", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", "https://m.media-amazon.com/images/M/MV5BNDE3ODAzMjcxNF5BMl5BanBnXkFtZTcwNTg0NDY4OQ@@._V1_SX300.jpg", "1994"));
        posterManager.addPoster(new Poster("The Godfather", "An organized crime dynasty's aging patriarch, now in his late 70s, calls in a protege from out of town to help his son take control of the family business.", "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtY2FiMS00N2YwLWE5ZjctYjBkMThlMjM5ZGIwXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg", "1972"));
        posterManager.addPoster(new Poster("The Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.", "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg", "2008"));
        posterManager.addPoster(new Poster("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.", "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg", "2010"));
        posterManager.addPoster(new Poster("The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", "https://m.media-amazon.com/images/M/MV5BNzA5ZDNkZDQtNDg0NS00ODQzLTg0ZmItYjYzZDQ1Yjk0ODNlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg", "2003"));
        posterManager.addPoster(new Poster("The Matrix", "A computer hacker learns from mysterious rebels about", "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg", "2010"));
    }

    @Test
    void testAddPoster() {
        setUpValues();
        posterManager.addPoster(new Poster("Inception 2", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.", "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg", "2010"));
        Poster[] actualPosters = posterManager.findAll();

        Poster[] expectedPosters = {
                new Poster("The Shawshank Redemption", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", "https://m.media-amazon.com/images/M/MV5BNDE3ODAzMjcxNF5BMl5BanBnXkFtZTcwNTg0NDY4OQ@@._V1_SX300.jpg", "1994"),
                new Poster("The Godfather", "An organized crime dynasty's aging patriarch, now in his late 70s, calls in a protege from out of town to help his son take control of the family business.", "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtY2FiMS00N2YwLWE5ZjctYjBkMThlMjM5ZGIwXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg", "1972"),
                new Poster("The Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.", "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg", "2008"),
                new Poster("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.", "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg", "2010"),
                new Poster("The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", "https://m.media-amazon.com/images/M/MV5BNzA5ZDNkZDQtNDg0NS00ODQzLTg0ZmItYjYzZDQ1Yjk0ODNlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg", "2003"),
                new Poster("The Matrix", "A computer hacker learns from mysterious rebels about", "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg", "2010"),
                new Poster("Inception 2", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.", "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg", "2010")
        };

        Assertions.assertArrayEquals(expectedPosters, actualPosters);
    }

    @Test
    void testGetAll() {
        setUpValues();
        Poster[] actualPosters = posterManager.findAll();

        Poster[] expectedPosters = {
                new Poster("The Shawshank Redemption", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", "https://m.media-amazon.com/images/M/MV5BNDE3ODAzMjcxNF5BMl5BanBnXkFtZTcwNTg0NDY4OQ@@._V1_SX300.jpg", "1994"),
                new Poster("The Godfather", "An organized crime dynasty's aging patriarch, now in his late 70s, calls in a protege from out of town to help his son take control of the family business.", "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtY2FiMS00N2YwLWE5ZjctYjBkMThlMjM5ZGIwXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg", "1972"),
                new Poster("The Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.", "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg", "2008"),
                new Poster("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.", "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg", "2010"),
                new Poster("The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", "https://m.media-amazon.com/images/M/MV5BNzA5ZDNkZDQtNDg0NS00ODQzLTg0ZmItYjYzZDQ1Yjk0ODNlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg", "2003"),
                new Poster("The Matrix", "A computer hacker learns from mysterious rebels about", "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg", "2010")
        };

        Assertions.assertArrayEquals(expectedPosters, actualPosters);
    }

    @Test
    void testGetLatestDefault() {
        setUpValues();
        Poster[] actualPosters = posterManager.findLast();

        Poster[] expectedPosters = {
                new Poster("The Matrix", "A computer hacker learns from mysterious rebels about", "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg", "2010"),
                new Poster("The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", "https://m.media-amazon.com/images/M/MV5BNzA5ZDNkZDQtNDg0NS00ODQzLTg0ZmItYjYzZDQ1Yjk0ODNlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg", "2003"),
                new Poster("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.", "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg", "2010"),
                new Poster("The Dark Knight", "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.", "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg", "2008"),
                new Poster("The Godfather", "An organized crime dynasty's aging patriarch, now in his late 70s, calls in a protege from out of town to help his son take control of the family business.", "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtY2FiMS00N2YwLWE5ZjctYjBkMThlMjM5ZGIwXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg", "1972")
        };

        Assertions.assertArrayEquals(expectedPosters, actualPosters);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "3,3", "6,6", "7,6", "5,5"})
    void testGetLatestCustom(int outputLimit, int expectedCount) {
        setUpValues(outputLimit);
        Poster[] actualPosters = posterManager.findLast();

        int actualCount = actualPosters.length;
        Assertions.assertEquals(expectedCount, actualCount);
    }
}

