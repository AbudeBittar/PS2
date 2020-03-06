package ueb.benchmark.cases;

import ueb.benchmark.Benchmark;
import ueb.list.MyList;
import ueb.list.functions.IsHarshadNumber;

/**
 *
 * @author Marcus Riemer (mri)
 */
public class AnyHarshad extends Numbers {

    public AnyHarshad(int numElements) {
        super(numElements, String.format("exists(isHarshad) for %8d numbers", numElements));
    }

    @Override
    protected void execute(MyList<Integer> list) {
        list.exists(new IsHarshadNumber());
    }
}
