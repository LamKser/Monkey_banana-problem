/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass2;

import java.util.ArrayList;
import queuedemo.QueueLinkedList;

/**
 *
 * @author Dinh Hoang Lam
 */
public class Maze {

    char sourceVal, destinationVal;
    int row, col;
    Cell[][] matrix;
    Cell S = null, D = null;
    boolean completed = false;
    boolean succeeded = false;

    public Maze(char sourceVal, char destinationVal, char[][] input) {
        this.sourceVal = sourceVal;
        this.destinationVal = destinationVal;
        this.row = input.length;
        this.col = input[0].length;
        this.matrix = new Cell[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = new Cell(i, j, input[i][j], 0);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j].value == sourceVal) {
                    this.S = matrix[i][j];
                    break;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j].value == destinationVal) {
                    this.D = matrix[i][j];
                    break;
                }
            }
        }
    }

    public boolean isValid(int x, int y) {
        return (x >= 0 && x < row && y >= 0 && y < col);
    }

    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void findSource() {

        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        QueueLinkedList<Cell> q = new QueueLinkedList();
        ArrayList path = new ArrayList();

        q.enqueue(new Cell(S.x, S.y, matrix[S.x][S.y].value, 0));
        visited[S.x][S.y] = true;

        while (!q.isEmpty()) {
            Cell p = q.dequeue();
            path.add(p);

            if (matrix[p.x][p.y].equals(D)) {
                System.out.println("Distance=" + p.dist);
                break;
            }

            //up
            if (checkValid(p.x - 1, p.y, visited)) {
                q.enqueue(new Cell(p.x - 1, p.y, matrix[p.x - 1][p.y].value, p.dist + 1));
                visited[p.x - 1][p.y] = true;

            }
            //down
            if (checkValid(p.x + 1, p.y, visited)) {
                q.enqueue(new Cell(p.x + 1, p.y, matrix[p.x + 1][p.y].value, p.dist + 1));
                visited[p.x + 1][p.y] = true;
            }
            //left
            if (checkValid(p.x, p.y - 1, visited)) {
                q.enqueue(new Cell(p.x, p.y - 1, matrix[p.x][p.y - 1].value, p.dist + 1));
                visited[p.x][p.y - 1] = true;
            }
            //right
            if (checkValid(p.x, p.y + 1, visited)) {
                q.enqueue(new Cell(p.x, p.y + 1, matrix[p.x][p.y + 1].value, p.dist + 1));
                visited[p.x][p.y + 1] = true;
            }
        }
        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i).toString() + " ");
        }
    }

    public boolean checkValid(int x, int y, boolean visited[][]) {
        if (x >= 0 && x < row
                && y >= 0 && y < col
                && visited[x][y] == false) {
            return true;
        } else {
            return false;
        }
    }

}
