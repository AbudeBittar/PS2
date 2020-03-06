
package ueb.list.functions;

/**
 * A function object that determines whether a specific number is greater or
 * a smaller then a reference number. This is primarily useful as a parameter
 * for a "filter" method. 
 * 
 * @author Marcus Riemer (mri)
 */
public class IsGreater extends PredicateFunctionObject<Integer> {
    // The value to compare against
    private final int ref;

    /**
     * Stores a value for later comparison.
     * 
     * @param ref Any value passed to call is checked against this number.
     */
    public IsGreater(int ref) {
        this.ref = ref;
    }

    /**
     * @param value A value to compare against the referenced number.
     * @return True, if value is greater than the referenced number.
     */
    @Override
    public boolean call(Integer value) {
        return (value > ref);
    }   
}
