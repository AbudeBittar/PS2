/**
 * Steht für die gesamte Realisierung der Liste.
 * Diese erlaubt den Aufruf von Listenoperationen auch für leere Listen
 * (wenn noch kein Element verfügbar ist, dessen Methoden für Listenoperationen
 * aufgerufen werden können).
 */
package ueb04;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar
 */
public class Tour {

    /**
     * Default-Konstruktor
     */
    public Tour() {

    }

    /**
     * Konstruktor, der ein zweidimensionales Array mit Wegepunkten aufnimmt und
     * diese der Liste zufügt.
     *
     * @param waypoints Waypoits-Array
     */
    public Tour(int[][] waypoints) {
        for (int i = waypoints.length - 1; i >= 0; i--) {
            Waypoint wp = new Waypoint(waypoints[i][0], waypoints[i][1]);
            addStart(wp);
        }
    }

    /**
     * vergleicht, ob beide Touren die gleichen Wegepunkte in der gleichen
     * Reihenfolge enthalten (und auch keinen mehr oder weniger).
     *
     * @param other Die übergebene Tour.
     * @return true, wennbeide Touren die gleichen Wegepunkte in der gleichen
     * Reihenfolge enthalten, ansonsten false.
     */
    public boolean isEqual(Tour other) {
        //Wenn beide Listen leer sind, dann wird true zurückgegeben.
        if (this.isEmpty() && other.isEmpty()) {
            return true;
        } else {
            //Abfangen von entweder leerer 'this' oder 'other' tour
            //false da eine leere und eine nicht-leere Liste nie gleich sein können
            if (this.isEmpty() ^ other.isEmpty()) {
                return false;
                //Bei zwei gefüllten Listen auf Gleicheit überprüfen mit methode aus TourElement 
            } else {
                return (this.head.isEqual(other.head));
            }
        }

    }

    /**
     * Erstellt eine Kopie der Tour, indem sie jedes Element der Tour kopiert.
     * -- Der Wegepunkt in einem Element muss nicht kopiert werden.
     *
     * @return Eine Kopie der Tour, indem sie jedes Element der Tour kopiert.
     */
    public Tour copy() {
        int[][] tourArray = new int[getNoOfWaypoints()][2];
        //For-Schleife, die jedes Element des tourArrays zugrift. 
        for (int i = 0; i < getNoOfWaypoints(); i++) {
            //Alle Element werden ins Array kopiert
            tourArray[i] = this.head.getWaypointAt(i).toArray();
        }
        // Umwandeln des Array tu einem Tour-Datentyp
        return new Tour(tourArray);
    }

    /**
     * Haengt die Wegepunkte der Tour other an die Wegepunkte dieser Tour an.
     * --Diese und die übergebene Tour dürfen nach Aufruf der Funktion nicht
     * verändert sein.
     *
     * @param other die uebergebene Tour.
     * @return Eine neue verkettete Tour der beiden Wegepunkte.
     */
    public Tour createConcatenatedTour(Tour other) {
        Tour result = new Tour();
        //Wenn diese Tour leer ist, dann wird nur der uebergebene Wegepunkte 
        // zurueckgegeben.
        if (isEmpty()) {
            result = other.copy();
        }// Ansonsten wird  die Wegepunkte der Tour other an die Wegepunkte
        // dieser Tour angehängt.
        else {
            result.head = this.copy().head.concat(other.copy().head);
        }
        return result;
    }

    /**
     * liefert eine neue Tour, deren Wegepunkte in der angegebenen Reihenfolge
     * sortiert sind.
     *
     * @param indices Ein Array , die die uebergebenen Indizis enthaelt.
     * @return Eine neue sortierte Tour
     */
    public Tour createTourWithOrder(int[] indices) {
        Tour result = new Tour();
        for (int i = indices.length - 1; i >= 0; i--) {
            //Fehlerhafte Indizes werden ignoriert.
            if (indices[i] < this.getNoOfWaypoints()) {
                // In jeder Runde der Schleife wird ein Element nach
                // uebergebener Indiz am Angang der result-Tour hinzugefuegt.  
                result.addStart(this.head.getWaypointAt(indices[i]));
            }
        }
        return result;
    }

