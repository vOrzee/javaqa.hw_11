package ru.netology.services;

import lombok.AccessLevel;
import lombok.Setter;
import ru.netology.dto.Poster;

public class PosterManager {
    private Poster[] posters = new Poster[0];
    private final int outputLimit;

    @Setter(AccessLevel.PROTECTED)
    private OutputService outputService = new OutputService();

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

    public void findAll() {
        for (Poster poster : posters) {
            outputService.printInConsole(poster.toString()); // "Вывод"
        }
    }

    public void findLast() {
        int outputSize = posters.length;
        if (outputSize > outputLimit) {
            outputSize = outputLimit;
        }
        for (int i = 0; i < outputSize; i++) {
            outputService.printInConsole(posters[posters.length - 1 - i].toString()); // "Вывод"
        }
    }

    public Poster[] getAll() {
        return posters; // "Возврат"
    }

    public Poster[] getLatest() {
        int outputArraySize = posters.length;
        if (outputArraySize > outputLimit) {
            outputArraySize = outputLimit;
        }
        Poster[] lastPosters= new Poster[outputArraySize];

        for (int i = 0; i < outputArraySize; i++) {
            lastPosters[i] = posters[posters.length - 1 - i];
        }
        return lastPosters; // "Возврат"
    }

}
