package ueb05;

/**
 *
 * @author Jan R. Neumann & Abdulrajman Al Bittar
 */
public class Square extends Rectangle {

        
    /**
     * Konstruktor für ein Quadrat
     * @param color Farbe des Quadrats
     * @param length Die Länge einer Seite des Quadrats
     */
    public Square (Color color, double length) {
        // Dem Aufruf super() werden die Parameter für den Konstruktor der
        // Elternklasse übergeben.
        super(color, length, length);
//        this.edgeLength = length;
    }
    

    /**
     * Liefert eine Beschreibung des Quadrats mit der Seitenlänge als String
     * @return Die Beschreibung des Quadrats mit Seitenlänge als String
     */
    @Override
    public String getDescription() {
        return String.format("Quadrat  mit Kantenlänge  (%6.2f),", super.edgeLengthX);
    }
        
}
