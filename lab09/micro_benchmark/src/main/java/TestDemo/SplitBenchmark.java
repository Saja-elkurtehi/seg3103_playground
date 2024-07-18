package TestDemo;

import org.openjdk.jmh.annotations.*;

import java.util.regex.Pattern;

@State(Scope.Benchmark)
public class SplitBenchmark {

    private String input = "SEG3103-Lab2";

    @Benchmark
    @Fork(value = 2)
    @Measurement(iterations = 5,time=1)
    @Warmup(iterations =2, time = 1)
    public String[] benchMarkOne(){
        return  input.split("-",2);
    }

    private Pattern patternToSplit = Pattern.compile("-");


    @Benchmark
    @Fork(value = 2)
    @Measurement(iterations = 5,time=1)
    @Warmup(iterations =2, time = 1)
    public String[] benchMarkTwo(){
        return patternToSplit.split(input,2);
    }
}
