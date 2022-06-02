package com.assignment.su22.game.impl;

public class Hummingbird {
    private int row;
    private int column;
    private char direction;
    private int moveTo;

    public Hummingbird(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction;
    }

    public int getMoveTo() {
        return moveTo;
    }

    public void setMoveTo(int moveTo) {
        this.moveTo = moveTo;
    }

    /**
     * Function for making the hummingbirds move
     *
     * @param map       Map where the hummingbirds are moving
     * @param direction Specified direction is to make sure that the hummingbirds are moving only in one direction (first to the right, secondly downwards)
     */
    public void move(Map map, String direction) {
        this.moveTo = findMove(map);
        if (this.direction == '>' && this.moveTo != -1 && direction == "right") {
            map.setMap(this.row, this.column, '.');
            map.setMap(this.row, this.moveTo, '>');
            this.column = this.moveTo;
        } else if (this.direction == 'v' && this.moveTo != -1 && direction == "down") {
            map.setMap(this.row, this.column, '.');
            map.setMap(this.moveTo, this.column, 'v');
            this.row = this.moveTo;
        }
    }

    /**
     * Finds the next possible move for the hummingbird
     *
     * @param map Map where the hummingbirds are moving
     * @return int coordinate for the next move, -1 if there is no move available
     */
    public int findMove(Map map) {
        if (this.getDirection() == '>') {
            for (int i = this.getColumn() + 1; i <= map.getMAP_COLUMNS(); i++) {
                // Loop over the border
                if (i == map.getMAP_COLUMNS())
                    i = 0;
                if (map.getMap()[this.getRow()][i] == '.')
                    return i;
                else if (map.getMap()[this.getRow()][i] == '>' || map.getMap()[this.getRow()][i] == 'v')
                    break;
            }
        } else {
            for (int i = this.getRow() + 1; i <= map.getMAP_ROWS(); i++) {
                // Loop over the border
                if (i == map.getMAP_ROWS())
                    i = 0;
                if (map.getMap()[i][this.getColumn()] == '.')
                    return i;
                else if (map.getMap()[i][this.getColumn()] == '>' || map.getMap()[i][this.getColumn()] == 'v')
                    break;
            }
        }
        return -1;
    }
}
