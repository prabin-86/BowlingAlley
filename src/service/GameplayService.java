package service;

import pojo.Gameplay;

/**
 * Created by prabinb on 12/05/17.
 */
public interface GameplayService {

    Gameplay createGame();

    void play();

    int nextTurn();
}
