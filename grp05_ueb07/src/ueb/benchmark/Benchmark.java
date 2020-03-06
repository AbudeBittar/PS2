package ueb.benchmark;

import ueb.list.MyList;
import ueb.list.array.MyCapacityArrayList;
import ueb.list.array.MyNaiveArrayList;
import ueb.list.linked.MyLinkedList;
import ueb.list.linked.MyNaiveLinkedList;

/**
 * Base class to perform a benchmark on a specific set of lists. The methods
 * "setup" and "execute" are expected to be overridden. The time it takes
 * to run "execute" is measured.
 *
 * The list that is passed into "execute" is exactly the list as prepared by
 * "createList" and "setup". Benchases may prepare the benchmarked list in any 
 * way the require it to properly measure the execution time in "execute". This
 * is especially important for benchcases
 *
 * @author Marcus Riemer (mri)
 */
public abstract class Benchmark<E> {

    // The number of times the `execute` method is called and sampled.
    private final int numRuns = 5;
    
    private final ListVariation[] variations;

    // A user friendly description of this run.
    private final String name;

    /**
     * Constructs a new benchmark with a given name for all list variations.
     *
     * @param name A user friendly description of this run.
     */
    protected Benchmark(String name) {
        this(name, ListVariation.values());
    }
    
    /**
     * Constructs a new benchmark with a given name for the given list
     * variations.
     * 
     * @param name A user friendly description of this run.
     * @param variations The variations to run this benchmark against.
     */
    protected Benchmark(String name, ListVariation... variations) {
        this.name = name;
        this.variations = variations;
    }

    /**
     * Prepares a list that is a valid starting point for subsequent calls to
     * execute. The execution time of this method is not measured!
     *
     * @param l The list to prepare.
     */
    protected void setup(MyList<E> l) {

    }

    /**
     * Constructs a linked list that is a valid starting point for subsequent
     * calls to execute. The execution time of this method is not measured!
     *
     * @param variation The variation to create.
     * @return An empty list of the desired variation.
     */
    protected MyList<E> createList(ListVariation variation) {
        switch (variation) {
            case LINKED:
                return (new MyLinkedList<>());
            case LINKED_NAIVE:
                return (new MyNaiveLinkedList<>());
            case ARRAY:
                return (new MyCapacityArrayList<>());
            case ARRAY_100_0:
                return (new MyCapacityArrayList<>(100, 0));
            case ARRAY_100_2:
                return (new MyCapacityArrayList<>(100, 2));
            case ARRAY_100_4:
                return (new MyCapacityArrayList<>(100, 4));
            case ARRAY_NAIVE:
                return (new MyNaiveArrayList<>());
            default:
                assert false : "Unknown List variation: " + variation;
                return null;
        }
    }

    /**
     * Performs operations on the given list instance. The execution time for
     * this method is measured by the "run" method.
     *
     * @param list
     */
    protected abstract void execute(MyList<E> list);

    /**
     * Executes this benchcase and collects the results.
     *
     * @return Median and Average execution times of this run.
     */
    public BenchmarkResult[] run() {
        BenchmarkResult[] results = new BenchmarkResult[variations.length];

        // Every variation has its own result
        for (int v = 0; v < variations.length; ++v) {
            long[] times = new long[this.numRuns];

            // Run the case multiple times to accomodate for different load
            // scenarios of the host system.
            for (int i = 0; i < this.numRuns; i++) {
                Stopwatch watch = new Stopwatch();

                // Create the list and set it up
                MyList<E> list = this.createList(variations[v]);
                this.setup(list);

                // Hotspot: Execute with as little surrounding code as possible
                watch.start();
                this.execute(list);
                times[i] = watch.stop();
            }

            results[v] = new BenchmarkResult(name, variations[v], times);
        }

        return (results);

    }
}
