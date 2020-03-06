package ueb.list.linked;

import ueb.list.functions.PredicateFunctionObject;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar.
 */
public interface MyElement<E> {
       /**
     * Getter-Methode für die Nutzlast.
     * @return AssertionError, da wir keine Attribute in dieser haben.
     */
    public E getPayload() ;
    
    /**
     * Getter-Methode für das nächste Element.
     * @return AssertionError, da wir keine Attribute in dieser Klasse haben.
     */
    public MyElement<E> getNext() ;

    /**
     * Gibt die Liste als String zurück.
     * @return Ein leeres String.
     */
    
    @Override
    public String toString();
    /**
     * Überprüft, ob das übergebene Element mit diesem übereinstimmt und 
     * beide gleich sind.
     * @param list das übergebene Element.
     * @return true, wenn die übergebene Liste vom Datentyp welcher mit dieser
     *         Klasse übereinstimmt. Andernfalls false. 
     */
    @Override
    public boolean equals(Object list);

    /**
     * Liefert die Anzahl der Elemente in der Liste
     * @return 0, da dieses Element leer ist.
     */
    public int length() ;

    /**
     * Überprüft, ob dies Element eine Nutzlast enthält.
     * @return true, da diese Klasse keine Nutzlast hat.
     */
    public boolean isEmpty();

    /**
     * Fügt den übergebenen wert am Ende der Liste ein.
     * @param value das übergebene Element
     * @return eine neue Liste mit dem übergebenen wert am Ende eingefügt.
     */
    public MyElement<E> append(E value);

    /**
     * Fügt den übergebenen wert am Anfanf der Liste ein.
     * @param value das übergebene Element.
     * @return eine neues Element am Anfang mit dem übergebenen Element.
     */
    public MyElement<E> insertAtFront(E value);

    /**
     *  Liefert die Nutzlast am gegebenen Index.
     * @param index der gegebene Index
     * @return null, da diese Klasse keine Nutzlast hat.
     */
    public E getValueAt(int index);
    /**
     * Fügt den übergebenen wert am gegebenen Index ein.
     * @param index der gegebene Index.
     * @return dieses Element.
     */
    public MyElement<E> insertAt(int index, E value);

    public MyElement<E> replaceAt (int index, E value);
    
    
    /**
     * entfern das Element am gegebenen Index.
     * @param index der gegebene Index.
     * @return dieses Element.
     */
    public MyElement<E> removeAt(int index) ;

   /**
    * erhält ein PredicateFunctionObject und entfernt alle Elemente aus der
    * aktuellen Liste, die nicht zum Prädikat passen.
    * @param predicate das übergebene Funktionsobjekt(Prädikat).
    * @return Diese (leeere) Liste.
    */
    public MyElement<E> filterThis(PredicateFunctionObject<E> predicate);
    
   /**
    * liefert die erste Nutzlast, die zum Prädikat passt.
    * @param predicate das übergebene Funktionsobjekt(Prädikat).
    * @return null.
    */
    public E find(PredicateFunctionObject<E> predicate) ;
    
//    public boolean exists(PredicateFunctionObject<E> predicate) {
//        return false;
//    }
    
    /**
     * überprüft, ob kein Wert in der Liste existiert, der das Prädikat nicht erfüllt.
     * @param predicate das übergebene Funktionsobjekt(Prädikat).
     * @return true immer.
     */
    public boolean forAll(PredicateFunctionObject<E> predicate);
}
