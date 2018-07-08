package entities.arenas.interfaces;

import entities.characters.interfaces.ComicCharacter;

public interface Arena {
    String getArenaName();

	boolean isArenaFull();

	void addHero(ComicCharacter hero);

	void addAntiHero(ComicCharacter antiHero);

	boolean fightHeroes();

}
