defmodule NewmathEx do
  @moduledoc """
  A module for doing new math.
  """

  @doc """
  Divide the numerator (num) by the denominator (dem)

  ## Examples

      iex> NewmathEx.div(10, 4)
      {:ok, 2.5}

  """
  def div(_num, 0), do: {:error, "Cannot divide by zero"}
  def div(num, dem), do: {:ok, num / dem}
end
