package ueb.benchmark;

/**
 * A simple way to measure time exactly once.
 * 
 * @author Marcus Riemer (mri)
 */
public class Stopwatch {
    // A time value that is guaranteed to be invalid
    private static final long INVALID_TIME = Long.MIN_VALUE;

    // The time a run was started
    private long startTime = INVALID_TIME;
    
    // The time a run was stopped.
    private long stopTime = INVALID_TIME;
    
    // Whether the watch is currently running or not
    private boolean running = false;

    /**
     * Starts the timer, may be called exactly once.
     */
    public void start() {
        assert !this.running : "Stopwatch can only be started once";
        assert this.startTime == INVALID_TIME;
        assert this.stopTime == INVALID_TIME;
        
        this.startTime = this.now();
        this.running = true;
    }

    /**
     * Stops a timer that has already been started.
     * 
     * @return The elapsed time in nanoseconds
     */
    public long stop() {
        assert this.running : "Stopwatch must be started to be stopped";
        assert this.startTime != INVALID_TIME;
        assert this.stopTime == INVALID_TIME;
        
        this.stopTime = this.now();
        this.running = false;
        
        return (this.getElapsedTime());
    }

    /**
     * Calculates the elapsed time in nanoseconds. `start()` and `stop()` must
     * both have been called exactly once.
     * 
     * @return The elapsed time in nanoseconds
     */
    public long getElapsedTime() {
        assert this.startTime != INVALID_TIME;
        assert this.stopTime != INVALID_TIME;
        assert !this.running;
        
        return (stopTime - startTime);
    }
    
    /**
     * @return A precise timestamp of the current moment.
     */
    private long now() {
        return (System.nanoTime());
    }
    
    /**
     * Handy utility to properly format a nanosecond timestamp.
     *
     * @param nanoTime The passed time (in nanoseconds)
     * @return 
     */
    public static String formatTime(long nanoTime) {
        double seconds = (double)nanoTime / 1_000_000_000.0;
        
        return (String.format("%2.4fs", seconds));
    }
}
