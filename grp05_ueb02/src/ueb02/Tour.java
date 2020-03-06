package ueb02;

/**
 * Statische Methoden zur Untersuchung einer Tour, die aus Wegepunkten besteht,
 * welche aus einem int-Array mit einem x- und einem y-Wert bestehen.
 *
 * @author Jan Robert Neumann & Abdulrahman Al Bittar
 */
public class Tour {

    /**
     * Position des x-Wertes im Array eines Wegepunktes
     */
    private static final int X = 0;
    /**
     * Position des y-Wertes im Array eines Wegepunktes
     */
    private static final int Y = 1;

    /**
     * Berechnet die direkte Entfernung zwischen zwei Wegepunkten. Bei der
     * Berechnung wird dabei ein rechtwinkliges Dreieck zwischen Wegepunkt src
     * und dest gespannt. Anschließend wird die Länge der Hypotenuse berechnet
     * und als direkter Weg bezeichnet. Diagonal zu laufen ist hierbei gewollt.
     *
     * @param src - Wegepunkt des Starts
     * @param dest - Wegepunkt des Ziels
     * @return direkte Dinstanz zwischen src und dest
     * @pre <code>src</code> und <code>dest</code> müssen jeweils 2 Werte
     * enthalten
     */
    private static double calcDistanceBetweenWaypoints(int[] src, int[] dest) {
        assert src.length == 2;
        assert dest.length == 2;
        //X-Wert des Starspunktes. 
        double srcX = (double)src[X];
        //X-Wert des Fahrzieles.
        double destX = (double)dest[X];
        //Y-Wert des Ausgangspunktes. 
        double srcY = (double)src[Y];
        //X-Wert des Fahrzieles.
        double destY = (double)dest[Y];
        
        return ( Math.sqrt(Math.pow(destX - srcX, 2) + Math.pow(destY - srcY, 2)));
    }

    /**
     * Berechnet den Weg, welcher zurück gelegt werden muss, um vom ersten
     * gesetzten Wegepunkt über alle weiteren bis zum letzten Wegepunkt zu kommen.
     * Hierbei soll die Methode <code>calcDistanceBetweenWaypoints()</code> verwendet werden.
     *
     * @param tour - mehrere Wegepunkte in einem Array
     * @return Länge des Wanderweges
     */
    public static double calcDistanceOverAllWaypoints(int[][] tour) {
        // distants ist die Länge des Wanderweges.
        // 0 ist neutral bei der Addition
        double distants = 0;
        for (int i = 0; i < tour.length - 1;i++){
            distants += calcDistanceBetweenWaypoints(tour[i], tour[i+1]);
         }
       return distants;
    }

    /**
     * Liefert die beiden benachbarten Wegepunkte, deren Distanz am kürzesten
     * ist.
     *
     * @param tour - mehrere Wegepunkte in einem Array
     * @return benachbarte Wegepunkte, deren Distanz zueinander minimal ist, <br>
     * ein leeres Array, wenn weniger als zwei Punkte vorhanden
     */
    public static int[][] getClosestWaypoints(int[][] tour) {
        // shortest: sehe @return.
        int [][] shortest = new int[2][2];
        //Falls weniger als zwei Punkte vorhanden, ein leeres Array zurückgeben. 
        if (tour.length < 2) {
            return shortest;
        }
        // compWaypoints sind die Indexe, die die Wegepunkte miteinander vergleichen.
        int compWaypoint1 = 0;
        int compWaypoint2 = 1;
        // resultWaypoints sind die Indexe der Wegepunkte, die am Nächsten zueinander sind. 
        int resultWaypoint1 = 0;
        int resultWaypoint2 = 1;
        //shortestDistance: Kürzeste Distanz zwischen zwei Wegepunkten.
        double shortestDistance = calcDistanceBetweenWaypoints(tour[compWaypoint1], tour[compWaypoint2]);
        //-2 falls der Startpunkt der zweiletzte Punkt auf der Karte ist. 
        while (compWaypoint1 != tour.length - 2 && compWaypoint2 != tour.length - 1){
            if (calcDistanceBetweenWaypoints(tour[compWaypoint1], tour[compWaypoint2]) < shortestDistance) {
                resultWaypoint1 = compWaypoint1;
                resultWaypoint2 = compWaypoint2;
                shortestDistance = calcDistanceBetweenWaypoints(tour[compWaypoint1], tour[compWaypoint2]);
            }
            //beide Wegepunkte um 1 erhöhen. 
            compWaypoint1++;
            compWaypoint2++;
        }
        //Indexe der Wegepunkte, die am Nächsten zueinander sind, kopieren
        shortest[X] = tour[resultWaypoint1].clone();
        shortest[Y] = tour[resultWaypoint2].clone();
        
        return shortest;
    }

