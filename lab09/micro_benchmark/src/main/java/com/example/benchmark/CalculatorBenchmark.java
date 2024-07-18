package com.example.benchmark;

import com.example.calculator.Calculator;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Scope;

import java.util.concurrent.TimeUnit;

/**
 * JMH benchmark class for the Calculator methods.
 */
@State(Scope.Thread)
public class CalculatorBenchmark {
    private Calculator calculator = new Calculator();
    /**
     * Benchmarks the add method of the Calculator class.
     *
     * @return the result of adding 1 and 2
     */
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public int benchmarkAdd() {
        return calculator.add(1, 2);
    }
    /**
     * Benchmarks the subtract method of the Calculator class.
     *
     * @return the result of subtracting 1 from 3
     */
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public int benchmarkSubtract() {
        return calculator.subtract(3, 1);
    }
    /**
     * Benchmarks the multiply method of the Calculator class.
     *
     * @return the result of multiplying 2 and 3
     */
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public int benchmarkMultiply() {
        return calculator.multiply(2, 3);
    }
    /**
     * Benchmarks the divide method of the Calculator class.
     *
     * @return the result of dividing 4 by 2
     */
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public double benchmarkDivide() {
        return calculator.divide(4, 2);
    }
}
