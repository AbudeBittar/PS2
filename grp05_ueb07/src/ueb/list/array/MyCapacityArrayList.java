package ueb.list.array;

import ueb.list.MyList;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar.
 * 
 */

public class MyCapacityArrayList<E> extends MyList<E> {

    //TODO DONE muss noch komplett getestet werden
    private Object[] listArray;

    /**
     * Größe dieser Liste
     */
    private int size = 0;

    /**
     * Kapazität dieser Liste
     */
    private int capacity;

    /**
     * Wachstumsfactor dieser Liste
     */
    private float growFactor;

    /**
     * Eine Konstante, die die initiale Kapazität einer leeren Liste bestimmt.
     */
    private static final int DEFAULT_CAPACITY = 15;
    /**
     * Eine Konstante, die festlegt, um wie viel Prozent die Kapazität erhöht
     * wird, sobald zusätzlicher Platz benötigt wird.
     */
    private static final float DEFAULT_GROW_FACOR = (float) 0.5;

    /**
     * Default-Konstruktor,der obige Konstanten zum Festlegen von Kapazität und
     * Wachstumsfaktor nutzt.
     */
    public MyCapacityArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.growFactor = DEFAULT_GROW_FACOR;
        this.listArray = new Object[capacity];
    }

    /**
     * Konstruktor, der nur eine Angabe für die initiale Kapazität
     * entgegennimmt.
     *
     * @param initCap die initiale Kapazität
     */
    public MyCapacityArrayList(int initCap) {
        this.capacity = initCap;
        this.growFactor = DEFAULT_GROW_FACOR;
        this.listArray = new Object[capacity];
    }

    /**
     * Konstruktor, der eine Angabe für die initiale Kapazität und einen
     * Wachstumsfaktor erhält.
     *
     * @param initCap die initiale Kapazität
     * @param growth der übergebene Wachstumsfactor
     */
    public MyCapacityArrayList(int initCap, float growth) {
        this.capacity = initCap;
        this.growFactor = growth;
        this.listArray = new Object[capacity];
    }

    /**
     * liefert die Größe dieser Liste
     *
     * @return die Größe dieser Liste
     */
    public int getSize() {
        return this.size;
    }

    /**
     * liefert die Kapazität dieser Liste
     *
     * @return die Kapazität dieser Liste
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * liefert den Wachstumsfaktor dieser Liste
     *
     * @return den Wachstumsfaktor dieser Liste
     */
    public float getGrowFactor() {
        return this.growFactor;
    }

    /**
     * liefert die Kapazität,die bei einer Erweiterung des Arrays entstehen
     * würde
     *
     * @return die Kapazität,die bei einer Erweiterung des Arrays entstehen
     * würde
     */
    protected int getAllocationSize() {
        return (int) (getCapacity() + (getCapacity() * getGrowFactor()) + 1);
    }

    /**
     * Berechnet die Länge der Liste.
     *
     * @return die Länge der Liste.
     */
    @Override
    public int length() {
        //TODO DONE Länge, nicht Kapazität
        return getSize();
    }

    /**
     * Fügt den gegebenen Wert am gegebenen Index ein.
     *
     * @param index gegebener Index
     * @param value gegebener Wert
     */
    @Override
    public void insertAt(int index, E value) {
        //TODO 2 DONE Test: in eine Liste mit einem Element an 0 einfügen
        //TODO 2 DONE Test: in eine leere Liste an 0 einfügen
        if (index >= 0 && index <= getSize()) {
            if (listArray.length == getSize()) {
                Object[] listCopy = new Object[getAllocationSize()];
                System.arraycopy(listArray, 0, listCopy, 0, index);
                System.arraycopy(listArray, index, listCopy, index + 1, listArray.length - index);
                listCopy[index] = value;
                listArray = listCopy;
                capacity = getAllocationSize();
            } else {
                for (int i = getSize(); i > index; i--) {
                    //Er beginnt beim letzten Element (index: getSize() - 1) und
                    //verschiebt dies um 1 index nach hinten wird der übergebene
                    //index erreicht wird abgebrochen und das Element kann eingefügt werden
                    listArray[i] = listArray[i - 1];
                }
                listArray[index] = value;
            }
            //TODO 2 DONE da bei invalidem Index nicht eingefügt werden soll, darf auch nicht in jedem Fall die size erhöht werden
            size++;
        }
    }

//   /**
//     * Fügt einen neuen Wert an das Ende der Liste
//     * @param value gegebener Wert
//     */
//    @Override
//    public void append(E value) {
////        insertAtFront(value);
//        insertAt(getSize(), value);
//    }

    /**
     * verkleinert das Array derart, dass getCapacity() == getSize() zutrifft.
     */
    public void shrinkToFit() {
        if (getCapacity() != getSize()) {
            Object[] bla = new Object[getSize()];
            System.arraycopy(listArray, 0, bla, 0, getSize());
            listArray = bla;
            capacity = getSize();
            //TODO 2 DONE capacity ändert sich nicht?
        }
    }

    /**
     * Liefert den Wert am gegebenen Index
     *
     * @param index gegebener Index
     * @return den Wert am gegebenen Index
     */
    @Override
    public E getValueAt(int index) {
        if (index >= 0 && index < getSize()) {
            return (E) listArray[index];
        } else {
            return null;
        }
    }

    /**
     * Entfernt den Wert am gegebenen Index.
     *
     * @param index gegebener Index
     */
    @Override
    public void removeAt(int index) {
        if (index >= 0 && index < getSize()) {
            Object[] bla = new Object[listArray.length];
            System.arraycopy(listArray, 0, bla, 0, index);
            System.arraycopy(listArray, index + 1, bla, index, length() - index - 1);
            listArray = bla;
            size--;
            //TODO 2 DONE size ändert sich nicht?
        }
    }

}
