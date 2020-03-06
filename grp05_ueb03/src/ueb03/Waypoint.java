/**
 * Wird einen Wegepunkt durch eine Instanz dieser Klasse dargestelt. 
 */
package ueb03;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar
 */
public class Waypoint {
    /**
     * X & Y Koordinaten des Wegpunkts
     */
    private int x;
    private int y;
    
    /**
     * Getter methode für X Koordinate
     * @return wert von x
     */
   public int getX() {
        return x;
    }
    
   /**
    * Getter methode für Y Koordinate
     * @return wert von y
    */
    public int getY() {
        return y;
    }
    
    /**
     * Setter methode für X & Y Koordinate 
     * @param x der X-Wert der gesetzt werden soll
     * @param y der Y-Wert der gesetzt werden soll
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Berechnet die Distanz zu einem Übergebenen Wegpunkt
     * @param other Der übergebene Wegpunkt zu dem die Distanz berechnet werden soll.
     * @return die Distanz zwischen den Wegpunkten als double
     */
    public double calcDistance(Waypoint other){
        return ( Math.sqrt(Math.pow(other.getX() - getX(), 2)
                         + Math.pow(other.getY() - getY(), 2)));
    }
    
    /**
     * Vergleicht den Wegpunkt auf gleiche Koordinaten mit einem übergebenen Wegpunkt
     * @param other Der übergebene Wegpunkt der verglichen werden soll.
     * @return true, wenn die Koordinaten gleich sind.  
     */
    public boolean isEqual(Waypoint other){
        if(other == null) {
            return false;
        } else {
            return (other.getX() == getX() && other.getY() == getY());
        }
     
    }
    
    /**
     * Baut ein eindimensionales Array aus dem Wegpunkt
     * @return Wegpunkt als eindimensionales Array
     */
    public int[] toArray(){
//       int[] WaypointToArray = new int [2] ;
//       //X- und Y-Werte zuordnen.
//       WaypointToArray[0] = getX();
//       WaypointToArray[1] = getY();
//          
//           return WaypointToArray;
           return new int[]{getX(), getY()};
       }
    
    /**
     * Baut einen String aus dem Wegpunkt, nach dem Schema "(X/Y)" (ohne Anführungszeichen)
     * @return Wegpunkt als Stringdarstellung
     */
    public String toString(){
          return "(" + getX() + "/" + getY() + ")";
       }
    
}
