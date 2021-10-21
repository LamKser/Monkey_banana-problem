/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuedemo;

import java.util.LinkedList;

/**
 *
 * @author Dinh Hoang Lam
 */
public class QueueLinkedList<E> {
    LinkedList<E> list = new LinkedList<>();
    public void clear() {
        while(!isEmpty()) {
            list.remove();
        }
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void enqueue(E el) {
        list.addFirst(el);
    }
    public E dequeue() {
        if(isEmpty()) {
            return null;
        }
        return list.removeLast();
    }
    public E front() {
        if(isEmpty()) {
            return null;
        }
        return list.getLast();
    }
    public void show() {
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("");
    }
}
