/**
 * Eine Instanz der Klasse Waypoint findet sich als Instanzattribut in dieser
 * Klasse wieder. Zudem gibt es in dieserr Klasse eine Instanzvariable,
 * die auf ein nächstes Element vom Typ TourElement zeigt.
 * Somit ist TourElement ein Knoten in einer Liste.
 * Das Listenende wird durch null gekennzeichnet.
 */
package ueb03;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar
 */
public class TourElement {

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
     */
    public void setWaypoint(Waypoint waypoint) {
        this.waypoint = waypoint;
    }

    /**
     * setter methode: setzt die Referenz dieses Elements auf das nächste
     * Element
     *
     * @param next Referenz des nächsten Elements
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
}
