/**
 * Eine Instanz der Klasse Waypoint findet sich als Instanzattribut in dieser
 * Klasse wieder. Zudem gibt es in dieserr Klasse eine Instanzvariable,
 * die auf ein nächstes Element vom Typ TourElement zeigt.
 * Somit ist TourElement ein Knoten in einer Liste.
 * Das Listenende wird durch null gekennzeichnet.
 */
package ueb04;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar
 */
public class TourElement {

    /**
     * Default-Konstruktor
     *
     * @deprecated
     */
    public TourElement() {
        this(null);
    }

    /**
     * Konstruktor, der nur einen Wegepunkt als Parameter hat.
     *
     * @param waypoint Enthält den Wegpunkt dieses Elements .
     */
    public TourElement(Waypoint waypoint) {
        this(waypoint, null);
    }

    /**
     * Konstruktor, der Zwei parameter hat.
     *
     * @param waypoint Enthält den Wegpunkt dieses Elements.
     * @param next Zeigt auf das nächste Element
     */
    public TourElement(Waypoint waypoint, TourElement next) {
       // assert waypoint != null;
        this.waypoint = waypoint;
        this.next = next;
    }

    /**
     * vergleicht, ob beide Listen die gleichen Wegepunkte in der gleichen
     * Reihenfolge enthalten (und auch keinen mehr oder weniger).
     *
     * @param other: Der übergebene Wegepunkt.
     * @return : true, wenn beide Listen die gleichen Wegepunkte in der gleichen
     * Reihenfolge enthalten. Ansonsten false.
     */
    public boolean isEqual(TourElement other) {
        //Prüft, ob die Liste leer ist.
        if (other == null) {
            return false;
        } //Wenn die Liste nicht leer ist dann...
        else {
            //Prüft, ob die beiden Listen nur ein Element haben, dann...
            if (other.getNext() == null && this.getNext() == null) {
                //Gibt true zurük, Wenn beide Elemente gleich sind. Ansonsten false.
                return this.getWaypoint().isEqual(other.getWaypoint());
            } //Im Falle die beiden Listen mehrere Elemente haben, dann...
            else {
                // Wird jedes Element beider Listen in der Reihenfolge geprüft,
                // ob die gleis sind. Das funktioniert durch den Aufruf der Methode
                // hasNext()und hört auf wenn hasNext() == null zurückgibt.
                if (this.getWaypoint().isEqual(other.getWaypoint()) && this.hasNext()) {
                    return getNext().isEqual(other.getNext());
                } // Andernfalls false zurückgeben.
                else {
                    return false;
                }
            }
        }
    }

    /**
     * Gibt das letzte Element einer Liste zurück.
     *
     * @return das letzte Element einer Liste.
     */
    private TourElement getLastElement() {
        //Wenn kein Element mehr übrig ist, dann gib es das Aktuelle zurück.
        if (!hasNext()) {
            return this;
        } //Ansonsten ruf getLastElement rekursiv zurück.
        else {
            return getNext().getLastElement();
        }
    }

