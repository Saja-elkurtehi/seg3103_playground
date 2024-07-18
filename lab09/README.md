# Lab 09 - Microbenchmarking



## Dependencies
Ensure the `pom.xml` includes the following dependencies for JMH:

```xml
<dependencies>
    <dependency>
        <groupId>org.openjdk.jmh</groupId>
        <artifactId>jmh-core</artifactId>
        <version>1.33</version>
    </dependency>
    <dependency>
        <groupId>org.openjdk.jmh</groupId>
        <artifactId>jmh-generator-annprocess</artifactId>
        <version>1.33</version>
    </dependency>
</dependencies>


Screenshot of Terminal Output
Terminal Output

Description: This screenshot shows the terminal output after running the JMH benchmarks, displaying the performance metrics for each calculator method.
Modified Code
Calculator.java

Calculator.java

Description: A simple calculator class that provides basic arithmetic operations like addition, subtraction, multiplication, and division.
CalculatorBenchmark.java

CalculatorBenchmark.java (Part 1)

Description: JMH benchmark class for the Calculator methods, benchmarking add, subtract, multiply, and divide methods using the @BenchmarkMode decorator.
CalculatorBenchmark.java (Part 2)

BenchmarkRunner.java

BenchmarkRunner.java

Description: Main class to run the JMH benchmarks for the Calculator class, configuring and executing the benchmarks.
