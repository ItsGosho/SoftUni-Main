package app.services;

import app.entities.Game;

import java.util.List;

public interface GameServices {

    void saveGame(Game game);

    List<Game> getAll();

    Game getGameByTitle(String title);
}
