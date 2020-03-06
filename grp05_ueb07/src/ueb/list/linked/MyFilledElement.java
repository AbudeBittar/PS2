package ueb.list.linked;

import ueb.list.functions.PredicateFunctionObject;

/**
 * Beschreibt ein Element der Liste mit einer Nutzlast.
 * 
 * @author Jan R. Neumann & Abdulrahman Al Bittar.
 */
class MyFilledElement<E> implements MyElement<E> {

    /**
     * Nutzlast des Elements
     */
    private final E Payload;
    
    /**
     * Referenz auf das nächste Element
     */
    private MyElement<E> next;

    /**
     * Konstruktor ausschließlich mit der Nutzlast, nur sinnvoll für das 
     * konstruieren des letzten oder einzigen Elements einer Liste.
     * @param payload die Nutzlast.
     */
    MyFilledElement(E payload) {
        this.Payload = payload;
        this.next = new MyEmptyElement<>();
    }

    /**
     * Konstruktor mit Nutzlast und Verkettung.
     *
     * @param payload die Nutzlast.
     * @param next nächstes Element.
     */
    MyFilledElement(E payload, MyElement<E> next) {
        this.Payload = payload;
        this.next = next;
    }

    /**
     * Getter-Methode für die Nutzlast. °°° Mit Override-Annotation, da von der
     * Klasse MyElement vererbt wurde.
     *
     * @return Nutzlast dieser Klasse.
     */
    @Override
    public E getPayload() {
        return this.Payload;
    }

    /**
     * überschriebene Getter-Methode für das nächste Element.
     *
     * @return Nächstes Element.
     */
    @Override
    public MyElement<E> getNext() {
        return this.next;
    }

    /**
     * Gibt die Nutzlast jedes Elements als String zurück, trennt mehrere
     * Elemente mit ", ". das wird als Ergebnis in der MyLinkedList-Klasse
     * weiterBearbeitet.
     *
     * @return die Nutzlast jedes Elements als String
     */
    @Override
    public String toString() {
        // rekursiv arbeiten, bis alle Elemente als string und getrent sind.
        //  dann Rekursion aufhören.
        if (getNext().isEmpty()) {
            return String.format("%s", getPayload());
        } else {
            return String.format("%s, ", getPayload()) + getNext().toString();
        }

    }

    /**
     * Überprüft, ob einübergebenes Element mit diesem übereinstimmt und
     * beide gleich sind.
     *
     * @param elem das übergebene Element
     * @return true, wenn die übergebene Liste und all Ihrer Nutzlast vom
     * Datentyp ist, welcher mit dieser Klasse übereinstimmt. Andernfalls false.
     */
    @Override
    public boolean equals(Object elem) {
        // Prüfen, ob das übergebene Element vom Datentyp ist, welcher mit dieser
        //  Klasse übereinstimmt.
        if (!(elem instanceof MyFilledElement)) {
            return false;
        } else {
            //Überprüfen jeder Nutzlast
            if (this.getPayload() != ((MyFilledElement) elem).getPayload()) {
                return false;
            } else {
                return this.getNext().equals(((MyFilledElement) elem).getNext());
            }
        }
    }

    /**
     * Liefert die Anzahl der nachfolgenden Elemente in der Liste
     *
     * @return die Anzahl der nachfolgenden Elemente in der Liste
     */
    @Override
    public int length() {
        return 1 + this.getNext().length();
    }

    /**
     * Überprüft, ob dieses Element keine Nutzlast enthält.
     *
     * @return False, da diese Klasse ein payload hat.
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Fügt den übergebenen wert am Ende der Liste ein.
     *
     * @param value den übergebene wert
     * @return eine neue Liste mit dem übergebenen Element am Ende eingefügt.
     */
    @Override
    public MyFilledElement<E> append(E value) {
        this.next = this.getNext().append(value);
        return this;
    }

    /**
     * Fügt den übergebenen wert am Anfanf der Liste ein.
     *
     * @param value den übergebenen wert.
     * @return eine neue Liste mit dem übergebenen Element am Anfang eingefügt.
     */
    @Override
    public MyFilledElement<E> insertAtFront(E value) {
        return new MyFilledElement<>(value, this);
    }

