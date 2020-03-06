package ueb05;

/**
 *
 * @author Jan R. Neumann & Abdulrajman Al Bittar
 */
public class Grp05_ueb05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Arrays für getColor test in circ 1 & 2
        int[] legitcolorarray = {0,0,0};
        int[] nonlegitcolorarray = {0,0};
        
        //Erstellen der bereits vorhandenen Figuren
        Figure rect1 = new Rectangle(Color.BLUE, 3, 6); //BLUE
        Figure rect2 = new Rectangle(Color.getColor("lmao"), 6, 3); //unused
        Figure rect3 = new Rectangle(Color.getColor("white"), 1, 2); //WHITE
        Figure tria1 = new Triangle(Color.getColor(65280), 1, 2, 2); //LIME
        Figure tria2 = new Triangle(Color.getColor(123456), 3, 2.5, 3.5); //unused
        Figure tria3 = new Triangle(Color.getColor(0x800080), 3, 3, 4); //PURPLE
        Figure circ1 = new Circle(Color.getColor(legitcolorarray), 4); //BLACK
        Figure circ2 = new Circle(Color.getColor(nonlegitcolorarray), 3); //unused
        Figure squa1 = new Square(Color.getColor(255,0,255), 15); //FUCHSIA
        Figure squa2 = new Square(Color.getColor(12,34,56), 6); //unused

        //Erstellen der einzufügenden Figuren
        Figure insRect = new Rectangle(Color.AQUA, 3, 6); //A = 256
        Figure insTria = new Triangle(Color.SILVER, 1, 1, 1); //A = 0,43
        Figure insCirc = new Circle(Color.YELLOW, 2); //A = 3,14
        Figure insSqua = new Square(Color.NAVY, 16); //A = 18

        //Erstellen der Liste der einzufügenden Figuren
        Element insHead = new Element(insRect);
        insHead = new Element(insTria, insHead);
        insHead = new Element(insCirc, insHead);
        insHead = new Element(insSqua, insHead);
        //Erstellen der Liste der bereits vorhandenen Figuren 
        Element head = new Element(rect1);
        head = head.insert(rect2);
        head = head.insert(rect3);
        head = head.insert(tria1);
        head = head.insert(tria2);
        head = head.insert(tria3);
        head = head.insert(circ1);
        head = head.insert(circ2);
        head = head.insert(squa1);
        head = head.insert(squa2);
        
        //Hinzufügen der Elemente aus der einzufügenden Figuren Liste
        Element testElem = insHead;
        while(testElem != null) {
            head = head.insert(testElem.getFigure());
            testElem = testElem.getNext();
        }
        
        //Ausgabe
        System.out.println("Füge folgende Figuren zu:");
        System.out.println(insHead.toString());
        System.out.println("Liste neu erzeugt mit " + head.size() + " Elementen.");
        System.out.println("-------------------------------------");
        System.out.println(head.toString());
    }
    
}
