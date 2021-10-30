/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monkey_banana;

import algorithm.MonkeyBananaSolution;
import interfere.Utils;
import menu_list.I_Menu;
import menu_list.Menu;
import users.BotPlay;
import users.UserPlay;
import users.UserWithInstruction;


/**
 *
 * @author ADMIN
 */
public class Findway {
    public static void main(String[] args) throws InterruptedException {
        I_Menu menu = new Menu();
        menu.addItems("Welcome to MONKEY and BANANA");
        menu.addItems("GAME START");
        menu.addItems("1. Play");
        menu.addItems("2. Play with Instruction");
        menu.addItems("3. Bot Play");
        
        menu.showMenu();
        int choice = menu.getChoice();
        switch(choice){
            case 1:
                UserPlay.userPlay(Utils.a);
                break;
            case 2:
                UserWithInstruction.userPlaywithIns(Utils.a);
                break;
            case 3:
                BotPlay.botplay(Utils.a);
                break;
        }
    }
}
