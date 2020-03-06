
package ueb.benchmark;

import ueb.benchmark.cases.*;

/**
 * Runs a set of benchmarks against multiple list implementations.
 * 
 * @author Marcus Riemer (mri)
 */
public class RunBenchmark {
    public static void main(String[] args) {
        Benchmark[] cases = {
            new Append(100),
            new InsertAtFront(100),
            new Append(1_000),
            new InsertAtFront(1_000),
            new Append(10_000),
            new InsertAtFront(10_000),
            new Length(100, 500),
            new Length(1_000, 500),
            new Length(10_000, 500),
            new FilterHarshad(1_00),
            new FilterHarshad(1_000),
            new FilterHarshad(5_000),  //verringert, damit kein StackOverflow
            new AnyHarshad(1_00),
            new AnyHarshad(1_000),
            new AnyHarshad(10_000),
            new ForAllHarshad(1_00),
            new ForAllHarshad(1_000),
            new ForAllHarshad(10_000),
        };
        
        for (Benchmark curr : cases) {
            BenchmarkResult[] results = curr.run();
            for (BenchmarkResult result : results) {
                System.out.println(result);
                System.out.flush();
            }
        }
    }
}
