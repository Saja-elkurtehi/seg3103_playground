package com.example.benchmark;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Main class to run the JMH benchmarks for the Calculator class.
 */
public class BenchmarkRunner {

    /**
     * Main method to configure and run the benchmarks.
     *
     * @param args command-line arguments
     * @throws Exception if there is an error during benchmark execution
     */
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(CalculatorBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
