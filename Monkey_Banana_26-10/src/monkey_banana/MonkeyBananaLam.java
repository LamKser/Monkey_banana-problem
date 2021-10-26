/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monkey_banana;

import interfere.Utils;
import interfere.State;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Dinh Hoang Lam
 */
public class MonkeyBananaLam {

    private int a[][];
    private int row;
    private int col;

    private LinkedList<Integer> g[];

    public MonkeyBananaLam(int[][] a) {
        this.a = a;
        Utils.map = new HashMap<>();
        Utils.map.put(1, "Monkey");
        Utils.map.put(2, "Stick");
        Utils.map.put(3, "Chair");
        Utils.map.put(4, "Banana");
        this.row = a.length;
        this.col = a[0].length;
    }

    public int[][] getA() {
        return a;
    }

    public void setA(int[][] a) {
        this.a = a;
    }

    public void botPlay() {
        State state = new State();
        /*not have stick and chair and banana*/
        System.out.print("0. ");
        state.state();
        if (shortestDis(1, 2) < shortestDis(1, 3)) {
            System.out.print("1. ");
            fastWay(1, 2);
            state.setHasStick(true);
            state.state();
            state.takeStick();

            System.out.print("2. ");
            fastWay(2, 3);
            state.setToChair(true);
            state.state();
            state.pushChair();
            state.setPush(true);

            System.out.print("3. ");
            fastWay(3, 4);
            state.setClimb(true);
            state.state();
            state.climbChair();
            state.waveStick();
            state.setHasBanana(true);

            System.out.print("4. ");
            state.state();
        } else {
            System.out.print("1. ");
            fastWay(1, 3);
            state.setToChair(true);
            state.state();
            state.pushChair();
            state.setPush(true);

            System.out.print("2. ");
            fastWay(3, 2);
            state.setHasStick(true);
            state.state();
            state.takeStick();
            state.pushChair();

            System.out.print("3. ");
            fastWay(2, 4);
            state.setClimb(true);
            state.state();
            state.climbChair();
            state.waveStick();
            state.setHasBanana(true);

            System.out.print("4. ");
            state.state();
        }
    }

    public void player() {
        State state = new State();
        int[] pos = posObj(1);
        int x = pos[0];
        int y = pos[1];

        Scanner sc = new Scanner(System.in);
        System.out.println("Press a-Left_w-Up_s-Down_d-Right");
        System.out.print("0. "); state.state();
        do {
            System.out.print("Enter way: ");
            String way = sc.next();
            if (way.equals("a")) {
                if (checkValid(x, y - 1)) {
                    if (checkState(state, a[x][y - 1])) {
                    }
                    a[x][y] = 0;
                    y = y - 1;
                    a[x][y] = 1;
                } else {
                    System.out.println("Out of range");
                }
            } else if (way.equals("d")) {
                if (checkValid(x, y + 1)) {
                    if (checkState(state, a[x][y + 1])) {
                    }
                    a[x][y] = 0;
                    y = y + 1;
                    a[x][y] = 1;
                } else {
                    System.out.println("Out of range");
                }
            } else if (way.equals("w")) {
                if (checkValid(x - 1, y)) {
                    if (checkState(state, a[x - 1][y])) {
                    }
                    a[x][y] = 0;
                    x = x - 1;
                    a[x][y] = 1;
                } else {
                    System.out.println("Out of range");
                }
            } else if (way.equals("s")) {
                if (checkValid(x + 1, y)) {
                    if (checkState(state, a[x + 1][y])) {
                    }
                    a[x][y] = 0;
                    x = x + 1;
                    a[x][y] = 1;
                } else {
                    System.out.println("Out of range");
                }
            } else {
                System.out.println("Only a-Left\n     w-Up\n     s-Down\n     d-Right");
            }
            Utils.showMap(a);
        } while (state.isHasBanana() == false);
        System.out.print("-> "); state.state();
    }

