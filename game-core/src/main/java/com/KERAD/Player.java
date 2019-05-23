package com.KERAD;

import java.util.Scanner;

class Player {
    final int MIN_INDEX = 1;
    final int MAX_INDEX = 9;
    final int ROW = 3;
    protected int score;
    protected char c;
    protected String name;
    Player(){
        score = 0;
    }
    public int putSymbol(char arr[]){ return -1; }
    public int getScore() {
        return score;
    }
    public void encScore() {
        score++;
    }
    public char getC() {
        return c;
    }
    public String getName() {
        return name;
    }
}