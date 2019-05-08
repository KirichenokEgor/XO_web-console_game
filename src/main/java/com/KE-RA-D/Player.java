package com.KE-RA-D;

import java.util.Scanner;

class Player extends Constants{
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

class ConsoleRealPlayer extends Player {
    ConsoleRealPlayer(char c){
        this.c = c;
        Scanner sc = new Scanner(System.in);
        if(c == 'X') System.out.print("Введите имя игрока 1: ");
        else System.out.print("Введите имя игрока 2: ");
        name = sc.next();//до пробела
    }
    private int wait_for_input(char arr[]){
        int index = 0;
        while(index < MIN_INDEX || index > MAX_INDEX || arr[index - 1] == 'X' || arr[index - 1] == 'O') {
            System.out.print("Введите номер клеточки(или 0 для выхода): ");
            Scanner sc = new Scanner(System.in);
            index = sc.nextInt();
            if (index == 0) return index;
            if (index < MIN_INDEX || index > MAX_INDEX || arr[index - 1] == 'X' || arr[index - 1] == 'O') System.out.print("Номер должен быть от 1 до 9! Клеточка должна быть свободна! ");
        }
        return index;
    }
    @Override
    public int putSymbol(char arr[]){
        //System.out.println("Ход игрока " + getName());
        int index = wait_for_input(arr) - 1;
        if(index == -1) return -1;//выход
        arr[index] = c;
        return 0;
    }
}

class ConsoleAI extends Player {
    ConsoleAI(char c){
        this.c = c;
        name = "AI";//до пробела
    }
    @Override
    public int putSymbol(char arr[]){
        int index = 0;
        //System.out.println("Ход " + getName());
        //алгоритм поиска индекса+1
        if(arr[4] != 'X' && arr[4] != 'O') { arr[4] = c; return 0; }
        if(arr[0] != 'X' && arr[0] != 'O') { arr[0] = c; return 0; }
        if(arr[0] == c) {
            if(arr[8] != 'X' && arr[8] != 'O') { arr[8] = c; return 0; }
            if(arr[1] != c && arr[1] != '2') if(arr[7] != 'X' && arr[7] != 'O') { arr[7] = c; return 0; }
            if(arr[3] != c && arr[3] != '4') if(arr[5] != 'X' && arr[5] != 'O') { arr[5] = c; return 0; }
            if(arr[5] != c && arr[5] != '6') if(arr[3] != 'X' && arr[3] != 'O') { arr[3] = c; return 0; }
            if(arr[7] != c && arr[7] != '8') if(arr[1] != 'X' && arr[1] != 'O') { arr[1] = c; return 0; }
        }else {
            if(arr[2] != 'X' && arr[2] != 'O') { arr[2] = c; return 0; }
            if(arr[2] == c){
                if(arr[8] != 'X' && arr[8] != 'O') { arr[8] = c; return 0; }
                if(arr[1] != c && arr[1] != '2') if(arr[7] != 'X' && arr[7] != 'O') { arr[7] = c; return 0; }
                if(arr[3] != c && arr[3] != '4') if(arr[5] != 'X' && arr[5] != 'O') { arr[5] = c; return 0; }
                if(arr[5] != c && arr[5] != '6') if(arr[3] != 'X' && arr[3] != 'O') { arr[3] = c; return 0; }
                if(arr[7] != c && arr[7] != '8') if(arr[1] != 'X' && arr[1] != 'O') { arr[1] = c; return 0; }
            }else {
                if(arr[6] != 'X' && arr[6] != 'O') { arr[6] = c; return 0; }
                if(arr[8] != 'X' && arr[8] != 'O') { arr[8] = c; return 0; }
                if(arr[1] != c && arr[1] != '2') if(arr[7] != 'X' && arr[7] != 'O') { arr[7] = c; return 0; }
                if(arr[3] != c && arr[3] != '4') if(arr[5] != 'X' && arr[5] != 'O') { arr[5] = c; return 0; }
                if(arr[5] != c && arr[5] != '6') if(arr[3] != 'X' && arr[3] != 'O') { arr[3] = c; return 0; }
                if(arr[7] != c && arr[7] != '8') if(arr[1] != 'X' && arr[1] != 'O') { arr[1] = c; return 0; }
            }
        }

        while (arr[index] == 'X' || arr[index] == 'O') { //заменить потом на что-нибудь нормальное
            index++;
        }
        arr[index] = c;
        return 0;
    }
}

class WebRealPlayer extends Player {
    WebRealPlayer(char c){
//        this.c = c;
//        Scanner sc = new Scanner(System.in);
//        if(c == 'X') System.out.print("Введите имя игрока 1: ");
//        else System.out.print("Введите имя игрока 2: ");
//        name = sc.next();//до пробела
    }
    private int wait_for_input(char arr[]){
        int index = 0;
//        while(index < MIN_INDEX || index > MAX_INDEX || arr[index - 1] == 'X' || arr[index - 1] == 'O') {
//            System.out.print("Введите номер клеточки(или 0 для выхода): ");
//            Scanner sc = new Scanner(System.in);
//            index = sc.nextInt();
//            if (index == 0) return index;
//            if (index < MIN_INDEX || index > MAX_INDEX || arr[index - 1] == 'X' || arr[index - 1] == 'O') System.out.print("Номер должен быть от 1 до 9! Клеточка должна быть свободна! ");
//        }
        return index;
    }
    @Override
    public int putSymbol(char arr[]){
        //System.out.println("Ход игрока " + getName());
        int index = wait_for_input(arr) - 1;
        if(index == -1) return -1;//выход
        arr[index] = c;
        return 0;
    }
}

class WebAI extends Player {
    WebAI(char c){
        this.c = c;
        name = "AI";//до пробела
    }
    @Override
    public int putSymbol(char arr[]){
        int index = 0;
        //System.out.println("Ход " + getName());
        //алгоритм поиска индекса+1
        if(arr[4] != 'X' && arr[4] != 'O') { arr[4] = c; return 0; }
        if(arr[0] != 'X' && arr[0] != 'O') { arr[0] = c; return 0; }
        if(arr[0] == c) {
            if(arr[8] != 'X' && arr[8] != 'O') { arr[8] = c; return 0; }
            if(arr[1] != c && arr[1] != '2') if(arr[7] != 'X' && arr[7] != 'O') { arr[7] = c; return 0; }
            if(arr[3] != c && arr[3] != '4') if(arr[5] != 'X' && arr[5] != 'O') { arr[5] = c; return 0; }
            if(arr[5] != c && arr[5] != '6') if(arr[3] != 'X' && arr[3] != 'O') { arr[3] = c; return 0; }
            if(arr[7] != c && arr[7] != '8') if(arr[1] != 'X' && arr[1] != 'O') { arr[1] = c; return 0; }
        }else {
            if(arr[2] != 'X' && arr[2] != 'O') { arr[2] = c; return 0; }
            if(arr[2] == c){
                if(arr[8] != 'X' && arr[8] != 'O') { arr[8] = c; return 0; }
                if(arr[1] != c && arr[1] != '2') if(arr[7] != 'X' && arr[7] != 'O') { arr[7] = c; return 0; }
                if(arr[3] != c && arr[3] != '4') if(arr[5] != 'X' && arr[5] != 'O') { arr[5] = c; return 0; }
                if(arr[5] != c && arr[5] != '6') if(arr[3] != 'X' && arr[3] != 'O') { arr[3] = c; return 0; }
                if(arr[7] != c && arr[7] != '8') if(arr[1] != 'X' && arr[1] != 'O') { arr[1] = c; return 0; }
            }else {
                if(arr[6] != 'X' && arr[6] != 'O') { arr[6] = c; return 0; }
                if(arr[8] != 'X' && arr[8] != 'O') { arr[8] = c; return 0; }
                if(arr[1] != c && arr[1] != '2') if(arr[7] != 'X' && arr[7] != 'O') { arr[7] = c; return 0; }
                if(arr[3] != c && arr[3] != '4') if(arr[5] != 'X' && arr[5] != 'O') { arr[5] = c; return 0; }
                if(arr[5] != c && arr[5] != '6') if(arr[3] != 'X' && arr[3] != 'O') { arr[3] = c; return 0; }
                if(arr[7] != c && arr[7] != '8') if(arr[1] != 'X' && arr[1] != 'O') { arr[1] = c; return 0; }
            }
        }

        while (arr[index] == 'X' || arr[index] == 'O') { //заменить потом на что-нибудь нормальное
            index++;
        }
        arr[index] = c;
        return 0;
    }
}