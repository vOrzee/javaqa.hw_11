package ru.netology.services;

import ru.netology.dto.Poster;

public class PosterManager {
    private Poster[] posters = new Poster[0];
    private final int outputLimit;

    public PosterManager(int outputLimit) {
        this.outputLimit = outputLimit;
    }

    public PosterManager() {
        this(5);
    }

    public void addPoster(Poster poster) {
        Poster[] newPosters = new Poster[posters.length + 1];
        System.arraycopy(posters, 0, newPosters, 0, posters.length); // подсказка replace от IDE
        newPosters[posters.length] = poster;
        posters = newPosters;
    }

    public Poster[] findAll() {
        return posters; // "Возврат"
    }

    public Poster[] findLast() {
        int outputArraySize = posters.length;
        if (outputArraySize > outputLimit) {
            outputArraySize = outputLimit;
        }
        Poster[] lastPosters = new Poster[outputArraySize];

        for (int i = 0; i < outputArraySize; i++) {
            lastPosters[i] = posters[posters.length - 1 - i];
        }
        return lastPosters; // "Возврат"
    }

}
