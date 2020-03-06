package ueb05;

/**
 *
 * @author Jan R. Neumann & Abdulrajman Al Bittar
 */
public class Rectangle extends Figure{
    
    /**
     * Die Länge der Seite Parallel zur X-Achse des Rechtecks
     */
    protected double edgeLengthX;
    
    /**
     * Die Länge der Seite Parallel zur Y-Achse des Rechtecks
     */
    private double edgeLengthY;
    
    /**
     * Konstruktor für das Rechteck
     * @param color Farbe des Rechtecks
     * @param x Länge der Seite Parallel zur X-Achse
     * @param y Länge der Seite Parallel zur Y-Achse
     */
    public Rectangle (Color color, double x, double y) {
        // Dem Aufruf super() werden die Parameter für den Konstruktor der
        // Elternklasse übergeben.
        super(color);
        this.edgeLengthX = x;
        this.edgeLengthY = y;
    }
    
    /**
     * Berechnet die Fläche des Rechtecks
     * @return Fläche des Rechtecks
     */
    @Override
    public double getArea() {
        return edgeLengthX * edgeLengthY;
    }
    
    /**
     * Berechnet den Umfang des Rechtecks
     * @return Umfang des Rechtecks
     */
    @Override
    public double getPerimeter() {
        return 2 * edgeLengthX + 2 * edgeLengthY;
//       return 2 * ( edgeLengthX + edgeLengthY )        
    }
    
    /**
     * Liefert eine Beschreibung des Rechtecks mit der Seitenlängen als String
     * @return Die Beschreibung des Rechtecks mit Seitenlängen als String
     */
    @Override
    public String getDescription() {
        return String.format("Rechteck mit Kantenlängen (%6.2f, %6.2f),", edgeLengthX, edgeLengthY);
    }
}
