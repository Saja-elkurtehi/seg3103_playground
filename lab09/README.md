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
https://github.com/Saja-elkurtehi/seg3103_playground/blob/main/lab09/assets/BenchmarkResults.txt
Description: This screenshot shows the terminal output after running the JMH benchmarks, displaying the performance metrics for each calculator method.
Modified Code
Calculator.java
https://github.com/Saja-elkurtehi/seg3103_playground/blob/main/lab09/assets/1.png

Description: A simple calculator class that provides basic arithmetic operations like addition, subtraction, multiplication, and division.
CalculatorBenchmark.java

https://github.com/Saja-elkurtehi/seg3103_playground/blob/main/lab09/assets/2.png

https://github.com/Saja-elkurtehi/seg3103_playground/blob/main/lab09/assets/3.png
Description: JMH benchmark class for the Calculator methods, benchmarking add, subtract, multiply, and divide methods using the @BenchmarkMode decorator.


BenchmarkRunner.java
https://github.com/Saja-elkurtehi/seg3103_playground/blob/main/lab09/assets/4.png




Description: Main class to run the JMH benchmarks for the Calculator class, configuring and executing the benchmarks.
