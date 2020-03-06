/**
 *  assostiert mit jedem Aufzählungswert drei Werte für die Farben rot, grün
 *   und blau.
 */
package ueb05;

/**
 *
 * @author Jan R. Neumann & Abdulrajman Al Bittar
 */

/**
 * hinter jedem Bezeichner in runden Klammern die zu assoziierenden Werte
 * angegeben (bei mehreren Werten werden diese mit Komma getrennt).
 * die Aufzählung der Bezeichner und ihrer Werte durch ein Semikolon abgeschlossen
 */
public enum Color {
    BLACK(0x00, 0x00, 0x00),
    NAVY(0x00, 0x00, 0x80),
    BLUE(0x00, 0x00, 0xFF),
    GREEN(0x00, 0x80, 0x00),
    LIME(0x00, 0xFF, 0x00),
    AQUA(0x00, 0xFF, 0xFF),
    PURPLE(0x80, 0x00, 0x80),
    SILVER(0xC0, 0xC0, 0xC0),
    RED(0xFF, 0x00, 0x00),
    FUCHSIA(0xFF, 0x00, 0xFF),
    YELLOW(0xFF, 0xFF, 0x00),
    WHITE(0xFF, 0xFF, 0xFF);


    /* the values are handled like attributes */
    /**
     * Farbwert für Rot
     */
    private final int r;

    /**
     * Farbwert für Grün
     */
    private final int g;

    /**
     * Farbwert für Blau
     */
    private final int b;

    /* there must be a public getter for each attribute */
    /**
     * Getter Methode: Farbwert für Rot
     *
     * @return Farbwert für Rot
     */
    public int getR() {
        return r;
    }

    /**
     * Getter Methode: Farbwert für Grün
     *
     * @return Farbwert für Grün
     */
    public int getG() {
        return g;
    }

    /**
     * Getter Methode: Farbwert für Blau
     *
     * @return Farbwert für Blau
     */
    public int getB() {
        return b;
    }

    /* there must be a private constructor that takes all attributes */
    /**
     * Konstruktor für die enum werte
     *
     * @param red Farbwert für Rot
     * @param green Farbwert für Grün
     * @param blue Farbwert für Blau
     */
    private Color(int red, int green, int blue) {
        this.r = red;
        this.g = green;
        this.b = blue;
    }
    //-*-*-*-*-*------------------ Methoden -------------------*-*-*-*-*-*
    
    //------------ Alle Methoden müssen ohne Änderung korrekt arbeiten,
    //------------ wenn der Enum erweitert (oder verkürzt) wird.
    
    
    
    /**
     * Erhält Referenzen auf bestimmte Color-Objekte.
     * @param red Roter Kanal.
     * @param green Grüner Kanal.
     * @param blue Blauer Kanal.
     * @return Referenz auf Bezeichner mit den gleichen Atributen
     */
    public static Color getColor(int red, int green, int blue) {
        //°°° values() ist schon in Java vorhanden, um die Attribute
        //    des Enum zugreifen zu können.
        for (Color col : Color.values()) {
            if (col.getR() == red && col.getG() == green && col.getB() == blue) {
                return col;
            }
        }
        return null;
    }

    /**
     * Erhält Referenzen auf bestimmte Color-Objekte.
     * @param colorArray das übergebene Array, das die Kanäle enthält.
     * @return Referenz auf Bezeichner mit den gleichen Attributen
     */
    public static Color getColor(int[] colorArray) {
        if (colorArray.length == 3) {
            return getColor(colorArray[0], colorArray[1], colorArray[2]);
        } else {
            return null;
        }
    }

    /**
     * Liefert Referenz auf Bezeichner mit den gleichen Attributen wie die
     * Farbwerte als gepacktes int.
     *
     * @param rgb die Farbwerte als gepacktes int
     * @return Referenz auf Bezeichner mit den gleichen Attributen
     */
    public static Color getColor(int rgb) {
        int red;
        int green;
        int blue;
        int x = rgb;
        //TODO DONE valider parameter
        //TODO2 DONE schreiben Sie einen Test für getColor(0xFF000000). Der Wert ist nicht valide!
        if(x >>> 24 != 0) {
            return null;
        } else {
        //Rauslesen von jeweils 8 Bits dann shift nach rechts (wenn nötig) zum erhalt von Farbwert
        //y shift 8 nach links für nächsten farbwert
        int ff = 255;
        //Bitwise AND (&): Berechnet die gemeinsamen Bits zwischen x und y.
        blue = x & ff;
        //Lift shift(<<): shiftet die Bits von links nach rechts 
        ff <<= 8;
        //Ziro fill right shift(>>>): shiftet die Bits von rechts nach links und 
        //füllt die Bits stattdessen mit 0.
        green = (x & ff) >>> 8;
        ff <<= 8;
        red = (x & ff) >>> 16;
        return getColor(red, green, blue);
        }
    }

