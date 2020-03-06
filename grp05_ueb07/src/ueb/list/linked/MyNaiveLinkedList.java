/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ueb.list.linked;

import ueb.list.MyList;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar
 */
public class MyNaiveLinkedList<E> extends MyList<E> {
    
    private MyElement<E> head;
    
    public MyNaiveLinkedList() {
        this.head = new MyEmptyElement<>();
    }

    /**
     * Kopier-Konstruktor, der eine neue Liste erzeugt, die der übergebenen
     * entspricht.
     * °°° Die neue Liste darf keine der Referenzen der übergebenen
     *        Liste enthalten.
     *
     * @param list die übergebene Liste
     */
    public MyNaiveLinkedList(MyList<E> list) {
        //TODO DONE this()
        // Erzeugen des letzten Element
        this.head = new MyEmptyElement<>();
        //Erzeugen der restlichen Elemente
        for (int i = list.length() - 1; 0 <= i; i--) {
            this.head = new MyFilledElement<>( list.getValueAt(i), this.head);
        }
    }

    /**
     * Konstuktor für eine neue Liste mit allen übergebenen Werten
     *
     * @param values die übergebenen Werte
     */
    public MyNaiveLinkedList(E... values) {
        //TODO DONE this()
        this.head = new MyEmptyElement<>();
        for (int i = values.length - 1; 0 <= i; i--) {
            this.head = new MyFilledElement<>(values[i], this.head);
        }
    }

    /**
     * liefert die Anzahl der Elemente in der Liste
     * @return die Anzahl der Elemente in der Liste
     */
    @Override
    public int length() {
        return head.length();
    }

    /**
     * Fügt den übergebenen Wert in ein neues Element am gegebenen Index ein
     * @param index der gegebene Index
     * @param value der einzufügende wert
     */
    @Override
    public void insertAt(int index, E value) {
        this.head = head.insertAt(index, value);
    }

      /**
     * Liefert die Nutzlast am gegebenen Index.
     *
     * @param index der gegebene Index
     * @return die Nutzlast am gegebenen Index, null bei invalidem Index.
     */
    @Override
    public E getValueAt(int index) {
        return head.getValueAt(index);
    }

    /**
     * Entfernt das Element am gegebenen Index.
     * @param index der gegebene Index.
     */
    @Override
    public void removeAt(int index) {
        this.head = head.removeAt(index);
    }
    
}
