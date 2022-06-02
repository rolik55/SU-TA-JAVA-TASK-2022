package com.assignment.su22.game.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HummingbirdTest {

    @Test
    void move() {
        //Initialize the map
        Map map = new Map();
        for(int i = 0; i < map.getMAP_ROWS(); i ++){
            for(int j = 0; j < map.getMAP_COLUMNS(); j++){
                map.setMap(i, j, '.');
            }
        }
        //Initialize a hummingbird
        Hummingbird bird = new Hummingbird(0, 1, 'v');
        //Make the bird move
        bird.move(map, "right");
        bird.move(map, "down");
        //Check the result
        assertEquals('v', map.getMap()[1][1]);
        assertEquals('.', map.getMap()[0][1]);
    }

    @Test
    void findMove() {
        //Initialize the map
        Map map = new Map();
        for(int i = 0; i < map.getMAP_ROWS(); i ++){
            for(int j = 0; j < map.getMAP_COLUMNS(); j++){
                map.setMap(i, j, '.');
            }
        }
        //Initialize a hummingbird
        Hummingbird bird = new Hummingbird(0, 1, 'v');
        //Search for a possible move
        int result = bird.findMove(map);
        //Check the result
        assertEquals(1, result);
    }
}