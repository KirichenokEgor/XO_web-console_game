package com.KERAD;

import java.util.Scanner;

class ConsoleGame extends Game {
    ConsoleGame() {
        int choice = menu3("1. PersonVsPerson", "2. PersonVsComputer", "3. Quit");
        switch (choice) {
            case 1:
                pl1 = new ConsoleRealPlayer('X');
                pl2 = new ConsoleRealPlayer('O');
                break;
            case 2:
                pl1 = new ConsoleRealPlayer('X');
                pl2 = new ConsoleAI('O');
                break;
            case 3:
                isQuit = true;
                break;
        }
    }
    @Override
    int menu3(String str1, String str2, String str3){
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while(choice < 1 || choice > 3) {
            System.out.println("--------------------");
            System.out.println(str1);//"1. PersonVsPerson","2. PersonVsComputer","3. Quit"
            System.out.println(str2);
            System.out.println(str3);
            choice = sc.nextInt();
        }
        return choice;
    }
    @Override
    public void refresh(){
        if(isQuit) return;
        System.out.println(" -------------");
        for(int i = MAX_INDEX; i >= MIN_INDEX; i -= ROW){
            System.out.print(" | " + arr[i - 3]);
            System.out.print(" | " + arr[i - 2]);
            System.out.print(" | " + arr[i - 1]);
            System.out.println(" |");
            System.out.println(" -------------");
        }
    }

    @Override
    public int step(Player pl) {
        System.out.println("Ход игрока " + pl.getName());
        return super.step(pl);
    }
}
