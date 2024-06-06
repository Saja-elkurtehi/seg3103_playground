defmodule Calculator do
  @moduledoc """
  Simple calculator implementation.
  """

  @doc """
  Adds two numbers.
  """
  def add(a, b), do: a + b

  @doc """
  Subtracts two numbers.
  """
  def subtract(a, b), do: a - b

  @doc """
  Multiplies two numbers.
  """
  def multiply(a, b), do: a * b

  @doc """
  Divides two numbers.
  """
  def divide(a, b) when b != 0, do: a / b
  def divide(_, 0), do: {:error, "Division by zero"}

  @doc """
  Squares a number.
  """
  def square(a), do: a * a

  @doc """
  Computes the square root of a number.
  """
  def square_root(a) when a >= 0, do: :math.sqrt(a)
  def square_root(_), do: {:error, "Cannot compute square root of a negative number"}
end
