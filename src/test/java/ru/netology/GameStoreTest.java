package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void addGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        System.out.println (game.getTitle());
    }

    @Test
    public void shouldReturnFalseByNotAddGame() {

        GameStore store = new GameStore();
        Game game1 = new Game("Нетология", "Симуляторы", store);

        assertFalse(store.containsGame(game1));
    }

    @Test
    public void shouldFindPlayerMostHours() {

        GameStore store = new GameStore();

        store.addPlayTime("Anna", 7);
        store.addPlayTime("Max", 2);
        store.addPlayTime("Olga", 20);
        store.addPlayTime("Mary", 11);

        String expected = "Olga";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSumPlayTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Anna", 7);
        store.addPlayTime("Max", 2);
        store.addPlayTime("Max", 10);
        store.addPlayTime("Mary", 11);

        String expected = "Max";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void noPlayersPlay() {

        GameStore store = new GameStore();

        String expected = null;
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void bestPlayTimeOneHours() {

        GameStore store = new GameStore();

        store.addPlayTime("Anna", 1);
        store.addPlayTime("Max", 0);


        String expected = "Anna";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayedTime() {
        GameStore store = new GameStore();

        store.addPlayTime("Mila", 5);
        store.addPlayTime("Anna", 1);
        store.addPlayTime("Roy", 9);
        store.addPlayTime("Inna", 11);

        int expected = 26;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }



    // другие ваши тесты
}
