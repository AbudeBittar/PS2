
package ueb.benchmark.cases;

import ueb.list.MyList;
import ueb.list.functions.IsHarshadNumber;

/**
 *
 * @author Marcus Riemer (mri)
 */
public class FilterHarshad extends Numbers {
    
    public FilterHarshad(int numElements) {
        super(numElements, String.format("filter(isHarshad) for %8d numbers", numElements));
    }
    
    @Override
    protected void execute(MyList<Integer> list) {
        list.filterThis(new IsHarshadNumber());
    }

}
