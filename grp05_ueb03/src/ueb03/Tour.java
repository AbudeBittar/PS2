/**
 * Steht für die gesamte Realisierung der Liste.
 * Diese erlaubt den Aufruf von Listenoperationen auch für leere Listen 
 * (wenn noch kein Element verfügbar ist, dessen Methoden für Listenoperationen
 * aufgerufen werden können).
 */
package ueb03;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar
 */
public class Tour {

    /**
     * Atribut: Anfang der Tour/Liste
     */
    TourElement head;

    /**
     * Prüft ob ein Anfang der Tour und damit eine Tour vorhanden ist.
     *
     * @return true, wenn keine Tour vorhanden
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Liefert den Anfangspunkt der Tour wenn sie nicht leer ist.
     *
     * @return Anfangspunkt der Tour
     */
    public Waypoint getStartPoint() {
        if (isEmpty()) {
            return null;
        } else {
            return head.getWaypoint();
        }
    }

    /**
     * Zählt die vorhandenen Elemente in der Tour
     *
     * @return Anzahl der Elemente
     */
    public int getNoOfWaypoints() {
        if (isEmpty()) {
            return 0;
        }
        return head.getNoOfWaypoints();
    }

    /**
     * Berechnet die Distanz über alle Wegpunkte der Tour
     *
     * @return die Distanz als double
     */
    public double calcDistance() {
        if (isEmpty()) {
            return 0;
        }
        return head.calcDistance();
    }

    /**
     * Liefert den Wegpunkt am übergenen index
     *
     * @param index des gesuchten Wegpunkts
     * @return Wegpunkt an der Stelle des Indexes
     */
    public Waypoint getWaypointAt(int index) {
        if (isEmpty()) {
            return null;
        } else {
            return head.getWaypointAt(index);
        }
    }

    /**
     * Prüft ob sich ein übergebener Wegpunkt in der Tour befindet
     *
     * @param waypoint mit diesem Wegpunkt wird in der Tour verglichen
     * @return true, wenn der übergebene Wegpunkt gefunden wurde
     */
    public boolean contains(Waypoint waypoint) {
        if (isEmpty()) {
            return false;
        }
        return head.contains(waypoint);
    }

    /**
     * Fügt den übergebenen Wegpunkt an den Anfang der Tour
     *
     * @param waypoint Wegpunkt der hinzugefügt werden soll
     * @return Tour mit hinzugefügtem Wegpunkt
     */
    public Tour addStart(Waypoint waypoint) {
        boolean emptiness = isEmpty();
        if (emptiness) {
            head = new TourElement();
        }
        head = head.addStart(waypoint);
        if (emptiness) {
            head.removeAt(1);
        }
        return this;
    }

    /**
     * Fügt den übergebenen Wegpunkt am Ende der Tour hinzu
     *
     * @param waypoint Wegpunkt der hinzugefügt werden soll
     * @return Tour mit hinzugefügtem Wegpunkt
     */
    public Tour append(Waypoint waypoint) {
        boolean emptiness = isEmpty();
        if (emptiness) {
            addStart(waypoint);
            //head = new TourElement();
        } else {
        this.head.append(waypoint);
        }
        //if (emptiness) {
        //    head.removeAt(0);
        //}
        return this;
    }

    /**
     * Fügt den übergebenen Wegpunkt an der Stelle des übergebenen index der
     * Tour hinzu.
     *
     * @param index ort and dem Wegpunkt hinzugefügt werden soll
     * @param waypoint Wegpunkt der hinzugefügt werden soll
     * @return Tour mit hinzugefügtem Wegpunkt
     */
    public Tour insertAt(int index, Waypoint waypoint) {
        //FIXME DONE in leere Tour an Index 0 wird das Element zweifach eingefügt
        //FIXME DONE schreiben Sie einen Testfall, der verifiziert, dass das nicht stattfindet
        if (isEmpty()) {
            if (index == 0) {
                return addStart(waypoint);
            } else {
                return this;
            }
        } else {
        head = this.head.insertAt(index, waypoint);
        return this;
        }
    }

    /**
     * Entfernt den Wegpunkt an der Stelle des übergeben Index
     *
     * @param index Stelle an der der Wegpunkt entfernt werden soll
     * @return Tour mit entferntem Wegpunkt
     */
    public Tour removeAt(int index) {
        if (isEmpty()) {
            return this;
        } else {
            head = this.head.removeAt(index);
            return this;
        }
    }

    /**
     * Tour wird als String dargestellt nach dem Schema: [(X1/Y1) -> (X2/Y2) ->
     * (X3/Y3)]
     *
     * @return Tour als String
     */
    public String toString() {
        return (isEmpty() ? "[]" : "[" + this.head.toString() + "]");
    }
}
