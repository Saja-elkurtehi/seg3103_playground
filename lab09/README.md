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
[
https://github.com/Saja-elkurtehi/seg3103_playground/blob/main/lab09/assets/BenchmarkResults.txt](https://github.com/Saja-elkurtehi/seg3103_playground/blob/main/lab09/assets/BenchmarkResults.txt)
Modified Code

Calculator.java

[
](https://github.com/Saja-elkurtehi/seg3103_playground/blob/main/lab09/assets/1.png)

CalculatorBenchmark.java

[
](https://github.com/Saja-elkurtehi/seg3103_playground/blob/main/lab09/assets/2.png)
[
](https://github.com/Saja-elkurtehi/seg3103_playground/blob/main/lab09/assets/3.png)

BenchmarkRunner.java
[
](https://github.com/Saja-elkurtehi/seg3103_playground/blob/main/lab09/assets/4.png)
