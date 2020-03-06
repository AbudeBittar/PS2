package ueb05;

/**
 *
 * @author Jan R. Neumann & Abudé Bittar
 */
public class Circle extends Figure {
    
    /**
     * Der Durchmesser des Kreis
     */
    double diameter;
    
    /**
     * Konstruktor für ein Kreis
     * @param color Farbe des Kreis
     * @param diameter Durchmesser des Kreis
     */
    public Circle (Color color, double diameter) {
        // Dem Aufruf super() werden die Parameter für den Konstruktor der
        // Elternklasse übergeben.
        super(color);
        this.diameter = diameter;
    }
    
    /**
     * Berechnet die Fläche des Kreis
     * @return Fläche des Kreis
     */
    @Override
    public double getArea() {
        // Area = π * r^2
        return (Math.PI * Math.pow(diameter, 2)) / 4;
    }
    
    /**
     * Berechnet den Umfang des Kreis
     * @return Umfang des Kreis
     */
    @Override
    public double getPerimeter() {
        return Math.PI * diameter;
    }
    
    /**
     * Liefert eine Beschreibung des Kreis mit Durchmesser als String
     * @return Die Beschreibung des Kreis mit Durchmesser als String
     */
    @Override
    public String getDescription() {
        return String.format("Kreis    mit Durchmesser  (%6.2f),", diameter);
    }
}
