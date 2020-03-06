package ueb.benchmark;

/**
 * Bundles results of a certain benchmark run. The stored values may never
 * change after they have been assigned initially.
 *
 * @author Marcus Riemer (mri)
 */
public class BenchmarkResult {

    private final String benchName;
    
    private final ListVariation variation;

    private final long[] times;

    /**
     * Stores the given times and the given name.
     *
     * @param benchName A human readable name that describes the nature of these
     * times.
     * @param variation The list variation that was used to run this benchmark.
     * @param times The benchmarked time series, each entry is a duration in
     * nanoseconds. Must have at least one element and no element may be
     * negative.
     */
    public BenchmarkResult(String benchName, ListVariation variation, long[] times) {
        assert (times != null && times.length > 0);

        for (int i = 0; i < times.length; i++) {
            assert times[i] >= 0;
        }

        this.benchName = benchName;
        this.variation = variation;
        this.times = times;
    }

    /**
     * @return A human readable name that describes the nature of these times.
     */
    public String getBenchName() {
        return benchName;
    }

    /**
     * Calculates the arithmetic mean of the stored times.
     *
     * @return The arithmetic mean of the stored times.
     */
    public long getAverage() {
        long sum = 0;
        for (int i = 0; i < times.length; i++) {
            sum += times[i];

        }

        return (sum / times.length);
    }

    /**
     * Computes the middle value separating the greater and lesser halves of the
     * times. If the number of times is even, the larger of the two possible
     * values is returned.
     *
     * @return Middle value separating the greater and lesser halves of the
     * times.
     */
    public long getMedian() {
        return (this.times[(int)Math.ceil(times.length / 2)]);
    }

    @Override
    public String toString() {
        return String.format(
                "%-40s [%-15s] AVG: %s MED: %s",
                getBenchName(), 
                variation,
                Stopwatch.formatTime(getAverage()), 
                Stopwatch.formatTime(getMedian())
        );
    }
}
