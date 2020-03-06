
package ueb.benchmark.cases;

import ueb.benchmark.Benchmark;
import ueb.list.MyList;

/**
 *
 * @author Marcus Riemer (mri)
 */
public class InsertAtFront extends Benchmark<String> {
    
    private final int NUM_ELEMENTS;

    public InsertAtFront(int numElements) {
        super(String.format("Insert %8d strings at front", numElements));
        this.NUM_ELEMENTS = numElements;
    }

    @Override
    protected void execute(MyList<String> list) {
        for (int i = 0; i < this.NUM_ELEMENTS; i++) {
            list.insertAtFront("Str");
        }
    }
}