    /**
     * Hängt die Liste other an das Ende dieser Liste hinten an.
     *
     * @param other Der übergebene Wegepunkt.
     * @return Die beiden Lesten.
     */
    public TourElement concat(TourElement other) {
        getLastElement().next = other;
        return this;
    }

//    private int returnsMin (int te1, int te2){
//        if (te1 < te2){
//            return te1;
//        } else if (te1 > te2){
//            return te2;
//        } else {
//            return te1;
//        }      
//    }
    /**
     * Eine Hilfsmethode für die Rekursion der Methode
     * getIdxOfClosestWaypoint(Waypoint waypoint) und berechnet die kürzeste
     * Distanz zwischen beiden Wegepunkten.
     *
     * @param other Der übergebene Wegepunkt.
     * @param waypoint Der aktuelle Wegepunkt.
     * @return die kürzeste Distanz zwischen zwei Wegepunkten.
     */
    private Waypoint getClosestWaypoint(TourElement other, Waypoint waypoint) {
        // Wenn ein Element mehr übrich ist, dann...
        if (hasNext()) {
            // Wenn die Distanz des aktuellen Wegepunktes kleiner-glrich die Distanz
            // des übergebenen Wegebunktes ist, dann...
            // kleiner-gleich steht dazu, wenn zwei Wegepunkte der Liste gleich weit 
            // vom übergebenen entfernt, wird die Distanz des ersten von beiden zurückzugeben.
            if (this.getWaypoint().calcDistance(waypoint)
                    <= other.getWaypoint().calcDistance(waypoint)) {
                // Ruf getClosestWaypoint( , ) mit den Parametern von dem nächsten
                //Element dieses Wegepunktes mit dem aktuellen Wegepunkt rekursiv auf. 
                return getNext().getClosestWaypoint(this, waypoint);
            } //Ansonsten, ruf getClosestWaypoint( , ) mit den Parametern von dem nächsten
            //Element des übergebenen Wegepunktes mit dem aktuellen Wegepunkt rekursiv auf.
            else {
                return getNext().getClosestWaypoint(other, waypoint);
            }
        } //Ansonsten wenn kein Element mehr übrich ist, dann...
//        else 
//            if (this.getWaypoint().calcDistance(waypoint) == other.getWaypoint().calcDistance(waypoint)){
//            return other.getWaypoint();
//        }
        else{
            //Berechne die Distanz zu beiden letzten Wegepunkten und gib die Kürtzte zurück.
            return (this.getWaypoint().calcDistance(waypoint)
                    < other.getWaypoint().calcDistance(waypoint)
                    ? this.getWaypoint() : other.getWaypoint());
        }
    }

    /**
     * Liefert den Index des Listenelements zurück, dessen Wegepunkt die
     * kürzeste Distanz zum übergebenen aufweist. Sind zwei Wegepunkte der Liste
     * gleich weit vom übergebenen entfernt, ist der Index des ersten von beiden
     * zurückzugeben.
     *
     * @param waypoint Der aktuelle Wegepunkt.
     * @return Den Index des Listenelements, dessen Wegepunkt die kürzeste
     * Distanz zum übergebenen aufweist.
     */
    public int getIdxOfClosestWaypoint(Waypoint waypoint) {
        //TODO DONE bei gleich weit entfernten Punkten den ersten zurueckgeben
        // Wenn ein Elemnt mehr übrich ist, dann...
        if (hasNext()) {
            //Wenn das geprüfte Element die kürzeste Distanz hat dann wird 0 zurückgegeben.
            if (this.getWaypoint().isEqual(getClosestWaypoint(this, waypoint))) {
                return 0;
            } // Ansonsten wird das Element gezählt und weiter das nächste Element geprüft.
            else {
                return 1 + getNext().getIdxOfClosestWaypoint(waypoint);
            }
        } //Wenn die Liste nur eein Element hat, dann wird 0 zrückgegeben.
        else {
            return 0;
        }
        //double dist = this.getWaypoint().calcDistance(waypoint);
        //double dist2 = this.getNext().getWaypoint().calcDistance(waypoint);
        //return returnsMin((int)dist, (int)dist2);
    }

//<editor-fold defaultstate="collapsed" desc="TourElement Methoden aus ueb03">
    /**
     * waypoint: Enthält den Wegpunkt dieses Elements next: Zeigt auf das
     * nächste Element
     */
    private Waypoint waypoint;
    private TourElement next;

    /**
     * getter methode: Liefert den Wegpunkt dieses Elements
     *
     * @return Wegpunkt des Elements
     */
    public Waypoint getWaypoint() {
        return waypoint;
    }

    /**
     * getter methode: Liefert das Element auf das dieses Element zeigt
     *
     * @return das nächste Element
     */
    public TourElement getNext() {
        return next;
    }

    /**
     * Prüft, ob ein weiteres Element vorhanden ist
     *
     * @return true, wenn ein Element vorhanden ist
     */
    public boolean hasNext() {
        return (this.getNext() != null);
    }

