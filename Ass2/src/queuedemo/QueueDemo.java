/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuedemo;

/**
 *
 * @author Dinh Hoang Lam
 */
public class QueueDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QueueLinkedList<Integer> q = new QueueLinkedList<>();
        q.enqueue(3);
        q.enqueue(5);
        q.enqueue(7);
        q.enqueue(2);
        q.enqueue(8);
        q.show();
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Front: " + q.front());
    }

}
