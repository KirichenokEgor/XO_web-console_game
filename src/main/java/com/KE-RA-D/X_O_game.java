//import java.io.IOException;
import java.util.Scanner;

abstract class Constants{
    final int MIN_INDEX = 1;
    final int MAX_INDEX = 9;
    final int ROW = 3;
    /*void clearConsole() throws IOException, InterruptedException {
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    }*/
    public static int menu3(String str1, String str2, String str3)/* throws IOException, InterruptedException */{
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while(choice < 1 || choice > 3) {
            //clearConsole(); //does not work
            System.out.println("--------------------");
            System.out.println(str1);//"1. PersonVsPerson","2. PersonVsComputer","3. Quit"
            System.out.println(str2);
            System.out.println(str3);
            choice = sc.nextInt();
        }
        return choice;
    }
}

class Player extends Constants{
    protected int score;
    protected char c;
    protected String name;
    Player(){
        score = 0;
    }
    private int wait_for_input(char arr[]){
        int index = 0;
        System.out.println("Ход игрока " + getName());
        while(index < MIN_INDEX || index > MAX_INDEX || arr[index - 1] == 'X' || arr[index - 1] == 'O') {
            System.out.print("Введите номер клеточки(или 0 для выхода): ");
            Scanner sc = new Scanner(System.in);
            index = sc.nextInt();
            if (index == 0) return index;
            if (index < MIN_INDEX || index > MAX_INDEX || arr[index - 1] == 'X' || arr[index - 1] == 'O') System.out.print("Номер должен быть от 1 до 9! Клеточка должна быть свободна! ");
        }
        return index;
    }
    public int putSymbol(char arr[]){
        int index = wait_for_input(arr) - 1;
        if(index == -1) return -1;//выход
        arr[index] = c;
        return 0;
    }
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

class RealPlayer extends Player {
    RealPlayer(char c){
        this.c = c;
        Scanner sc = new Scanner(System.in);
        if(c == 'X') System.out.print("Введите имя игрока 1: ");
        else System.out.print("Введите имя игрока 2: ");
        name = sc.next();//до пробела
    }
}

class ArtIntelligence extends Player {
    ArtIntelligence(char c){
        this.c = c;
        name = "AI";//до пробела
    }
    @Override
    public int putSymbol(char arr[]){
        int index = 0;
        System.out.println("Ход " + getName());
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

class Game extends Constants {
    private char arr[];
    Player pl1;
    Player pl2;
    boolean isQuit;
    int rounds;

    Game()/* throws IOException, InterruptedException */{
        arr = new char[MAX_INDEX];
        for (int i = MIN_INDEX; i <= MAX_INDEX; i++)
            arr[i - 1] = (char) (i - 1 + '1');
        int choice = menu3("1. PersonVsPerson", "2. PersonVsComputer", "3. Quit");
        isQuit = false;
        rounds = 0;
        switch (choice){
            case 1:
                pl1 = new RealPlayer('X');
                pl2 = new RealPlayer('O');
                break;
            case 2:
                pl1 = new RealPlayer('X');
                pl2 = new ArtIntelligence('O');
                break;
            case 3:
                isQuit = true;
                break;
        }
    }
    public void refresh()/* throws IOException, InterruptedException */{
        //Runtime.getRuntime().exec("cls");  //does not work
        if(isQuit) return;
        //clearConsole();  //does not work
        System.out.println(" -------------");
        for(int i = MAX_INDEX; i >= MIN_INDEX; i -= ROW){
            System.out.print(" | " + arr[i - 3]);
            System.out.print(" | " + arr[i - 2]);
            System.out.print(" | " + arr[i - 1]);
            System.out.println(" |");
            System.out.println(" -------------");
        }
    }
    public void newG()/* throws IOException, InterruptedException */{
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

public class X_O_game extends Constants{
    public static void main(String args[])/* throws IOException, InterruptedException */{
        Game g = new Game();
        int ch1, ch2, choice;
        while(!g.isQuit) {
            do {
                choice = menu3("1. New round", "2. Statistics", "3. Quit");
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