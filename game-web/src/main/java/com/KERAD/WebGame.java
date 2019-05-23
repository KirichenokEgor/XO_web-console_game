package com.KERAD;

class WebGame extends Game {
    WebGame(){
        int choice = menu3("1. PersonVsPerson", "2. PersonVsComputer", "3. Quit");
        switch (choice){
            case 1:
                pl1 = new WebRealPlayer('X');
                pl2 = new WebRealPlayer('O');
                break;
            case 2:
                pl1 = new WebRealPlayer('X');
                pl2 = new WebAI('O');
                break;
            case 3:
                isQuit = true;
                break;
        }
    }
    @Override
    int menu3(String str1, String str2, String str3){
        int choice = 0;
        ///////////////
        return choice;
    }
    @Override
    public void refresh(){
        ///////////////
    }
}
