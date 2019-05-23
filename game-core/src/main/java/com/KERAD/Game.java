package com.KERAD;

import java.util.Scanner;

class Game {
    final int MIN_INDEX = 1;
    final int MAX_INDEX = 9;
    final int ROW = 3;
    protected char arr[];
    Player pl1;
    Player pl2;
    boolean isQuit;
    int rounds;

    Game(){
        arr = new char[MAX_INDEX];
        for (int i = MIN_INDEX; i <= MAX_INDEX; i++)
            arr[i - 1] = (char) (i - 1 + '1');

        isQuit = false;
        rounds = 0;
    }
    int menu3(String str1, String str2, String str3){ return 0; }
    public void refresh(){ }
    public void newG(){
        for (int i = MIN_INDEX; i <= MAX_INDEX; i++)
            arr[i - 1] = (char) (i - 1 + '1');
        refresh();
    }
    public int checkWin(char c){
        if((arr[0] == c && arr[1] == c && arr[2] == c) || (arr[3] == c && arr[4] == c && arr[5] == c) || (arr[6] == c && arr[7] == c && arr[8] == c)) return 1; //строки
        if((arr[0] == c && arr[3] == c && arr[6] == c) || (arr[1] == c && arr[4] == c && arr[7] == c) || (arr[2] == c && arr[5] == c && arr[8] == c)) return 1; //столбцы
        if((arr[0] == c && arr[4] == c && arr[8] == c) || (arr[2] == c && arr[4] == c && arr[6] == c)) return 1; //диагонали
        return 0;
    }
    public int check(Player pl){
        if(checkWin(pl.getC()) == 1) { pl.encScore(); return 1;} //выигрыш
        for(int i = 0; i < MAX_INDEX; i++) if(arr[i] != 'X' && arr[i] != 'O') return 0; //еще есть пустые клетки
        return 2; //поле заполнено
    }
    public int step(Player pl){
        //System.out.println("Ход игрока " + pl.getName());
        if(pl.putSymbol(arr) == -1) return -1;
        refresh();
        int ch = check(pl);//0 - nothing, 1 - curr. player had won, 2 - full
        if(ch == 1) return 1;
        if(ch == 2) return 2;
        return 0;
    }
    public int getRounds() {
        return rounds;
    }
}
