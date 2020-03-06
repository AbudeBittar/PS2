package ueb.list;

import ueb.list.functions.PredicateFunctionObject;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar.
 */
public abstract class MyList<E> {

    /**
     * Default-Konstruktor.
     */
    public MyList() {

    }
    /**
     * Kopier-Konstruktor, der eine neue Liste erzeugt, die der übergebenen
     * entspricht.
     * °°°Die neue Liste darf keine der Referenzen der übergebenen
     * Liste enthalten.
     *
     * @param list die übergebene Liste
     */
    public MyList(MyList<E> list) {

        for (int i = list.length() - 1; i >= 0; i--) {
            this.insertAtFront(list.getValueAt(i));
        }
    }

    /**
     * Konstuktor für eine neue Liste mit allen übergebenen Werten
     *
     * @param values die übergebenen Werte
     */
    public MyList(E... values) {
        for (int i = values.length - 1; i >= 0; i--) {
            this.insertAtFront(values[i]);
        }
    }

    /**
     * Berechnet die Länge der Liste.
     * @return die Länge der Liste.
     */
    public abstract int length();

    /**
     * Überprüft, ob die Liste leer ist.
     * @return True, wenn die Liste leer ist
     */
    public boolean isEmpty() {
        return length() == 0;
    }

    /**
     *  Fügt den gegebenen Wert am gegebenen Index ein.
     * @param index gegebener Index
     * @param value gegebener Wert
     */
    public abstract void insertAt(int index, E value);

    /**
     * Fügt einen neuen Wert an den Anfang der Liste.
     * @param value gegebener Wert
     */
    public void insertAtFront(E value) {
        insertAt(0, value);
    }
    
    /**
     * Fügt einen neuen Wert an das Ende der Liste
     * @param value gegebener Wert
     */
    public void append(E value) {
//        insertAtFront(value);
      insertAt(length(), value);
    }

    /**
     * Liefert den Wert am gegebenen Index
     * @param index gegebener Index
     * @return den Wert am gegebenen Index
     */
    public abstract E getValueAt(int index);

    /**
     * Entfernt den Wert am gegebenen Index.
     * @param index gegebener Index
     */
    public abstract void removeAt(int index);

    /**
     * Ersetzt den Wert am gegebenen Index durch den gegebenen neuen Wert. 
     * @param index gegebener Index
     * @param value gegebener Wert
     */
    public void replaceAt(int index, E value) {
        if (index < length() && index >= 0) {
            removeAt(index);
            insertAt(index, value);
        }
    }

    /**
     *  Prüft, ob das Objekt auch eine MyList ist, bei der alle
     *    entprechenden Wertepaare gleich sind.
     * @param list übergebene Liste
     * @return true, wenn das Objekt auch eine MyList ist.
     */
    public boolean equals(Object list) {
        if (list instanceof MyList) {
            boolean tester = true;
            MyList<E> castcopy = (MyList<E>) list;
            //TODO 2 DONE Längen müssen gleich sein
            if(this.length() != castcopy.length()) {
                tester = false;
            }
            for (int i = 0; i < length() && tester; i++) {
                tester = castcopy.getValueAt(i).equals(getValueAt(i));
            }
            return tester;
        } else {
            return false;
        }
    }
    
    /**
     * umgibt das Ergebnis des toString-Aufrufs aus head mit eckigen Klammern
     *
     * @return das Ergebnis mit eckigen Klammern [] als String
     */
    @Override
    public String toString() {
        String str = "";
        if (length() > 0)
            str = getValueAt(0).toString();
        for(int i = 1; i < length(); i++){
            str += ", " + String.format("%s", getValueAt(i));
        }
        return "[" + str + "]";
    }
    
    /**
     * erhält ein PredicateFunctionObject<E> und entfernt alle Elemente
     *    aus dieser Liste, die nicht dem Prädikat entsprechen 
     * @param predicate übergebener Prädikat
     */
    public void filterThis(PredicateFunctionObject<E> predicate) {
        //TODO DONE Test 1. und 2. Wert von 5 in Liste liefern false
        //TODO 2 DONE Test, bei dem jedes zweite Element herausgefiltert wird
        //TODO 2 DONE Test, bei dem alle enthaltenen Elemente herausgefiltert werden
//        for (int i = 0; i < length(); i++) {
        int i = 0;
        while (i < length()) {
            if (!predicate.call(getValueAt(i))) {
                removeAt(i);
                i--;
            }
            i++;
        }
    }

    /**
     *  erhält ein PredicateFunctionObject<E> und liefert die erste Nutzlast,
     *   die das Prädikat erfüllt.
     * @param predicate übergebener Prädikat
     * @return die erste Nutzlast, die das Prädikat erfüllt.
     */
    public E find(PredicateFunctionObject<E> predicate) {
        //TODO DONE kein return aus Schleife
        //FIXME DONE und Schleife sollte terminieren, sobald das Ergebnis klar ist
        //TODO 2 DONE Test, bei dem das zweite Element von 8 gefunden wird
        //TODO 2 DONE Test, bei dem das erste Element von 8 gefunden wird
        E result = null;
        for (int i = 0; i < length() && result == null; i++) {
            if (predicate.call(getValueAt(i))) {
                result = getValueAt(i);
            }
        }
        return result;
    }

    /**
     *  erhält ein PredicateFunctionObject<E> und liefert true, wenn mindestens
     *   ein Wert der Liste das Prädikat erfüllt.
     * @param predicate übergebener Prädikat
     * @return true, wenn mindestens ein Wert der Liste das Prädikat erfüllt.
     */
    public boolean exists(PredicateFunctionObject<E> predicate) {
        return find(predicate) != null;
    }

    /**
     *  erhält ein PredicateFunctionObject<E> und liefert true, wenn es keinen
     *     Wert in der Liste gibt, der das Prädikat nicht erfüllt.
     * @param predicate übergebener Prädikat
     * @return true, wenn es keinen Wert in der Liste gibt, der das
     *            Prädikat nicht erfüllt.
     */
    public boolean forAll(PredicateFunctionObject<E> predicate) {
        //TODO DONE kein return aus Schleife
        //FIXME DONE und Schleife sollte terminieren, sobald das Ergebnis klar ist
        boolean result = true;
        for (int i = 0; i < length() && result; i++) {
            if (!predicate.call(getValueAt(i))) {
                result = false;
            }
        }
        return result;
    }

}
