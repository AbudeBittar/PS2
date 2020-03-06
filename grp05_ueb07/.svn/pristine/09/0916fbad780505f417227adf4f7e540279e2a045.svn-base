package ueb.list.linked;

import ueb.list.functions.PredicateFunctionObject;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar.
 */
/**
 * //repräsentiert das Listenende ohne Nutzlast.
 *
 * @param <E> Typparameter wie in "Element"
 */
class MyEmptyElement<E> implements MyElement<E> {

    /**
     * Getter-Methode für die Nutzlast.
     *
     * @return AssertionError, da wir keine Attribute in dieser haben.
     */
    @Override
    public E getPayload() {
        throw new AssertionError();
    }

    /**
     * Getter-Methode für das nächste Element.
     *
     * @return AssertionError, da wir keine Attribute in dieser Klasse haben.
     */
    @Override
    public MyEmptyElement<E> getNext() {
        throw new AssertionError();
    }

    /**
     * Gibt die Liste als String zurück.
     *
     * @return Ein leeres String.
     */
    @Override
    public String toString() {
        return "";
    }

    /**
     * Überprüft, ob das übergebene Element mit diesem übereinstimmt und beide
     * gleich sind.
     *
     * @param list das übergebene Element.
     * @return true, wenn die übergebene Liste vom Datentyp welcher mit dieser
     * Klasse übereinstimmt. Andernfalls false.
     */
    @Override
    public boolean equals(Object list) {
        if (list != null) {
            return this.getClass() == list.getClass();
        } else {
            return false;
        }
    }

    /**
     * Liefert die Anzahl der Elemente in der Liste
     *
     * @return 0, da dieses Element leer ist.
     */
    @Override
    public int length() {
        return 0;
    }

    /**
     * Überprüft, ob dies Element eine Nutzlast enthält.
     *
     * @return true, da diese Klasse keine Nutzlast hat.
     */
    @Override
    public boolean isEmpty() {
        return true;
    }

    /**
     * Fügt den übergebenen wert am Ende der Liste ein.
     *
     * @param value das übergebene Element
     * @return eine neue Liste mit dem übergebenen wert am Ende eingefügt.
     */
    @Override
    public MyFilledElement<E> append(E value) {
        MyFilledElement<E> elem = new MyFilledElement<>(value, this);
        return elem;
    }

    /**
     * Fügt den übergebenen wert am Anfanf der Liste ein.
     *
     * @param value das übergebene Element.
     * @return eine neues Element am Anfang mit dem übergebenen Element.
     */
    @Override
    public MyFilledElement<E> insertAtFront(E value) {
        return new MyFilledElement<>(value, this);

    }

    /**
     * Liefert die Nutzlast am gegebenen Index.
     *
     * @param index der gegebene Index
     * @return null, da diese Klasse keine Nutzlast hat.
     */
    @Override
    public E getValueAt(int index) {
        return null;
    }

    /**
     * Fügt den übergebenen wert am gegebenen Index ein.
     *
     * @param index der gegebene Index.
     * @return dieses Element.
     */
    @Override
    public MyElement<E> insertAt(int index, E value) {
        if (index == 0) {
            return new MyFilledElement<>(value, this);
        } else {
            return this;
        }
    }

    /**
     * entfern das Element am gegebenen Index.
     *
     * @param index der gegebene Index.
     * @return dieses Element.
     */
    @Override
    public MyEmptyElement<E> removeAt(int index) {
        return this;
    }

    @Override
    public MyEmptyElement<E> replaceAt(int index, E value) {
        return this;
    }

    /**
     * erhält ein PredicateFunctionObject und entfernt alle Elemente aus der
     * aktuellen Liste, die nicht zum Prädikat passen.
     *
     * @param predicate das übergebene Funktionsobjekt(Prädikat).
     * @return Diese (leeere) Liste.
     */
    @Override
    public MyEmptyElement<E> filterThis(PredicateFunctionObject<E> predicate) {
        return this;
    }

    /**
     * liefert die erste Nutzlast, die zum Prädikat passt.
     *
     * @param predicate das übergebene Funktionsobjekt(Prädikat).
     * @return null.
     */
    @Override
    public E find(PredicateFunctionObject<E> predicate) {
        return null;
    }

//     /**
//     * überprüft, ob die Prädikatfunktion für mindestens eines der
//     * Listenelemente passt.
//     * @param predicate das übergebene Funktionsobjekt(Prädikat).
//     * @return true, wenn die Prädikatfunktion für mindestens eines der 
//     *         Listenelemente passt. Ansonsten False.
//     */
//     public boolean exists(PredicateFunctionObject<E> predicate) {
//        return false;
//    }
    
    /**
     * überprüft, ob kein Wert in der Liste existiert, der das Prädikat nicht
     * erfüllt.
     *
     * @param predicate das übergebene Funktionsobjekt(Prädikat).
     * @return true immer.
     */
    @Override
    public boolean forAll(PredicateFunctionObject<E> predicate) {
        return true;
    }
}
