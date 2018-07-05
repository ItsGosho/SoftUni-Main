package app.services;

import app.entities.Game;
import app.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameSerImpl implements GameServices{
    private GameRepository gameRepository;

    @Autowired
    public GameSerImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void saveGame(Game game) {
        this.gameRepository.save(game);
    }

    @Override
    public List<Game> getAll() {
        return this.gameRepository.findAll();
    }

    @Override
    public Game getGameByTitle(String title) {
        return this.gameRepository.getGameByTitle(title);
    }
}
