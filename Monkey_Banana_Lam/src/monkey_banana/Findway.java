/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monkey_banana;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author ADMIN
 */
public class Findway {

    public static void main(String[] args) {
        int a[][] = {{0, 1, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 4, 0},
                     {2, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 0, 0},
                     {0, 0, 0, 0, 0, 3, 0}};
        
        MonkeyBananaSolution sol = new MonkeyBananaSolution(a);
        // Điểm không trùng nhau
        sol.botPlay();
    }
}
