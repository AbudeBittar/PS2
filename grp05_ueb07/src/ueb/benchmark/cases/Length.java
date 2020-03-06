
package ueb.benchmark.cases;

import ueb.benchmark.Benchmark;
import ueb.list.MyList;

/**
 *
 * @author Marcus Riemer (mri)
 */
public class Length extends Benchmark<String> {
    
    private final int NUM_ELEMENTS;
    
    private final int NUM_RUNS;

    public Length(int numElements, int numRuns) {
        super(String.format("length %8d times (%5d elements)", numRuns, numElements));
        this.NUM_ELEMENTS = numElements;
        this.NUM_RUNS = numRuns;
    }

    @Override
    protected void setup(MyList<String> l) {
        for (int i = 0; i < this.NUM_ELEMENTS; i++) {
            l.append("Str");
        }
    }   

    @Override
    protected void execute(MyList<String> list) {
        for (int i = 0; i < this.NUM_RUNS; i++) {
            list.length();
        }
    }
}
