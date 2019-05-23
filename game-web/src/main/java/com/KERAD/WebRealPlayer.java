package com.KERAD;

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

