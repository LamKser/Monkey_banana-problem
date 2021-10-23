/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monkey_banana;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Dinh Hoang Lam
 */
public class MonkeyBananaSolution {

    private int row;
    private int col;

    private int a[][];
    private LinkedList<Integer> g[];
    private Map<Integer, String> map;
    
    public MonkeyBananaSolution(int[][] a) {
        this.a = a;     
        map = new HashMap<>();
        map.put(1, "Monkey");
        map.put(2, "Stick");
        map.put(3, "Chair");
        map.put(4, "Banana");
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
        System.out.println("(total = " + (--count) +")");
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
        System.out.print("From " + map.get(source) + " to " + map.get(des) + ": ");
        BFS(start, end);
    }

    public void botPlay() {
        fastWay(1, 2);
        fastWay(2, 3);
        fastWay(3, 4);
    }
}
