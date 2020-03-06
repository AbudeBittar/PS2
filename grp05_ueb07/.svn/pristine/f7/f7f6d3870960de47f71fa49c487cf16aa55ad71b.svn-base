
package ueb.benchmark.cases;

import ueb.benchmark.Benchmark;
import ueb.list.MyList;

/**
 *
 * @author Marcus Riemer (mri)
 */
public class SizeAfterInsertAtFront extends Benchmark<String> {
    
    private final int NUM_ELEMENTS;

    public SizeAfterInsertAtFront(int numElements) {
        super(String.format("length %8d times (front)", numElements));
        this.NUM_ELEMENTS = numElements;
    }

    @Override
    protected void execute(MyList<String> list) {
        for (int i = 0; i < this.NUM_ELEMENTS; i++) {
            list.insertAtFront("Str");
            list.length();
        }
    }
}