    /**
     * setter methode: setzt den Wegpunkt dieses Elements
     *
     * @param waypoint der Wegpunkt den dieses Element enthalten soll.
     * @deprecated
     */
    public void setWaypoint(Waypoint waypoint) {
        this.waypoint = waypoint;
    }

    /**
     * setter methode: setzt die Referenz dieses Elements auf das nächste
     * Element
     *
     * @param next Referenz des nächsten Elements
     * @deprecated
     */
    public void setNext(TourElement next) {
        this.next = next;
    }

    /**
     * Zählt die Anzahl der folgenden Elemente des Elements
     *
     * @return Anzahl der Elemente
     */
    public int getNoOfWaypoints() {
        if (this.hasNext()) {
            return getNext().getNoOfWaypoints() + 1;
        }
        return 1;
    }

    /**
     * Prüft ob sich ein übergebener Wegpunkt in den Tour Elementen befindet
     *
     * @param waypoint mit diesem Wegpunkt wird in den Tour Elementen verglichen
     * @return true, wenn der übergebene Wegpunkt gefunden wurde
     */
    public boolean contains(Waypoint waypoint) {
        if (this.getWaypoint().isEqual(waypoint)) {
            return true;
        } else {
            //rekursiv aufrufen wenn es noch ein nächstes Element vorhanden ist. 
            if (hasNext()) {
                return getNext().contains(waypoint);
            } else {
                return false;
            }
        }
    }

    /**
     * Berechnet die Distanz über alle Wegpunkte der Tour Elemente
     *
     * @return die Distanz als double
     */
    public double calcDistance() {
        //result speichert die gesamte Distanz.
        double result = 0;
        //Wenn es ein nächstes Element gibt, dann wird die Distanz dazwischen berechnet und zu result addiert.
        //Ruft sich rekursiv auf solange es ein nächstes Element gibt.
        if (hasNext()) {
            result += waypoint.calcDistance(this.getNext().getWaypoint()) + getNext().calcDistance();
//            if (hasNext() == false) {
//                result = 0;
//            }
            return result;
        } else {
            return result;
        }
    }

    /**
     * Liefert den Wegpunkt am übergenen index
     *
     * @param index des gesuchten Wegpunkts
     * @return Wegpunkt an der Stelle des Indexes
     */
    public Waypoint getWaypointAt(int index) {
        //Prüft ob der Index gültig ist.
        if (index < 0) {
            return null;
        } else {
            //Wenn das erste Element angefordert wird.
            if (index == 0) {
                return getWaypoint();
            } else {
                //Bei mehreren Elementen
                if (hasNext()) {
                    return getNext().getWaypointAt(index - 1);
                } else {
                    return null;
                }
            }
        }
    }

    /**
     * Fügt den übergebenen Wegpunkt an den Anfang der Tour Elemente
     *
     * @param waypoint Wegpunkt der hinzugefügt werden soll
     * @return Tour Elemente mit hinzugefügtem Wegpunkt
     */
    public TourElement addStart(Waypoint waypoint) {
        //Wenn das zu addieren Element gleich null ist, wird nichts geändert
        if (waypoint == null) {
            return this;
        }
        TourElement first = new TourElement();
        //fügt den übergebenen Wegepunkt an den Anfang als das erste Element hinzu.
        first.setWaypoint(waypoint);
        //fügt den alten Wegepunkt zum ersten Element hinzu. 
        first.setNext(this);

        return first;
    }

