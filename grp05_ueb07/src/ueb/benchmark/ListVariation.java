
package ueb.benchmark;

/**
 * Variations of lists that need to be benchmarked.
 * 
 * @author Marcus Riemer (mri)
 */
public enum ListVariation {
    LINKED,
    LINKED_NAIVE,
    ARRAY,       // default initial elements and growth factor
    ARRAY_100_0, // 100 initial elements, growth factor 0
    ARRAY_100_2, // 100 initial elements, growth factor 2
    ARRAY_100_4, // 100 initial elements, growth factor 4
    ARRAY_NAIVE
}
