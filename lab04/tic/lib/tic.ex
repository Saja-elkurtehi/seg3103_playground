defmodule Tic do
  @moduledoc """
  Implementing a tic tac toe game.
  """

  defstruct rows: 3, cols: 3, board: nil, turn: :x

  @doc """
  Start a new game, and X goes first
  """
  def new_game() do
    rows = 3
    cols = 3
    board = Enum.map(1..(rows * cols), fn _ -> nil end)
    %Tic{rows: rows, cols: cols, board: board, turn: :x}
  end

  @doc """
  Play in a particular position
  """
  def play(%Tic{} = game, row, column) do
    i = (row - 1) * game.cols + (column - 1)

    cond do
      is_nil(Enum.at(game.board, i)) ->
        game
        |> Map.put(:board, List.replace_at(game.board, i, game.turn))
        |> Map.put(:turn, next_turn(game.turn))
        |> then(&{:ok, &1})

      :else ->
        {:error, game}
    end
  end

  def size(%Tic{rows: r, cols: w}), do: r * w

  @doc """
  Create a string to represent the board
  """
  def to_string(%Tic{rows: n, cols: m, board: board}, opts \\ []) do
    0..(n - 1)
    |> Enum.map(fn row_index -> to_string_column(board, row_index, m, opts[:show_index]) end)
    |> Enum.join("\n")
  end

  def print({_, game}), do: print(game)

  def print(%Tic{} = game) do
    IO.puts(Tic.to_string(game))
    game
  end

  defp to_string_column(board, row_index, num_columns, show_index) do
    0..(num_columns - 1)
    |> Enum.map(fn col_index ->
      to_string_cell(board, row_index * num_columns + col_index, show_index)
    end)
    |> Enum.join("|")
  end

  defp to_string_cell(board, index, show_index) do
    cond do
      show_index ->
        "#{index}"

      is_nil(board) ->
        "_"

      :else ->
        Enum.at(board, index) || "_"
    end
  end

  defp next_turn(:x), do: :o
  defp next_turn(:o), do: :x
end
