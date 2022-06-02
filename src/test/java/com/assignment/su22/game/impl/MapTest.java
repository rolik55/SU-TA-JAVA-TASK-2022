package com.assignment.su22.game.impl;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void setMap() {
        //Initialize the map
        Map map = new Map();
        for(int i = 0; i < map.getMAP_ROWS(); i ++) {
            for (int j = 0; j < map.getMAP_COLUMNS(); j++) {
                map.setMap(i, j, '.');
            }
        }
        //Check the result
        assertEquals('.', map.getMap()[1][2]);
    }

    @Test
    void readMapFromFile() throws IOException {
        //Initialize the map, .txt map file and the hummingbird vector
        Map map = new Map();
        Resource mapFile = new ClassPathResource("hummingbird_map_test.txt");
        Vector<Hummingbird> birds = new Vector<>();
        //Read the map from file
        map.readMapFromFile(birds, mapFile);
        //Check the result
        assertEquals(5, birds.size());
    }

    @Test
    void isEqualTrue() {
        //Initialize the maps
        Map map1 = new Map();
        Map map2 = new Map();
        for(int i = 0; i < map1.getMAP_ROWS(); i ++) {
            for (int j = 0; j < map1.getMAP_COLUMNS(); j++) {
                map1.setMap(i, j, '.');
                map2.setMap(i, j, '.');
            }
        }
        //Check the result
        assertTrue(map1.isEqual(map2));
    }

    @Test
    void isEqualFalse() {
        //Initialize the maps
        Map map1 = new Map();
        Map map2 = new Map();
        for(int i = 0; i < map1.getMAP_ROWS(); i ++) {
            for (int j = 0; j < map1.getMAP_COLUMNS(); j++) {
                map1.setMap(i, j, '.');
                map2.setMap(i, j, 'x');
            }
        }
        //Check the result
        assertFalse(map1.isEqual(map2));
    }

    @Test
    void cloneMap() {
        //Initialize the maps
        Map map1 = new Map();
        Map map2 = new Map();
        for(int i = 0; i < map1.getMAP_ROWS(); i ++) {
            for (int j = 0; j < map1.getMAP_COLUMNS(); j++) {
                map1.setMap(i, j, '.');
            }
        }
        //Clone the map
        map1.cloneMap(map2.getMap());
        //Check the result
        assertTrue(map1.isEqual(map2));
    }
}