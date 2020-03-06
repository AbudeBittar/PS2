package ueb05;

/**
 *
 * @author Jan R. Neumann & Abdulrajman Al Bittar
 */
public class Element {

    /**
     * Enthält die Figur dieses Elements, kann nachträglich nicht verändert werden
     */
    private final Figure figure;
    
    /**
     * Enthält eine Referenz auf das nächste Element, am Ende der Liste null
     */
    private Element nextElement;

    /**
     * Getter Methode: Figur dieses Elements
     * 
     * @return Figur dieses Elements
     */
    public Figure getFigure() {
        return this.figure;
    }

    /**
     * Getter Methode: Referenz auf das nächste Element
     * 
     * @return Referenz auf das nächste Element
     */
    public Element getNext() {
        return this.nextElement;
    }

    /**
     * Konstruktor für Element mit Referenz auf Null
     * @param fgr Figur die dieses Element enhalten soll
     */
    public Element(Figure fgr) {
        this.figure = fgr;
        this.nextElement = null;
    }

    /**
     * Konstruktor für Element mit Referenz auf übergebenes Element
     * @param fgr Figur die dieses Element enhalten soll
     * @param next Element auf das dieses Element zeigen soll
     */
    public Element(Figure fgr, Element next) {
        this.figure = fgr;
        this.nextElement = next;
    }

    /**
     * Fügt eine Figur als Element in eine Liste ein und zwar nach dem
     * nächst größeren oder gleichgroßem und vor dem nächst kleineren Element
     * @param figure Figur die eingefügt werden soll
     * @return Anfang der Liste mit eingefügtem Element
     */
    public Element insert(Figure figure) {
        // Prüft auf zulässigen Parameter
        if (figure == null) {
            return this;
        } else {
            Element newElement;
            // Prüft ob vor dem ersten Element eingefügt werden muss
            if (this.figure.compare(figure) == -1) {
                newElement = new Element(figure, this);
                return newElement;
            // Prüft ob am Ende der Liste eingefügt werden muss
            } else if (this.getNext() == null) {
                newElement = new Element(figure);
                this.nextElement = newElement;
                return this;
            // Prüft ob vor dem nächsten Element eingefügt werden muss
            } else if (this.getNext().figure.compare(figure) == -1) {
                newElement = new Element(figure, getNext());
                this.nextElement = newElement;
                return this;
            // wenn noch nicht eingefügt wurde, betrachte nächstes Element in Liste
            } else {
                this.getNext().insert(figure);
                return this;
            }
        }
    }

    /**
     * Liefert die Anzahl aller folgenden Elemente
     * 
     * @return Anzahl aller folgenden Elemente
     */
    public int size() {
        if (getNext() == null) {
            return 1;
        } else {
            return getNext().size() + 1;
        }
    }

    /**
     * Liefert die Figuren aller Elemente in einem Array
     * 
     * @return die Figuren aller Elemente in einem Array
     */
    public Figure[] getValues() {
        Figure[] figureArray = new Figure[size()];
        int i = 0;
        Element temp = this;
        while (temp != null) {
            figureArray[i] = temp.getFigure();
            i++;
            temp = temp.getNext();
        }
        return figureArray;
    }

    /**
     * Erzeugt einen String der die Liste repräsentiert mit nummerierten Zeilen
     * @param Startidx Anfang der Zeilennummerierung
     * @return String der die Liste repräsentiert mit nummerierten Zeilen
     */
    private String createNumberedString(int Startidx) {
        if (this.getNext() != null) {
            return String.format("%2d. %s%n", Startidx,
                    getFigure().toString()) + getNext().createNumberedString(Startidx + 1);
        } else {
            return String.format("%2d. %s", Startidx,
                    getFigure().toString());
        }
    }

    /**
     * Liefert die Elemente der Liste als String
     * @return Liste als String
     */
    @Override
    public String toString() {
        return createNumberedString(1);
    }

    /**
     * Vergleicht alle Elemente einer Liste auf gleichheit
     * @param obj Liste mit der this verglichen werden soll
     * @return true, wenn alle Elemente geleich sind
     */
    @Override
    public boolean equals(Object obj) {
        //Prüft ob ein übergebenes Objekt vorhanden ist
        //Liefert außerdem false im rekursiven Aufruf wenn die übergebene Liste zu kurz ist
        if (obj == null) {
            return false;
            //Prüft ob dieses Objekt ein Element ist
        } else if (obj instanceof Element) {
            Element tester = (Element) obj;
            //Prüft ob die Figur dieses Elements gleich der Figur des übergebenen Elements ist
            if (this.figure.equals(tester.getFigure())) {
                // Prüft ob, man am Ende beider Listen angekommen ist
                if (this.getNext() == null && tester.getNext() == null) {
                    return true;
                    //Prüft ob, diese Liste Zuende ist, die übergebene, aber noch Elemente hat
                } else if (this.getNext() == null && tester.getNext() != null) {
                    return false;
                    //Vergleicht die nächsten Elemente beider Listen
                } else {
                    return this.getNext().equals(tester.getNext());
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
}
