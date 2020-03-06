package ueb05;

/**
 *
 * @author Jan R. Neumann & Abdulrajman Al Bittar
 */
public class Triangle extends Figure {
    
    /**
     * Die Länge der a Seite des Dreiecks
     */
    double edgeLengthA;
    
    /**
     * Die Länge der b Seite des Dreiecks
     */
    double edgeLengthB;
    
    /**
     * Die Länge der c Seite des Dreiecks
     */
    double edgeLengthC;
    
    /**
     * Konstruktor für ein Dreieck
     * @param color Farbe des Dreiecks
     * @param a Seite a des Dreiecks
     * @param b Seite b des Dreiecks
     * @param c Seite c des Dreiecks
     */
    public Triangle (Color color, double a, double b, double c) {
        // Dem Aufruf super() werden die Parameter für den Konstruktor der
        // Elternklasse übergeben.
        super(color);
        this.edgeLengthA = a;
        this.edgeLengthB = b;
        this.edgeLengthC = c;
    }
  
     /**
     * Berechnet den Umfang des Dreiecks
     * @return Umfang des Quadrats
     */
    @Override
    public double getPerimeter() {
        return edgeLengthA + edgeLengthB + edgeLengthC;
    }
    
    /**
     * Berechnet die Fläche des Dreiecks
     * @return Fläche des Quadrats
     */
    @Override
    public double getArea() {
        //Flächenberechnung mit Formel von Heron
        double halfPerimeter = getPerimeter() / 2;
        double helper = (halfPerimeter - edgeLengthA) *
                        (halfPerimeter - edgeLengthB) *
                        (halfPerimeter - edgeLengthC);
        
        return
          Math.sqrt( halfPerimeter * helper );
    } 
    
    /**
     * Liefert eine Beschreibung des Dreiecks mit der Seitenlängen als String
     * @return Die Beschreibung des Dreiecks mit Seitenlängen als String
     */
    @Override
    public String getDescription() {
        return String.format("Dreieck  mit Kantenlängen (%6.2f, %6.2f, %6.2f),", edgeLengthA, edgeLengthB, edgeLengthC);
    }
}
