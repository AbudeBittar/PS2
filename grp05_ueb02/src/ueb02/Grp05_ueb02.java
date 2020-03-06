package ueb02;

/**
 *
 * @author Jan Robert Neumann & Abdulrahman Al Bittar
 */
public class Grp05_ueb02 {
    
    /**
     * Indexwerte, aus denen die neu geordnete Tour zusammengestellt wird.
     */
    private static final int[] ORDER = {1, 2, 0, 3, 1};
    
    /**
     * Indexwerte aus denen die neu geordnete Tour zusammengestellt wird.
     */
    private static final int START_OF_SHORT_TOUR = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Ausgabe
        for(int i = 0; i < TourData.getCountOfTours(); i++){
            //Ausgabe der Indizes der zu verwendenden Wegepunkte
            System.out.print("Indices for new order: ");
            for (int j = 0; j < ORDER.length; j++) {
                System.out.print(ORDER[j] + " ");
            }
            //TODO DONE %n statt \n
            //bearbeitende Tour zwischenspeichern
            //Erstellen eine tiefe Kopie der Tour
            int[][] currentTour = TourData.createDeepCopyOfTour(i);
            System.out.printf("%n-----------------------------%n");
            //Ausgabe der Tour + der gesamten Distanz
            System.out.printf("%-21s: " + Tour.tourToString(currentTour) 
                    + ", distance: %2.2f%n", "TOUR[" + i + "]"
                    , Tour.calcDistanceOverAllWaypoints(currentTour));
            //Ausgabe des nächsten Wegepunktes + der Distanz dazwischen
            int[][] closestPoints = Tour.getClosestWaypoints(currentTour);
            System.out.printf("%-21s: " 
                    + Tour.tourToString(closestPoints) 
                    + ", distance: %2.2f%n", "closest waypoints"
                    , Tour.calcDistanceOverAllWaypoints(closestPoints));
            //Ausgabe der sortierten Wegepunkte und der gesamten Distanz
            int[][] northSouthTour = Tour.createTourSortedNorthSouth(currentTour);
            System.out.printf("%-21s: " 
                    + Tour.tourToString(northSouthTour) 
                    + ", distance: %2.2f%n", "sorted NorthSouth"
                    , Tour.calcDistanceOverAllWaypoints(northSouthTour));
            //Ausgabe der kürzesten Tour, abfang von START_OF_SHORT_TOUR = 0 + die gesamten Distanz
            int[][] shortTour = Tour.createShortestTour(currentTour, START_OF_SHORT_TOUR);
            System.out.printf("%-21s: " 
                    + Tour.tourToString(shortTour) 
                    + ", distance: %2.2f%n", "short tour start at " + START_OF_SHORT_TOUR
                    , Tour.calcDistanceOverAllWaypoints
                    (shortTour));
            //Ausgabe der neuen Tour je nach ORDER
            int[][] orderedTour = Tour.createTourWithOrder(currentTour, ORDER);
            System.out.printf("%-21s: " 
                    + Tour.tourToString(orderedTour) 
                    + ", distance: %2.2f%n", "new ordered tour"
                    , Tour.calcDistanceOverAllWaypoints(orderedTour));
             //Ausgabe der Tour + der gesamten Distanz
            System.out.printf("%-21s: " + Tour.tourToString(currentTour) 
                    , "TOUR[" + i + "]");
            System.out.printf("%n----------------------------- %n");
        }
    }

}
