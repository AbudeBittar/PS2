package ueb.list.functions;

/**
 *
 * @author  Jan R. Neumann & Abdulrahman Al Bittar.
 */

/**
 * spezialisiertes Funktionsobjekt der PredicateFunctionObject-Klasse, das einen
 * String als Parametertyp übernimmt
 */
public class IsPalindrome extends PredicateFunctionObject <String> {
    
    /**
     * Überprüft, ob der umgedrehte String gleich dem originalen String ist.
     * @param str dar übergebene String.
     * @return true, wenn der umgedrehte String gleich dem originalen String ist.
     *         Andernfalls false. (Groß- und Kleinschreibung wird hier ignoriert).
     */
    @Override
    public boolean call(String str) {
        String reversed = new String();
        //umdrehen des übergebenen Strings.
        for (int i = str.length() - 1; i >= 0; i -- ){
			reversed += str.charAt(i);
		}
        return (reversed.equalsIgnoreCase(str));
    }
    
}
