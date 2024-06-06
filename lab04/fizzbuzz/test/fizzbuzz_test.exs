defmodule FizzbuzzTest do
  use ExUnit.Case
  doctest Fizzbuzz

  describe "fizzbuzz/0" do
    test "fizzbuzz(1,100)" do
    assert Fizzbuzz.fizzbuzz() == Fizzbuzz.fizzbuzz(1, 100)
    end
  end

  describe "fizzbuzz/2" do

    test "1 fizzbuzz" do
      assert [1] == Fizzbuzz.fizzbuzz(1,1)
      assert [2] == Fizzbuzz.fizzbuzz(2,2)
      assert ["Fizz"] == Fizzbuzz.fizzbuzz(3,3)
      assert ["Buzz"] == Fizzbuzz.fizzbuzz(5,5)
    end

    test "all fizzbuzz between n et m" do
      assert [1,2,"Fizz",4,"Buzz"] == Fizzbuzz.fizzbuzz(1,5)
      assert [14,"FizzBuzz",16] == Fizzbuzz.fizzbuzz(14,16)
    end

  end

  describe "fizzbuzz/1" do
    test "1 returns 1" do
      assert 1 == Fizzbuzz.fizzbuzz(1)
    end

    test "2 returns 2" do
      assert 2 == Fizzbuzz.fizzbuzz(2)
    end

    test "non %3 et $5 returns n" do
      assert 98 == Fizzbuzz.fizzbuzz(98)
      assert 49 == Fizzbuzz.fizzbuzz(49)
    end

    test "% 3 returns Fizz" do
      assert "Fizz" == Fizzbuzz.fizzbuzz(3)
      assert "Fizz" == Fizzbuzz.fizzbuzz(6)
      assert "Fizz" == Fizzbuzz.fizzbuzz(9)
      assert "Fizz" == Fizzbuzz.fizzbuzz(99)
    end

    test "% 5 returns Buzz" do
      assert "Buzz" == Fizzbuzz.fizzbuzz(5)
      assert "Buzz" == Fizzbuzz.fizzbuzz(10)
      assert "Buzz" == Fizzbuzz.fizzbuzz(95)
      assert "Buzz" == Fizzbuzz.fizzbuzz(100)
    end

    test "% 3 et % 5 returns FizzBuzz" do
      assert "FizzBuzz" == Fizzbuzz.fizzbuzz(15)
      assert "FizzBuzz" == Fizzbuzz.fizzbuzz(30)
      assert "FizzBuzz" == Fizzbuzz.fizzbuzz(45)
      assert "FizzBuzz" == Fizzbuzz.fizzbuzz(90)
    end

  end

end