    /**
     * Löscht einen Wegepunkt aus einer Tour.
     * @param tour die Tour aus der ein Wegepunkt gelöscht wird.
     * @param deleteIdx der Index an dem der Wegpunkt gelöscht wird
     * @return die Tour aus der ein Wegpunkt gelöscht wurde.
     */
    private static int[][] deleteWaypoint (int[][] tour, int deleteIdx) {
        //copyArr; Enthält die Tour aus der ein Wegpunkt gelöscht wurde.
        int[][] copyArr = new int[tour.length-1][2];
        //System.arraycopy(Quell-Array,Indexposition ,Ziel-Array ,Indexposition, Anzahl der zu kopieren Elemente);
        System.arraycopy(tour, 0, copyArr, 0, deleteIdx);
        System.arraycopy(tour, deleteIdx + 1, copyArr, deleteIdx,tour.length - deleteIdx - 1);
        
        return copyArr;
    }
       
    /**
     * Liefert eine Tour, die die Wegepunkte der übergebenen Tour von Nord 
     * nach Süd sortiert enthält. Sind Punkte auf gleicher Höhe, so werden 
     * sie von West nach Ost sortiert. Je größer ein Koordinatenwert, desto 
	 * südlicher bzw. östlicher liegt er. 
     *
     * @param tourToSort zu sortierende Tour (darf nicht verändert werden)
     * @return ertellte Tour mit sortierten Wegepunkten
     */
    public static int[][] createTourSortedNorthSouth(int[][] tourToSort) {
        int [][] temp ;
        temp = tourToSort;  
        int [][] resultTour = new int [tourToSort.length][2];
        //TODO DONE einheitliche variablennamen
        int yValue;
        int xValue = 0;
        int mostNorth = 0;
        int newidx = 0;
        //sortiert von Nord nach Süd 
        while (temp.length != 0) {
            yValue = Integer.MAX_VALUE;
            for (int i = 0; i < temp.length; i++ ) {
                //sortiert von Nord nach Süd 
                if (temp[i][Y] < yValue) {
                    yValue = temp[i][1];
                    mostNorth = i;
                    xValue = temp[i][X];
                }
                //sortiert von West nach Ost
                else if (temp[i][Y] == yValue && temp[i][X] < xValue) {
                    mostNorth = i;
                }
            }
            resultTour[newidx] = temp[mostNorth].clone();
            temp = deleteWaypoint(temp, mostNorth);
            newidx++;
        }
        return resultTour;
    }
       