    /**
     * liefert eine neue Tour, die nur Wegepunkte enthält, die in beiden Touren
     * vorhanden sind
     *
     * @param other Die uebergebene Tour
     * @return eine Tour, die gemeinsame Wegepunkte der beiden Touren enthaelt.
     */
    public Tour createPopularTour(Tour other) {
        Tour result = new Tour();
        for (int i = this.getNoOfWaypoints() - 1; i >= 0; i--) {
            if (other.contains(this.getWaypointAt(i))) {
                result.addStart(this.getWaypointAt(i));
            }
        }
        return result;
    }

    /**
     * Liefert eine neue Tour, welche beim gegebenen Startpunkt beginnt und den
     * jeweils dichtesten Wegpunkt als nächsten einsortiert.
     *
     * @param idxStartPnt Der Startindex.
     * @return Eine neue Tour, welche beim gegebenen Startpunkt beginnt und den
     * jeweils dichtesten Wegpunkt als nächsten einsortiert.
     */
    public Tour createShortestTour(int idxStartPnt) {
        //TODO DONE leere Liste
        Tour newTour = new Tour();
        // Bei invalidem Startindex wird eine leere Tour zurückgegeben.
        //FIXME DONE Indexprüfung ist noch nicht richtig
        if (idxStartPnt < 0 || idxStartPnt >= getNoOfWaypoints()) {
            return newTour;
        } // Bei richtigem Startindex... 
        else {
            if (isEmpty()) {
                return newTour;
            } else {
                // Eine Kopie dieser Tour.
                Tour compareTour = this.copy();
                //Jedes Element in die newTour hinzufuegen und von der 
                // compareTour entfernen.Erstens mithilfe von addStart und danch
                // von append und einer While-Schleife.
                newTour.addStart(getWaypointAt(idxStartPnt));
                compareTour.removeAt(idxStartPnt);
                while (!compareTour.isEmpty()) {
                    // dichtesten Wegpunkt als nächsten einsortieren.
                    int idx = compareTour.head.getIdxOfClosestWaypoint(
                            this.getWaypointAt(idxStartPnt));
                    newTour.append(compareTour.getWaypointAt(idx));
                    compareTour.removeAt(idx);
                }
                newTour.createTourWithoutDuplicates();
                return newTour;
            }
        }
    }
        /**
         * Erstellt eine Kopie dieser Tour, welche jeden Wegepunkt höchstens ein
         * Mal enthält.
         *
         * @return Eine Tour ohne Duplikate
         */
    public Tour createTourWithoutDuplicates() {
        Tour newTour = new Tour();
        //Fuer alle Elemente, wenn jedes einzelne ueberprufene Element in
        // der newTour schon vorhanden ist, wird nicht hinzugefuegt.
        for (int i = 0; i < getNoOfWaypoints(); i++) {
            if (!newTour.contains(getWaypointAt(i))) {
                newTour.append(getWaypointAt(i));
            }
        }
        return newTour;
    }

    /**
     * liefert eine neue Tour, die ausgehend vom ersten Punkt dieser Tour zum
     * jeweils dichtesten Punkt aus den beiden Touren führt -- Existieren in
     * beiden Touren gleich weit entfernte Wegepunkte, so wird der Wegepunkt aus
     * dieser Tour aufgenommen. -- Ist diese Tour leer, wird der Startpunkt der
     * anderen Tour verwendet. -- Gleiche Wegepunkte werden nur einmalig in die
     * neue Tour aufgenommen.
     *
     * @param other die uebergebene Tour
     * @return eine Tour, die je nach kuerzester Tour sortiert und ohne
     * Duplikate ist.
     */
    public Tour createUnion(Tour other) {
        Tour unionTour = new Tour();
        if (this.isEmpty()) {
            //Wenn diese Tour leer ist, wird die uebergebene Tour zurueckgegeben.
            unionTour = other.copy();
        } else {
            //die Wegepunkte der Tour other an die Wegepunkte derunion Tour anhaengen.
            unionTour = this.createConcatenatedTour(other);
        }// Duplikate werden entfernt.
        unionTour = unionTour.createTourWithoutDuplicates();
        // Dichtesten Wegpunkt als nächsten einsortieren.
        unionTour = unionTour.createShortestTour(0);
        return unionTour;
    }

//<editor-fold defaultstate="collapsed" desc="Tour Methoden aus ueb03">
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
            head = new TourElement(waypoint);
        } else {
            head = head.addStart(waypoint);
        }
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
    //</editor-fold>
}
