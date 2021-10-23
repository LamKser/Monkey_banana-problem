/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monkey_banana;

import interfere.Utils;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;


/**
 *
 * @author ADMIN
 */
public class Final {

    public static void main(String[] args) {
        MonkeyBananaLam sol = new MonkeyBananaLam(Utils.a);
        Utils.createMap();
        Utils.showMap(Utils.a);
        sol.botPlay();
    }
}
