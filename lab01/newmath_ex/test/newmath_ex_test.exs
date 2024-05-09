defmodule NewmathExTest do
  use ExUnit.Case
  doctest NewmathEx

  describe "div/1" do
    test "ok" do
      assert NewmathEx.div(4, 2) == {:ok, 2}
    end

    test "by zero" do
      assert NewmathEx.div(4, 0) == {:error, "Cannot divide by zero"}
    end
  end
end
