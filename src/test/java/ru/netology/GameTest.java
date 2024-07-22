package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void shouldRegisterPlayers() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 10);
        game.register(player1);

        // Проверим, что игрок зарегистрирован
        assertEquals(player1, game.findByName("Player1"));
    }

    @Test
    public void shouldThrowExceptionIfPlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 10);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Player1", "Player2");
        });
    }

    @Test
    public void shouldReturn1WhenFirstPlayerWins() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 20);
        Player player2 = new Player(2, "Player2", 10);
        game.register(player1);
        game.register(player2);

        assertEquals(1, game.round("Player1", "Player2"));
    }

    @Test
    public void shouldReturn2WhenSecondPlayerWins() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 10);
        Player player2 = new Player(2, "Player2", 20);
        game.register(player1);
        game.register(player2);

        assertEquals(2, game.round("Player1", "Player2"));
    }

    @Test
    public void shouldReturn0WhenDraw() {
        Game game = new Game();
        Player player1 = new Player(1, "Player1", 10);
        Player player2 = new Player(2, "Player2", 10);
        game.register(player1);
        game.register(player2);

        assertEquals(0, game.round("Player1", "Player2"));
    }
}
