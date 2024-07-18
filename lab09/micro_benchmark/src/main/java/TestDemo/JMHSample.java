package TestDemo;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JMHSample {

    @Benchmark
    public String stringConcat(){
        String result = "";
        for (int i=0; i<1000; i++){
            result += String.valueOf(i);
        }
        return result;
    }

    @Benchmark
    public  String concatUsingStringBuilder(){
        StringBuilder result = new StringBuilder();
        for (int i=0; i<1000;i++){
            result.append(i);
        }
        return result.toString();
    }
}
