package ueb.benchmark.cases;

import ueb.list.MyList;
import ueb.list.functions.IsHarshadNumber;

/**
 *
 * @author Marcus Riemer (mri)
 */
public class ForAllHarshad extends Numbers {

    public ForAllHarshad(int numElements) {
        super(numElements, String.format("forAll(isHarshad) for %8d numbers", numElements));
    }

    @Override
    protected void execute(MyList<Integer> list) {
        list.forAll(new IsHarshadNumber());
    }
}
