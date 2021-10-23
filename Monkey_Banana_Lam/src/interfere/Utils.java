/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfere;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class Utils {

    public static int a[][] = {{0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0}};
    static int row = a[0].length;
    static int col = a.length;
    static ArrayList<Integer> listNum;

    /*a[][] = {{0, 1, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 4, 0},
                                {2, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 3, 0}};*/
    public static Map<Integer, String> map;

    public static void showMap(int m[][]) {
        for (int i = 0; i < m[0].length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (a[i][j] == 0) {
                    System.out.print(m[i][j] + "\t");
                } else {
                    System.out.print(Utils.map.get(m[i][j]) + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void createMap() {
        int size = row * col - 1;
        listNum = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            listNum.add(i);
        }

        int count = 0;
        while (count < 4) {
            count++;
            int loca = numRandlistNum();
            int incre = 0;
            for (int i = 0; i < row; i++) {
                int k = 0;
                for (int j = 0; j < col; j++) {
                    if (loca == incre) {
                        a[i][j] = count;
                        k = j;
                    }
                    incre++;
                }
                if (loca < incre && a[i][k] != 0) {
                    break;
                }
            }
        }
    }

    private static int numRandlistNum() {
        Random Rand = new Random();
        int result = 0;
        do {
            result = Rand.nextInt(row * col - 1);
            for (int i = 0; i < listNum.size(); i++) {
                if(listNum.get(i) == result){
                    listNum.remove(i);
                    return result;
                }
            }
            if(listNum.size() == 0)break;
        } while (true);
        return result;
    }

}
