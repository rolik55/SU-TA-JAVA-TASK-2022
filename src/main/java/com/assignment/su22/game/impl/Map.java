package com.assignment.su22.game.impl;

import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Map {
    private final int MAP_COLUMNS = 6;
    private final int MAP_ROWS = 5;
    private char[][] map;

    public Map() {
        map = new char[MAP_ROWS][MAP_COLUMNS];
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(int row, int column, char symbol) {
        this.map[row][column] = symbol;
    }

    public int getMAP_COLUMNS() {
        return MAP_COLUMNS;
    }

    public int getMAP_ROWS() {
        return MAP_ROWS;
    }

    /**
     * Read the game map from a file into an array
     *
     * @param birds    vector of hummingbirds for saving their location and direction on the map
     * @param resource file that the map is read from
     */
    public void readMapFromFile(Vector<Hummingbird> birds, Resource resource) throws IOException {
        //Open the .txt map file
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(resource.getFile())));
        while (scanner.hasNextLine()) {
            for (int i = 0; i < MAP_ROWS; i++) {
                //Read a single line
                String line = scanner.nextLine().trim();
                for (int j = 0; j < MAP_COLUMNS; j++) {
                    //Split the line into separate symbols
                    this.map[i][j] = line.charAt(j);
                    // save the coordinates and direction of the hummingbird
                    if (line.charAt(j) == '>' || line.charAt(j) == 'v') {
                        Hummingbird bird = new Hummingbird(i, j, line.charAt(j));
                        birds.add(bird);
                    }
                }
            }
        }
    }

    /**
     * Clone the map into another array
     *
     * @param map array that is cloned to
     */
    public void cloneMap(char[][] map) {
        for (int i = 0; i < this.map.length; i++) {
            map[i] = this.map[i].clone();
        }
    }

    /**
     * Compare two 2D arrays
     *
     * @param map array that is being compared to
     * @return true if arrays are equal, otherwise false
     */
    public boolean isEqual(Map map) {
        for (int i = 0; i < map.getMap().length; i++) {
            if (!Arrays.equals(this.map[i], map.getMap()[i])) {
                return false;
            }
        }
        return true;
    }
}
