package ueb.list.functions;

import ueb.Waypoint;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar.
 */

/**
 * spezialisiertes Funktionsobjekt der PredicateFunctionObject-Klasse, das einen
 * Waypoint als Parametertyp übernimmt.
 */
public class IsInDistanceFrom extends PredicateFunctionObject<Waypoint> {
    // Einzuhaltende Distanz
    private final double dist;
    // Referenz-Wegepunkt
    private final Waypoint ref;
    
   /**
    * Konstruktor, welcher den Referenz-Wegepunkt und die einzuhaltende Distanz
    *  als Argumente enthält.
    * @param ref Referenz-Wegepunkt
    * @param dist Einzuhaltende Distanz
    */
    public IsInDistanceFrom (Waypoint ref, double dist) {
        this.dist = dist;
        this.ref = ref;
    }
    
    /**
     *  überprüft, ob die Distanz zwischen dem übergebenen und dem Referenz-Wegepunkt
     * kleiner als die einzuhaltende Distanz ist.
     * @param wp ist der übergebene Wegepunkt.
     * @return true, wenn die Distanz zwischen diesem und dem Referenz-Wegepunkt
     * kleiner als die einzuhaltende Distanz ist. Andernfalls False.
     */
    @Override
    public boolean call(Waypoint wp) {
        return ref.calcDistance(wp) < dist;
    }
    
}