    private int shortestDis(int start, int end) {
        boolean[][] visited = new boolean[row][col];
        Queue_lib<Cell> q = new Queue_lib();
        int dis = 0;
        int[] pos = posObj(start);

        q.enqueue(new Cell(pos[0], pos[1], 0));
        visited[pos[0]][pos[1]] = true;

        while (!q.isEmpty()) {
            Cell p = q.dequeue();

            if (a[p.x][p.y] == end) {
                dis = p.dist;
                break;
            }
            //up
            if (checkValid(p.x - 1, p.y, visited)) {
                q.enqueue(new Cell(p.x - 1, p.y, p.dist + 1));
                visited[p.x - 1][p.y] = true;

            }
            //down
            if (checkValid(p.x + 1, p.y, visited)) {
                q.enqueue(new Cell(p.x + 1, p.y, p.dist + 1));
                visited[p.x + 1][p.y] = true;
            }
            //left
            if (checkValid(p.x, p.y - 1, visited)) {
                q.enqueue(new Cell(p.x, p.y - 1, p.dist + 1));
                visited[p.x][p.y - 1] = true;
            }
            //right
            if (checkValid(p.x, p.y + 1, visited)) {
                q.enqueue(new Cell(p.x, p.y + 1, p.dist + 1));
                visited[p.x][p.y + 1] = true;
            }
        }
        return dis;
    }

    private boolean checkValid(int x, int y, boolean visited[][]) {
        if (x >= 0 && x < row && y >= 0 && y < col && visited[x][y] == false) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkValid(int x, int y) {
        if (x >= 0 && x < row && y >= 0 && y < col) {
            return true;
        } else {
            return false;
        }
    }

    private void BFS(int start, int end) {

        Queue_lib<Integer> qul = new Queue_lib<>();
        boolean[] visited = new boolean[row * col + 1];
        Arrays.fill(visited, true);
        qul.enqueue(start);
        visited[start] = false;
        int count = 0;
        int trace[] = new int[row * col + 1];
        trace[start] = 0;

        while (!qul.isEmpty()) {
            int key = qul.dequeue();
            for (int i = 0; i < g[key].size(); i++) {
                int v = g[key].get(i);
                if (visited[v]) {
                    qul.enqueue(v);
                    visited[v] = false;
                    trace[v] = key;
                }
                if (v == end) {
                    qul.clear();
                    break;
                }
            }
        }
        if (trace.length == 0) {
            System.out.println("Cannot find");
        } else {
            Stack path = new Stack();
            int destiny = end;
            while (destiny != 0) {
                path.push(destiny);
                destiny = trace[destiny];
                count++;
            }
            int prev = (int) path.pop();
            while (!path.isEmpty()) {
                int location = (int) path.pop();
                int check = location - prev;
                if (check == 1) {
                    System.out.print("Right ");
                }
                if (check == -1) {
                    System.out.print("Left ");
                }
                if (check == 7) {
                    System.out.print("Down ");
                }
                if (check == -7) {
                    System.out.print("Up ");
                }
                prev = location;
            }
        }
        System.out.println("(total = " + (--count) + ")");
    }

    private void fastWay(int source, int des) {
        row = a[0].length;
        col = a.length;
        int start = 0, end = 0;
        int count = 0;

        g = new LinkedList[row * col + 2];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                count++;
                g[count] = new LinkedList();
                if (i - 1 >= 0) {
                    g[count].add(count - row);
                }
                if (i + 1 < col) {
                    g[count].add(count + row);
                }
                if (j + 1 < row) {
                    g[count].add(count + 1);
                }
                if (j - 1 >= 0) {
                    g[count].add(count - 1);
                }
                if (a[i][j] == source) {
                    start = count;
                }
                if (a[i][j] == des) {
                    end = count;
                }
            }
        }
        System.out.print("From " + Utils.map.get(source) + " to " + Utils.map.get(des) + ": ");
        BFS(start, end);
    }

    private int[] posObj(int obj) {
        int[] pos = new int[2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a[i][j] == obj) {
                    pos[0] = i;
                    pos[1] = j;
                    break;
                }
            }
        }
        return pos;
    }

    private boolean checkState(State state, int obj) {
        if (obj == 2) {
            state.setHasStick(true);
            state.state();
            state.takeStick();
            return true;
        }
        if (obj == 3) {
            state.setToChair(true);
            state.state();
            state.pushChair();
            state.setPush(true);
            return true;
        }
        if (obj == 4) {
            if (state.isHasStick() && state.isToChair()) {
                state.setClimb(true);
                state.state();
                state.climbChair();
                state.waveStick();
                state.setHasBanana(true);
                return true;
            } else if (!state.isHasStick() && state.isToChair()) {
                state.setPush(true);
                state.state();
                state.climbChair();
                state.setHasBanana(true);
                return true;
            } else if (state.isHasStick() && !state.isToChair()) {
                state.setHasStick(true);
                state.waveStick();
                state.setHasBanana(true);
                return true;
            } else {
                state.state();
                state.setHasBanana(true);
                return false;
            }
        }
        return false;
    }
}

class Cell {

    int x, y;
    int dist;

    public Cell(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
