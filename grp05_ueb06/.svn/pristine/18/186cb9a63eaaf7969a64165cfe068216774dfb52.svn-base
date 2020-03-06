package ueb.list.functions;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar.
 */

/**
 * spezialisiertes Funktionsobjekt der PredicateFunctionObject-Klasse, das einen
 * Integer als Parametertyp übernimmt
 */
public class IsHarshadNumber extends PredicateFunctionObject<Integer> {
    
    /**
     * Überprüft, ob die untersuchende Zahl eine Harshard-Zahl
     * ist. Also ob die Zahl durch ihre Quersumme teilbar ist.
     * @param num ist die untersuchende Zahl.
     * @return true wenn die untersuchende Zahl eine Harshard-Zahl ist..
     *         ansonsten false. 
     */
    @Override
    public boolean call(Integer num) {
        return num > 0 ? (0 == num % calcDigitSum(num)) : false;
    }
    
    /**
     * Hilfsmethode, die die Quersummer einer übergebene Zahl berechnet
     * @param num die übergebene Zahl
     * @return  die Summe der einzelnen Ziffern
     */
    private int calcDigitSum(int num) {
        if (num < 10) {
            return num;
        } else {
            return num % 10 + calcDigitSum(num / 10);
        }
    }
}