    /**
     * Fügt den übergebenen Wegpunkt ans Ende der Tour Elemente hinzu
     *
     * @param waypoint Wegpunkt der hinzugefügt werden soll
     * @return Tour Elemente mit hinzugefügtem Wegpunkt
     */
    public TourElement append(Waypoint waypoint) {
        if (waypoint == null) {
            return this;
        } else {
            //Ruft sich auf solange es noch ein nästes Element Gibt.
            //Dadurch kann man das letzte Element erreichen
            if (hasNext()) {
                getNext().append(waypoint);
            } else {
                //Die gleiche Mentalität wie bei addStart
                TourElement add = new TourElement();
                this.setNext(add);
                getNext().setWaypoint(waypoint);
                //Null hinzufügen. (Ende der Liste definieren)
                getNext().setNext(null);
            }
        }
        return this;
    }

    /**
     * Fügt den übergebenen Wegpunkt an der Stelle des übergebenen index der
     * Tour Elemente hinzu.
     *
     * @param index ort and dem Wegpunkt hinzugefügt werden soll
     * @param waypoint Wegpunkt der hinzugefügt werden soll
     * @return Tour Elemente mit hinzugefügtem Wegpunkt
     */
    public TourElement insertAt(int index, Waypoint waypoint) {
        //Prüft ob beide Parameter gültig sind. 
        if (index < 0 || waypoint == null) {
            return this;
        } else {
            //TODO DONE hasNext() nur beim Aufruf der Rekursion
            //Prüft ob der Index gleich 0 ist, dann wird der Wegepunkt
            //an den Anfang hinzufügt.
            if (index == 0) {
                return addStart(waypoint);
            } else {
                //Wenn der Index gleich 1 ist, 
                //dann wird der Wegepunkt durch setNext hinzufügt.
                if (index == 1) {
                    TourElement inserter = new TourElement();
                    inserter.setWaypoint(waypoint);
                    inserter.setNext(this.getNext());
                    this.setNext(inserter);
                    return this;
                } else {
                    //Prüft ob es ein nächstes Element gibt.
                    //die Methode wird sich dann rekursiv aufrufen
                    //und gleichzeiteig den Index um 1 verringern
                    if (hasNext()) {
                        getNext().insertAt(index - 1, waypoint);
                    }
                    //Prüft ob der Index gleich 0 ist, dann wird der Wegepunkt
                    //an den Anfang hinzufügt.

                }
            }
            return this;
        }
    }

//            //Wenn es kein nächstes Element gibt dann wird das Element einfach hinzugefügt.
//            else {
//                TourElement inserter = new TourElement();
//                inserter.setWaypoint(waypoint);
//                inserter.setNext(null);
//                this.setNext(inserter);
//            }
    /**
     * Entfernt den Wegpunkt an der Stelle des übergeben Index
     *
     * @param index Stelle an der der Wegpunkt entfernt werden soll
     * @return Tour Elemente mit entferntem Wegpunkt
     */
    public TourElement removeAt(int index) {
        //überprüft, ob der Index gültig ist. Ist der Index ungültig, passiert nichts.
        if (index < 0) {
            return this;
        }
        //Wenn wir das Element am Anfang der Liste entfernen möchten.
        if (index == 0) {
            return getNext();
        } else {
            if (index > 0) {
//                //Wenn wir das zweite Element der Liste entfernen möchten.
//                if (index == 1) {
//                    //Prüft, ob es nur zwei Elemente gibt.
//                    if (hasNext() && getNext().hasNext()) {
//                        //So wird das erste Element entfernt.
//                        this.setNext(getNext().getNext());
//                    } else {
//                        this.setNext(null);
//                    }
//                } else {
                //Wenn der Index großer als 1 dann wird sich die Methode aufrufen
                //und gleichzeitig um 1 verringern.
                if (hasNext()) {
                    next = getNext().removeAt(index - 1);
                } else {
                    return this;
                }
//                }
            } else {
                return null;
            }
            return this;
        }
    }

    /**
     * Tour Elemente wird als String dargestellt nach dem Schema: (X1/Y1) ->
     * (X2/Y2)
     *
     * @return Tour Elemente als String
     */
    public String toString() {
        if (hasNext()) {
            return this.getWaypoint().toString() + " -> " + getNext().toString();
        } else {
            return this.getWaypoint().toString();
        }

    }
    //</editor-fold>
}
