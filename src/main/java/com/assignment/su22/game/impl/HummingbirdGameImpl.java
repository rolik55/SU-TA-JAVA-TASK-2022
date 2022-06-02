package com.assignment.su22.game.impl;

import com.assignment.su22.game.HummingbirdGame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Vector;

@Component
@Slf4j
public class HummingbirdGameImpl implements HummingbirdGame {
    // Number of turns taken until the end of the game
    private int iterations = 0;
    // Initial state of the map used for finding if the game is looping or not
    private Map initialMap = new Map();
    // Map that is going to be updated and used for the game
    private Map map = new Map();
    // A vector of hummingbirds to avoid searching for them throughout the whole map array
    Vector<Hummingbird> birds = new Vector<>();

    /**
     * Finds the number of game turns until it stops or begins looping from the beginning
     *
     * @param resource .txt map file
     * @return number of turns taken
     */
    @Override
    public int hummingbirdGame(Resource resource) throws IOException {
        initialMap.readMapFromFile(birds, resource);
        initialMap.cloneMap(map.getMap());
        play(map, initialMap, birds);
        return iterations;
    }

    /**
     * Main game loop
     *
     * @param map        Map where the hummingbirds are moving
     * @param initialMap Initial state of the map for comparison (if it's looping)
     * @param birds      Hummingbird location and direction data
     */
    public void play(Map map, Map initialMap, Vector<Hummingbird> birds) {
        while (areAvailableMoves(map, birds)) {
            for (Hummingbird bird : birds) {
                bird.move(map, "right");
            }
            for (Hummingbird bird : birds) {
                bird.move(map, "down");
            }
            iterations++;
            //If the game starts looping - end
            if (map.isEqual(initialMap))
                break;
        }
    }

    /**
     * Checks if there is at least 1 move available
     *
     * @param map   Map where the hummingbirds are moving
     * @param birds Hummingbird location and direction data
     * @return True if there is at least 1 available move, otherwise returns false
     */
    public boolean areAvailableMoves(Map map, Vector<Hummingbird> birds) {
        for (Hummingbird bird : birds) {
            bird.setMoveTo(bird.findMove(map));
            if (bird.getMoveTo() != -1)
                return true;
        }
        return false;
    }
}
