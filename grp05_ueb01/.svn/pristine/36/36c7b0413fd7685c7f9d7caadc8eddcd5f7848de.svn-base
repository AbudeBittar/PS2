package ueb01;

/**
 *
 * @author Jan Robert Neumann & Abdulrahman Al Bittar
 */
public class Grp05_ueb01 {

    /**
     * Addiert die einzelnen Ziffern unserer Zahl
     *
     * @param zahl ist die untersuchende Zahl
     * @return die Summe der einzelnen Ziffern, auch bei negativen Zahlen
     */
    public static int calculateDigitSum(int zahl) {
        // return Wert, Anfangswert ist 0, weil 0 keinen Einfluss auf den Prozess der Addition hat.
        int digitsum = 0;

        //Konvertierung in den positiven Zahlenbereich.
        if (zahl < 0) {
            zahl *= (-1);
        }
        // Der Prozess der Addition der einzelnen Zahlen, wenn die Zahl mehrere Ziffern hat.
        if (zahl > 9) {
            while (zahl >= 1) {
                digitsum += zahl % 10;
                zahl /= 10;
            }
        } // Wenn die Zahl kleiner als 9 ist, dann hat die Zahl nur einen Ziffer
        else {
            return zahl;
        }
        return digitsum;
    }

    /**
     * Überprüft, ob die untersuchende Zahl eine Harshard-Zahl
     * ist. Also ob die Zahl durch ihre Quersumme teilbar ist.
     *
     * @param zahl ist die untersuchende Zahl
     * @return true wenn die untersuchende Zahl eine Harshard-Zahl ist..
     * ansonsten false.
     */
    public static boolean isHarshadNum(int zahl) {
        // q ist die Quersumme der untersuchenden Zahl
        int q = calculateDigitSum(zahl);
        return (zahl != 0 && zahl % q == 0);
    }

    /**
     * Diese Methode zählt nach wie vielen Schritten der ganze Prozess die
     * Collatz-Folge zur 1 berechnet hat.
     *
     * @param zahl ist die untersuchende Zahl.
     * @return Der Zähler, für negative Zahlen -1
     */
    public static int collatzSequece(int zahl) {
        // counter ist der Zäller der Schritte 
        int counter = 0;
        if (zahl <= 0) {
            counter = -1;
        }
        while (zahl > 1) {
            if (zahl % 2 == 0) {
                zahl /= 2;
                counter++;
            }
            else if (zahl % 2 == 1 ){
                zahl = ( zahl * 3 ) + 1; 
                counter++;
            }
              
        }
        
        return counter;
    }

    /**
     * Diese Methode überprüft, ob der Schlüssel zulässig ist
     *
     * @param zahl ist die untersuchende Zahl
     * @return true wenn der untersuchende Schlüssel zulässig ist.. ansonsten
     * false.
     */
    public static boolean isValidKey(int zahl) {
        // Verschiebung der Bits um 8 Stellen
        int shiftZahl = zahl >>> 8;
        return (calculateDigitSum(shiftZahl) == 0);
    }

    /**
     * Diese Methode verschlüsselt mit Hilfe von XOR-Verschlüsselung
     *
     * @param zahl ist die untersuchende Zahl.
     * @param key der Schlüssell.
     * @return der verschlüsselte Zahl
     */
    public static int encode(int zahl, int key) {
        // moddedKey haben wir benutzt, 
        //um den Schlüssel für die XOR-Verschlüsselung zu modifizieren.
        int moddedKey = key;
        // i ist der Zähler der while-Schleiffe
        int i = 1;
        // die 4 steht für 32 bits 
        while (i < 4) {
            moddedKey <<= 8;
            moddedKey += key;
            i++;
        }
        // erg ist das Ergibniss der Verschlüsselung.
        int erg = zahl ^ moddedKey;
        return erg;
    }

    /**
     * Diese Methode wandelt die Dezimalzahl in die binäre Zahl um.
     * Die Binärzahl wird in einem String dargestellt.
     * @param zahl ist die untersuchende Zahl
     * @return String mit binärer Zahl
     */
    public static String getBinaryString(int zahl) {
        //s ist der Anfangswert des Strings
        String s = "";
        while (zahl > 0) {
            //
            s = ((zahl % 2) == 0 ? "0" : "1") + s;
            zahl = zahl / 2;
        }
        if (zahl < 0){
            zahl = zahl * (-1) - 1;  // Man kann auch den Operator ~zahl benutzen.
            for (int i = 0; i < 32; i++) {
            s = (((zahl % 2) == 0) || (zahl == 0) ? "1" : "0") + s;
            zahl = zahl / 2;
            }
        }
        return s;
    }

    /**
     * Diese Methode ist die Hauptmethode des Programms und behandelt die
     * Ausgabe.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Start-Konstante der untersuchenden Folge 
        final int START = -1;
        // Ende-Konstante der untersuchenden Folge 
        final int END = 4;
        // Konstante des Schlüssels
        final int KEY = 0;

        // Ausgabe der Folge aller Fälle
        System.out.println("Untersucht werden die Zahlen zwischen " + START + " und " + END + ".");
        //TODO DONE nur die sich unterscheidenden Ausgaben per if
        // Ausgabe falls der verwendete Schlüssel zulässig ist.
        if (isValidKey(KEY)) {
            System.out.println("Schlüssel = " + getBinaryString(KEY) + "(" + KEY + ")");
        }
        //Ausgabe falls der verwendete Schlüssel nicht zulässig ist.
        else {
            System.out.printf("WARNUNG: Verschlüsselung nicht möglich, ungültiger Schlüssel = "
                    + getBinaryString(KEY) + " (" + KEY + ")\n");
        }
            for (int i = START; i <= END; i++) {
                System.out.printf("%3d: Quersumme = %2d"
                    + (collatzSequece(i) == (-1) ? "" : ", Collatz-Schritte = %3d") 
                    + (isHarshadNum(i) ? ", Hashard-Zahl\n" : "\n"),
                    i, calculateDigitSum(i), collatzSequece(i));
               
                if (isValidKey(KEY)){
                    System.out.printf("     Verschlüsselung = %32s"
                    + " (%11d)\n", getBinaryString(encode(i, KEY)), encode(i, KEY));
                }
            }
 


       

    }
}
