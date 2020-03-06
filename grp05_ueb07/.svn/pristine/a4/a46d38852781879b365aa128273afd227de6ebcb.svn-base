//Auch diese Klasse muss angeben, dass sie mit dem Parameter E 
//arbeitet, um den Typ der Nutzlast festzulegen.
//Bei dieser Variante muss nicht mehr auf isEmpty()geprüft werden, da es keine
//null-Referenz mehr in der Liste gibt. Jede Sonderbehundlung der leeren Liste
//ist ja jetzt in der Klasse MyElement untergebracht.
package ueb.list.linked;

import ueb.list.MyList;
import ueb.list.functions.PredicateFunctionObject;

/**
 * @author Jan R. Neumann & Abdulrahman Al Bittar.
 */
/**
 * bietet immernoch die Kapselung für die Klassen der verketteten Liste, hält
 * also den Kopf der verketteten Liste und bietet die selben Routinen an wie
 * "MyElement".
 *
 * @param <E> Typparameter wie in "Element"
 */
public class MyLinkedList<E> extends MyList<E> {

    /**
     * Kopf der verketteten Liste
     */
    private MyElement<E> head;

    /**
     * Default-Konstruktor für eine leere Liste
     */
    public MyLinkedList() {
        this.head = new MyEmptyElement<>();
    }

    /**
     * Kopier-Konstruktor, der eine neue Liste erzeugt, die der übergebenen
     * entspricht. °°°Die neue Liste darf keine der Referenzen der übergebenen
     * Liste enthalten.
     *
     * @param list die übergebene Liste
     */
    public MyLinkedList(MyLinkedList<E> list) {
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
    public MyLinkedList(E... values) {
        this.head = new MyEmptyElement<>();
        for (int i = values.length - 1; 0 <= i; i--) {
            this.head = new MyFilledElement<>(values[i], this.head);
        }
    }

    /**
     * umgibt das Ergebnis des toString-Aufrufs aus head mit eckigen Klammern
     *
     * @return das Ergebnis mit eckigen Klammern [] als String
     */
    @Override
    public String toString() {
        return String.format("[%s]", head.toString());
    }

    /**
     * Überprüft, ob die übergebene Liste mit dieser Liste übereinstimmt und
     * daher beide gleich sind.
     *
     * @param list die übergebene Liste
     * @return true, wenn alle payloads der im head enthaltenen Liste
     * übereinstimmen. Andernfalls false.
     */
    @Override
    public boolean equals(Object list) {
        if (list instanceof MyLinkedList) {
            return this.head.equals(((MyLinkedList) list).head);
        } else {
            return false;
        }
    }

    /**
     * liefert die Anzahl der Elemente in der Liste
     *
     * @return die Anzahl der Elemente in der Liste
     */
    @Override
    public int length() {
        return this.head.length();
    }

    /**
     * Überprüft, ob die Liste keine Elemente mit Nutzlast enthält.
     *
     * @return True, wenn die Liste keine Elemente mit Nutzlast enthält
     */
    @Override
    public boolean isEmpty() {
        return this.head.isEmpty();
    }

    /**
     * Fügt den übergebenen wert in ein neues Element am Ende der Liste ein.
     *
     * @param value der einzufügende wert
     */
    @Override
    public void append(E value) {
        this.head = this.head.append(value);
    }

    /**
     * Fügt den übergebenen Wert in ein neues Element am Anfang der Liste ein.
     *
     * @param value der einzufügende wert
     */
    @Override
    public void insertAtFront(E value) {
        this.head = this.head.insertAtFront(value);
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
     * Fügt den übergebenen Wert in ein neues Element am gegebenen Index ein.
     * @param index der gegebene Index
     * @param value der einzufügende wert
     */
    @Override
    public void insertAt(int index, E value) {
        this.head = this.head.insertAt(index, value);
    }

    /**
     * Entfernt das Element am gegebenen Index.
     * @param index der gegebene Index.
     */
    @Override
    public void removeAt(int index) {
        this.head = this.head.removeAt(index);
    }
    //TODO DONE replaceAt(), auch in Element-Klassen
    
    @Override
    public void replaceAt(int index, E value){
        this.head = this.head.replaceAt(index, value);
    }

    /**
     * entfernt alle Elemente aus der aktuellen Liste, die nicht zum Prädikat
     * passen.
     * 
     * @param predicate das übergebene Funktionsobjekt(Prädikat).
     */
    @Override
    public void filterThis(PredicateFunctionObject<E> predicate) {
        this.head = this.head.filterThis(predicate);
    }

    /**
     * liefert eine neue Liste mit allen Elementen, die zum Prädikat passen
     * @param predicate das übergebene Funktionsobjekt(Prädikat).
     * @return eine neue Liste mit allen Elementen, die zum Prädikat passen.
     */
    public MyLinkedList<E> filter(PredicateFunctionObject<E> predicate) {
        MyLinkedList<E> filteredList = new MyLinkedList<>(this);
        filteredList.filterThis(predicate);
        return filteredList;
    }

     /**
     * liefert die erste Nutzlast, die zum Prädikat passt.
     * @param predicate das übergebene Funktionsobjekt(Prädikat).
     * @return die erste Nutzlast, die zum Prädikat passt. null, wenn keine
     *         passende Nutzlast vorhanden ist.
     */
    @Override
    public E find(PredicateFunctionObject<E> predicate) {
        return this.head.find(predicate);
    }

    /**
     * überprüft, ob die Prädikatfunktion für mindestens eines der
     * Listenelemente passt.
     * @param predicate das übergebene Funktionsobjekt(Prädikat).
     * @return true, wenn die Prädikatfunktion für mindestens eines der 
     *         Listenelemente passt. Ansonsten False.
     */
    @Override
    public boolean exists(PredicateFunctionObject<E> predicate) {
        
        return (this.head.find(predicate) != null);
//        return this.head.exists(predicate);
    }

      /**
     * überprüft, ob alle Werte in der Liste das Prädikat erfüllen.
     * @param predicate das übergebene Funktionsobjekt(Prädikat).
     * @return  true, wenn kein Wert in der Liste existiert, der das Prädikat 
     * nicht erfüllt. Ansonnsten False.
     */
    @Override
    public boolean forAll(PredicateFunctionObject<E> predicate) {
        return this.head.forAll(predicate);
    }
}
