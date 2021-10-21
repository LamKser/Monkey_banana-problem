/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2;

import java.util.ArrayList;

/**
 *
 * @author Dinh Hoang Lam
 */
public class Ass2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //5x5 Matrix
        char test[][] = {
            {'0', '0', '0', 'A', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
            {'0', 'B', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
//        findSource('A', 'B', test);
        Maze maze = new Maze('A', 'B', test);
        maze.print();
        maze.findSource();

    }
}
/*
    source: x, y
    up: x-1, y
    down: x+1, y
    left: x, y-1
    right; x, y+1
 */
