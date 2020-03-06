package ueb.benchmark.cases;

import ueb.benchmark.Benchmark;
import ueb.list.MyList;

/**
 *
 * @author Marcus Riemer (mri)
 */
public abstract class Numbers extends Benchmark<Integer>{

    private final int NUM_ELEMENTS;

    public Numbers(int numElements, String message) {
        super(message);
        this.NUM_ELEMENTS = numElements;
    }

    @Override
    protected void setup(MyList<Integer> l) {
        for (int i = 0; i < this.NUM_ELEMENTS; i++) {
            l.append(i);
        }
    }
}
