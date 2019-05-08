package com.KE-RA-D;

public class X_O_game extends Constants{
    public static void main(String args[]){
        Game g = new ConsoleGame();
        int ch1, ch2, choice;
        while(!g.isQuit) {
            do {
                choice = g.menu3("1. New round", "2. Statistics", "3. Quit");
                switch (choice) {
                    case 1:
                        g.newG();
                        break;
                    case 2:
                        System.out.println("--------------------");
                        System.out.println("Rounds: " + g.getRounds());
                        System.out.println(g.pl1.getName() + ": " + g.pl1.getScore());
                        System.out.println(g.pl2.getName() + ": " + g.pl2.getScore());
                        break;
                    case 3:
                        g.isQuit = true;
                        break;
                }
            }while(choice == 2);
            if(g.isQuit)break;

            ch1 = 0;
            ch2 = 0;
            while (ch1 == 0 && ch2 == 0) {
                ch1 = g.step(g.pl1);
                if(ch1 == 1 || ch1 == 2 || ch1 == -1) break;
                ch2 = g.step(g.pl2);
            }
            if(g.isQuit)break;
            if(ch1 == -1 || ch2 == -1) break;
            if(ch1 == 2 || ch2 == 2) System.out.println("Ничья!");
            if(ch1 == 1) System.out.println(g.pl1.getName() + " победил!");
            if(ch2 == 1) System.out.println(g.pl2.getName() + " победил!");
            g.rounds++; // мб добавить проверку, что это именно конец матча, а не выход во время игры (done)
        }
    }
}