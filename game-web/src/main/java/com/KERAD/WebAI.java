package com.KERAD;

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
