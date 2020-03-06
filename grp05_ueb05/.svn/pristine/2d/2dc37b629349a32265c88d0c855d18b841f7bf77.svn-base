package ueb05;

/**
 *
 * @author Jan R. Neumann & Abdulrajman Al Bittar
 */
public class Figure {
    
    /**
     * Farbe der Figur
     */
    private Color color;
    
    /**
     * Konstruktor für die Farbe der Figur
     * @param color Farbe der Figur
     */
    public Figure (Color color) {
          this.color = color;
    }
    
    /**
     * Getter Methode: Fläche der Figur
     * @return Fläche der Figur oder 0 als dafault.
     */
    public double getArea(){
        assert false;
        return 0;
    }
    
    /**
     * Getter Methode: Umfang der Figur
     * @return Umfang der Figur oder 0 als dafault.
     */
    public double getPerimeter(){
        assert false;
        return 0;
    }
    
    /**
     * Liefert eine Beschreibung der Form der Figur mit Seitenlängen bzw. Durchmesser als String
     * @return Die Beschreibung der Figur mit Seitenlängen bzw. Durchmesser als String
     */
    public String getDescription() {
        assert false;
        return "";
    }
    
    /**
     * Vergleicht die Fläche zweier Figuren auf größer, kleiner oder gleich 
     * @param other die Figur mit der Verglichen werden soll
     * @return 1, wenn diese Figur größer ist
     *         -1, wenn die übergebene Figur größer ist
     *         0, wenn die Figuren gleich groß sind
     */
    public int compare(Figure other) {
        double areaA   = this.getArea();
        double areaB  = other.getArea();
        //Prüfung auf gleichheit umfangreicher, da Gleitkomma-Werte
        if(Math.abs(areaA - areaB) < 0.00001){
            return 0;
        } else if (areaA > areaB) {
            return 1;
        }
        else {
            return -1;
        }
    }
    
    /**
     * Prüft ob diese Figur die gleichen Fläche hat wie die übergebene Figur
     * @param obj die Figur mit der verglichen werden soll
     * @return true wenn die Flächen gleich sind
     */
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Figure && this.compare((Figure) obj) == 0);
    }
    
    /**
     * Liefert die Figur mit allen Details als Stringdarstellung
     * @return Figur als Stringdarstellung
     */
    @Override
    public String toString() {
            return String.format("%-16s %-52s Umfang: %6.2f, Fläche: %6.2f",
                    color != null ? color.toString() : "unused", getDescription(),
                    getPerimeter(), getArea());
    }
    
}
