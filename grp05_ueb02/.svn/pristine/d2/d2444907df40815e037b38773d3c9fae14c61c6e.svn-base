package ueb02;

/**
 * Enthält die Daten der Koordinaten der jeweiligen Touren
 * @author Jan Robert Neumann & Abdulrahman Al Bittar
 */
public class TourData {

    /**
     * Mehrere Touren mit mehreren Wegepunkten, die aus jeweils x- und y-Wert bestehen.
     */
     static final int[][][] TOUR = new int[][][]{
        {{0, 0}, {4, 0}, {4, 3}, {0, 3}}, 
        {{0, 0}, {3, 0}, {3, 4}, {0, 0}}, 
        {{1, 3}, {3, 2}, {0, 4}, {2, 2}, {3, 1}, {1, 4}, {2, 3}}, 
        {{-2, -1}, {-2, +3}, {4, 3}, {0, 0}} 
    };
    
    
    
    /**
     * Liefert die Anzahl der vorhandenen Touren in der Konstante.
     * @return die Anzahl der vorhandenen Touren
     */
    public static int getCountOfTours() {
        return TOUR.length; 
    }
    
    /**
     * Liefert die tiefe Kopie der Tour.
     * @param idx index der zu kopierenden Tour
     * @return tiefe Kopie der Tour
     */
    public static int[][] createDeepCopyOfTour(int idx) {
         if (idx >= 0 && idx < getCountOfTours()) {
             //tourCopy ist eine Kopie der ausgewählten Tour. 
             // erster Teil der Größe beschreibt wie lange die ausgewählte Tour ist,
             //[2] steht für die zwei Punkte der jeweiligen Koordinaten.
             int [][] tourCopy = new int[TOUR[idx].length][2];
            
             //kopiert die Werte der ausgewählten Tour.
             for(int i = 0; i < tourCopy.length; i++) {
                 tourCopy[i] = TOUR[idx][i].clone();
             }
             return tourCopy;
           }
         else {
             return null;
           } 
    }    
    
}
