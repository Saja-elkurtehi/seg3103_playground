defmodule CalculatorTest do
  use ExUnit.Case
  doctest Calculator

  test "add/2" do
    assert Calculator.add(1, 2) == 3
  end

  test "subtract/2" do
    assert Calculator.subtract(5, 3) == 2
  end

  test "multiply/2" do
    assert Calculator.multiply(2, 3) == 6
  end

  test "divide/2" do
    assert Calculator.divide(6, 3) == 2
  end

  test "divide/2 returns error for division by zero" do
    assert Calculator.divide(5, 0) == {:error, "Division by zero"}
  end

  test "square/1" do
    assert Calculator.square(4) == 16
    assert Calculator.square(-3) == 9
  end

  test "square_root/1" do
    assert Calculator.square_root(9) == 3.0
    assert Calculator.square_root(0) == 0.0
  end

  test "square_root/1 returns error for negative input" do
    assert Calculator.square_root(-4) == {:error, "Cannot compute square root of a negative number"}
  end

  test "add/2 with negative numbers" do
    assert Calculator.add(-1, -2) == -3
  end

  test "subtract/2 with result zero" do
    assert Calculator.subtract(3, 3) == 0
  end

end
