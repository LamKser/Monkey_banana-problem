/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2;

/**
 *
 * @author Dinh Hoang Lam
 */
public class Cell {
    char emptyVal = '0';
    int x, y;
    int dist;
    char value;
    boolean visited = false;
    Cell previous;

    public Cell(int x, int y, char value, int dist) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.dist = dist;
    }
    
    public boolean canMove() {
        return visited == false;
    }

//    @Override
//    public String toString() {
//        return "Cell{" + "x=" + x + ", y=" + y + ", value=" + value + '}';
//    }
    @Override
    public String toString() {
        return x + "-" + y + "-" + value;
    }
    
    
}