    /**
     * Liefert die Nutzlast am gegebenen Index.
     *
     * @param index der gegebene Index
     * @return die Nutzlast am gegebenen Index, null bei invalidem Index.
     */
    @Override
    public E getValueAt(int index) {
        if (index <= this.length()) {
            if (index == 0) {
                return getPayload();
            } else {
                return (E) this.getNext().getValueAt(index - 1);
            }
        } else {
            return null;
        }
    }

    /**
     * Fügt den übergebenen wert am gegebenen Index ein.
     *
     * @param index der gegebene Index
     * @param value den übergebenen wert
     * @return eine neue Liste mit dem übergebenen Element am gegebenen Index
     * eingefügt.
     */
    @Override
    public MyElement<E> insertAt(int index, E value) {
        if (index == 0) {
            return insertAtFront(value);
        } else {
            this.next = this.getNext().insertAt(index - 1, value);
            return this;
        }
    }

    /**
     * Entfernt das Element am gegebenen Index.
     *
     * @param index der gegebene Index
     * @return eine neue Liste ohne das übergebenen Element am gegebenen Index
     */
    @Override
    public MyElement<E> removeAt(int index) {
        switch (index) {
            case 0:
                return this.getNext();
            case 1:
                this.next = getNext().removeAt(0);
                return this;
            default:
                getNext().removeAt(index - 1);
                return this;
        }
    }

    @Override
    public MyElement<E> replaceAt (int index, E value) {
        switch (index) {
            case 1:
                this.next = getNext().replaceAt(index - 1, value);
                return this;
            case 0:
                MyFilledElement<E> inserter = new MyFilledElement<>(value, this.next);
                return inserter;
            default:
                this.next = getNext().replaceAt(index - 1, value);
                return this;
        }
    }
    
    /**
     * erhält ein PredicateFunctionObject und entfernt alle Elemente aus der
     * aktuellen Liste, die nicht zum Prädikat passen.
     *
     * @param predicate das übergebene Funktionsobjekt(Prädikat).
     * @return eine neue Liste, die keine Elemente enthält, die nicht zu dem
     * übergebenen Prädikat passen.
     */
    @Override
    public MyElement<E> filterThis(PredicateFunctionObject<E> predicate) {
        if (predicate.call(Payload)) {
            this.next = getNext().filterThis(predicate);
            return this;
        } else {
            this.next = getNext().filterThis(predicate);
            return getNext();
        }
    }

    /**
     * liefert die erste Nutzlast, die zum Prädikat passt.
     *
     * @param predicate das übergebene Funktionsobjekt(Prädikat).
     * @return die erste Nutzlast, die zum Prädikat passt. null, wenn keine
     * passende Nutzlast vorhanden ist.
     */
    @Override
    public E find(PredicateFunctionObject<E> predicate) {
        if (predicate.call(Payload)) {
            return getPayload();
        } else {
            return (E) getNext().find(predicate);
        }
    }

//    /**
//     * überprüft, ob die Prädikatfunktion für mindestens eines der
//     * Listenelemente passt.
//     *
//     * @param predicate das übergebene Funktionsobjekt(Prädikat).
//     * @return true, wenn die Prädikatfunktion für mindestens eines der
//     *          Listenelemente passt. Ansonsten False.
//     */
//    @Override
//    public boolean exists(PredicateFunctionObject<E> predicate) {
//        if (predicate.call(Payload)) {
//            return true;
//        } else {
//            return getNext().exists(predicate);
//        }
//    }

    
    /**
     * überprüft, ob kein Wert in der Liste existiert, der das Prädikat nicht erfüllt.
     * @param predicate das übergebene Funktionsobjekt(Prädikat).
     * @return  true, wenn kein Wert in der Liste existiert, der das Prädikat 
     * nicht erfüllt. Ansonnsten False.
     */
    @Override
    public boolean forAll(PredicateFunctionObject<E> predicate) {
        if (predicate.call(Payload)) {
            return getNext().forAll(predicate);
        } else {
            return false;
        }
    }
}

