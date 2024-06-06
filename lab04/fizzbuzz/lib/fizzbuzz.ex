defmodule Fizzbuzz do
  @moduledoc """
  Caclulate FizzBuzz
  1
  2
  Fizz
  4
  Buzz
  Fizz
  7
  8
  Fizz
  Buzz
  11
  Fizz
  13
  14
  FizzBuzz
  """
  def print_fizzbuzz() do
    Enum.each(fizzbuzz(), & IO.puts(&1))
  end

  def fizzbuzz(), do: fizzbuzz(1, 100)

  def fizzbuzz(n) do
    cond do
      rem(n, 3) == 0 && rem(n, 5) == 0 -> "FizzBuzz"
      rem(n, 3) == 0 -> "Fizz"
      rem(n, 5) == 0 -> "Buzz"
      :else -> n
    end
  end

  def fizzbuzz(n, m), do: Enum.map(n..m, fn x -> fizzbuzz(x) end)

end