    /**
     * Liefert Referenz auf enum-Wert mit der gleichen Bezeichnung wie der
     * übergebene String
     *
     * @param colorName Die gesuchte Bezeichnung des Namens
     * @return Referenz auf enum-Wert mit der gleichen Bezeichnung
     */
    public static Color getColor(String colorName) {

        for (Color col : Color.values()) {
            //°°° name() ist schon in Java vorhanden gibt den Namen
            //           des Enum-Konstanten zueück.
            //°°° equalsIgnoreCase(String anotherString) ist auch schon in Java
            //           vorhanden und arbeitet folgendermaßen:
            //*- vergleicht das String, welches durch name() entstanden wurde, mit
            // dem String, welches als ein Argument eingegeben wird und ignoriert
            // die Groß- und Kleinschreibung der beiden Strings. Wenn beide 
            // Strings gleich sind gibt true zurück anderenfalls false. 
            if (col.name().equalsIgnoreCase(colorName)) {
                return col;
            }
        }
        return null;
    }

    /**
     * Überprüft, ob die Farbwerte einem Bezeichner zuzuordnen sind.
     * @param rgb Array mit Farbwerten.
     * @return liefert true, wenn die Farbwerte einem Bezeichner zuzuordnen sind.
     */
    public static boolean isKnownColor(int[] rgb) {
        return getColor(rgb) != null;
    }

    /**
     * Überprüft, ob der Parameter einem definierten Farbbezeichner entspricht. 
     * @param colorName Der übergebene Farbenname als String.
     * @return liefert true, wenn der Parameter einem definierten 
     *         Farbbezeichner entspricht.
     * 
     * °°° Gross-/Kleinschrift darf beliebig zusammengesetzt sein 
     *     ("black" ≙ "Black" ≙ "blAck" ≙ "BLACK").
     */
    public static boolean isKnownColor(String colorName) {
        return getColor(colorName) != null;
    }

    /**
     * liefert die Werte der drei Kanäle in einem Array zurück.
     * @return ein Array, das die Werte der drei Kanäle enthält.
     */
    public int[] getRGB() {
        int[] result = new int[3];
        result[0] = getR();
        result[1] = getG();
        result[2] = getB();
        return result;
    } 

    /**
     * Liefert die Farbwerte des Enum-Wertes mit dem selben Bezeichner wie
     * der übergebene String als int Array
     * @param colorName Name des gesuchten Enum-Wertes
     * @return Farbwerte dieses Enum-Wertes als int Array
     */
    public static int[] getRGB(String colorName) {
        if (Color.isKnownColor(colorName)) {
            int[] result = new int[3];
            //C: Referenz auf enum-Wert mit der gleichen Bezeichnung
            Color C = getColor(colorName);
            result[0] = C.getR();
            result[1] = C.getG();
            result[2] = C.getB();
            return result;
        } else {
            return null;
        }
    }

    /**
     *  liefert den Farbwert gepackt in einem int-Wert.
     * @return int-Wert, der den Farbwert gepackt enthält. 
     */
    public int getPackedRGB() {
        int result;
        result = getR();
        result <<= 8;
        result += getG();
        result <<= 8;
        result += getB();
        return result;
    }

    /**
     *  liefert eine Stringdarstellung der Farbe: die Bezeichnung gefolgt von
     *  dem (gepackten) Wert der 3 Farbkanäle in Hex-Darstellung.
     * @return eine Stringdarstellung der Farbe. 
     */
    @Override
    public String toString() {
        // String.format(String format, Object... args): gibt ein formatiertes
        // String mit dem angegebenen Format-String und den  angegebenen
        // Argumenten zurück. Also arbeitet wie "printf" aber gibt nichts aus.
        return String.format("%-9s#%06X", this.name(), this.getPackedRGB());
    }
}
