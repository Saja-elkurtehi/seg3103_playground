defmodule TicTest do
  use ExUnit.Case
  doctest Tic

  def clean(expected), do: String.trim(expected)

  describe "new_game/1" do
    test "populate board" do
      assert %Tic{
               rows: 3,
               cols: 3,
               board: [nil, nil, nil, nil, nil, nil, nil, nil, nil],
               turn: :x
             } ==
               Tic.new_game()
    end
  end

  describe "play/2" do
    test "update board and turn" do
      t = Tic.new_game()
      {:ok, t} = Tic.play(t, 1, 1)

      assert t.board == [:x, nil, nil, nil, nil, nil, nil, nil, nil]
      assert t.turn == :o
    end

    test "error if position already taken" do
      t = Tic.new_game()
      {:ok, t} = Tic.play(t, 1, 1)
      {:error, same_t} = Tic.play(t, 1, 1)

      assert same_t.board == [:x, nil, nil, nil, nil, nil, nil, nil, nil]
      assert same_t.turn == :o
    end

    test "check all positions" do
      for {r, c, i} <- [
            {1, 1, 0},
            {1, 2, 1},
            {1, 3, 2},
            {2, 1, 3},
            {2, 2, 4},
            {2, 3, 5},
            {3, 1, 6},
            {3, 2, 7},
            {3, 3, 8}
          ] do
        {:ok, t} = Tic.new_game() |> Tic.play(r, c)
        assert Enum.at(t.board, i) == :x
      end
    end
  end

  describe "size/1" do
    test "default 3x3 = 9" do
      assert Tic.size(%Tic{}) == 9
    end

    test "set lxw" do
      assert Tic.size(%Tic{rows: 1, cols: 1}) == 1
      assert Tic.size(%Tic{rows: 2, cols: 3}) == 6
      assert Tic.size(%Tic{rows: 4, cols: 5}) == 20
    end
  end

  describe "to_string/1" do
    test "1x1" do
      assert Tic.to_string(%Tic{rows: 1, cols: 1}) == "_"
    end

    test "1xn" do
      assert Tic.to_string(%Tic{rows: 1, cols: 2}) == "_|_"
      assert Tic.to_string(%Tic{rows: 1, cols: 3}) == "_|_|_"
      assert Tic.to_string(%Tic{rows: 1, cols: 7}) == "_|_|_|_|_|_|_"
    end

    test "nx1" do
      expected = """
      _
      _
      """

      assert Tic.to_string(%Tic{rows: 2, cols: 1}) == clean(expected)

      expected = """
      _
      _
      _
      """

      assert Tic.to_string(%Tic{rows: 3, cols: 1}) == clean(expected)

      expected = """
      _
      _
      _
      _
      _
      _
      _
      """

      assert Tic.to_string(%Tic{rows: 7, cols: 1}) == clean(expected)
    end

    test "nxm" do
      expected = """
      _|_|_|_
      _|_|_|_
      _|_|_|_
      """

      assert Tic.to_string(%Tic{rows: 3, cols: 4}) == clean(expected)

      expected = """
      _|_|_
      _|_|_
      _|_|_
      _|_|_
      """

      assert Tic.to_string(%Tic{rows: 4, cols: 3}) == clean(expected)
    end

    test "default" do
      expected = """
      _|_|_
      _|_|_
      _|_|_
      """

      assert Tic.to_string(%Tic{}) == clean(expected)
    end

    test "show position" do
      expected = """
      0|1|2|3
      4|5|6|7
      8|9|10|11
      """

      assert Tic.to_string(%Tic{rows: 3, cols: 4}, show_index: true) == clean(expected)
    end

    test "show Xs and Os" do
      t = Tic.new_game()
      {:ok, t} = Tic.play(t, 2, 2)
      {:ok, t} = Tic.play(t, 3, 1)

      expected = """
      _|_|_
      _|x|_
      o|_|_
      """

      assert Tic.to_string(t) == clean(expected)
    end
  end
end