    /**
     * Berechnet eine "kürzeste" Tour. Kürzeste bedeutetet, dass ausgehend von
     * einem Startpunkt jeweils der nächste naheliegendste Punkt besucht wird,
     * der noch nicht in der Tour berücksichtigt wurde, bis alle Punkte besucht
     * wurden. Je nach Lage der Punkte kann der Algorithmus in einer ineffizient
     * langen Route resultieren. Ob tatsächlich die kürzeste Route gefunden
     * wurde, kann nicht bestimmt werden.
     *
     * @param tour Tour, für die eine kürzeste Route gefunden werden soll 
     *             (Array darf nicht verändert werden)
     * @param idxStartPnt Index des Startpunktes für die kürzeste Tour
     * @return eine neue, (hoffentlich) kürzeste Tour
     */
    public static int[][] createShortestTour(int[][] tour, int idxStartPnt) {
        //Intitalisierung der Werte
        int [][] temp = tour ;
        int [][] shortTour = new int [tour.length][2];
        int nextWaypointIdx = 0;
        //Setzen des ersten Wegpunkts auf Grundlage des übergebenen Index
        shortTour[0] = temp[idxStartPnt].clone();
        temp = deleteWaypoint (temp, idxStartPnt);
        double minDistance;
        for (int i = 0; i < tour.length - 1; i++){
            //Initalisieren auf den höchsten Wert, damit der erste if-Fall true wird
            minDistance = Double.MAX_VALUE;
            for (int j = 0; j < temp.length; j++){
                //Aktualisiert den kürzesten Wegpunkt wenn ein kürzerer gefunden wurde
                if (calcDistanceBetweenWaypoints(shortTour[i], temp[j]) < minDistance) {
                minDistance = calcDistanceBetweenWaypoints(shortTour[i], temp[j]);
                nextWaypointIdx = j;
                }
            }
            //Überträgt den neuen kürzesten Weg ins Ziel-Array
            shortTour[i + 1] = temp[nextWaypointIdx].clone();
            //löscht den übertragenen Wegpunkt aus dem Vergleichs-Array
            temp = deleteWaypoint (temp, nextWaypointIdx);
        }
        return shortTour;
    }

    /**
     * Liefert eine Tour mit den Wegepunkten der übergebenen Tour in der 
     * Reihenfolge, wie sie durch die im Parameter gegebenen Indizes bestimmt 
     * werden.
     *
     * @param tour Tour, aus der eine neue gestaltet werden soll
	 *             (darf nicht verändert werden) 
     * @param indices Indizes der zu verwendenden Wegepunkte
     * @return Tour mit den Wegepunkten in der gegebenen Reihenfolge
     */
    public static int[][] createTourWithOrder(int[][] tour, int[] indices) {
        int [][] resultTour = new int [indices.length][2];
        //Überträgt in resulttour Wegpunkte auf Grundlage der Indices
        for (int i = 0; i < indices.length; i++) {
            resultTour [i] = tour[indices[i]].clone();
        }
        return resultTour;
    }

    
    /**
     * Konvertiert einen Wegepunkt in einen String. Die Werte werden in runde
     * Klammern eingeschlossen und mit Schrägstrich voneinander getrennt: <br>
     * {4, 10} -> (4/10)
     *
     * @param waypoint - Wegepunkt, welcher in einen String überführt werden soll
     * @return der Wegepunkt in Stringdarstellung
     */
    private static String waypointToString(int[] waypoint) {
        //Übertragen der Array-Werte in variablen
        int xWert = waypoint[X];
        int yWert = waypoint[Y];
        String strWaypoint;
        //einfügen der variablen in einen String
        strWaypoint = "(" + xWert + "/" + yWert + ")";
        return strWaypoint;
    }

    /**
     * Stellt eine Tour bestehend aus mehreren Wegepunkten in einem String dar.
     * Hierbei wird die Methode <code>waypointToString</code> genutzt, um jeden 
     * einzelnen Wegepunkt in das gewünschte Format zu bringen. <br>
     * Die Tour wird mit eckigen Klammern umgeben und die Punkte mit 
     * Bindestrich-Größer voneinander getrennt:<br>
     * {{}} -> "[]" <br> {{1,4},{4,10},{12,18}} -> "[(1/4) -> (4/10) ->
     * (12/18)]"
     *
     * @param tour - mehrere Wegepunkte in einem Array
     * @return die Tour als String
     */
    public static String tourToString(int[][] tour) {
        String strTour;
        strTour = "[";
        //setzt wegpunkte zusammen
        for (int i = 0; i < tour.length - 1; i++) {
            strTour += waypointToString(tour[i]) + " -> ";
        }
        //fügt den letzten Wegpunkt hinzu
        strTour += waypointToString(tour[tour.length - 1]) + "]";
        return strTour;
    }
}
