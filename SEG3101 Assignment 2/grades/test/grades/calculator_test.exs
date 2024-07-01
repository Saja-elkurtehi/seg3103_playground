defmodule Grades.CalculatorTest do
  use ExUnit.Case
  alias Grades.Calculator

  describe "percentage_grade/1" do
    test "sample" do
      assert 85 ==
               Calculator.percentage_grade(%{
                 homework: [0.8],
                 labs: [1, 1, 1],
                 midterm: 0.70,
                 final: 0.9
               })
    end

    test "1" do
      assert 45 ==
        Calculator.percentage_grade(%{ homework: [], labs: [], midterm: 0.9, final: 0.9})
    end

    test "2" do
      assert 95 ==
        Calculator.percentage_grade(%{ homework: [0.8, 0.9, 1], labs: [1, 1, 0.7], midterm: 1, final: 1})
    end

    test "3" do
      assert "EIN" ==
        Calculator.letter_grade(%{ homework: [], labs: [], midterm: 0.9, final: 0.9})
    end

    test "4" do
      assert "A+" ==
        Calculator.letter_grade(%{ homework: [1], labs: [1, 1, 1], midterm: 1, final: 1})
    end

    test "5" do
      assert "A" ==
        Calculator.letter_grade(%{ homework: [0.85], labs: [0.85, 0.85, 0.85], midterm: 0.85, final: 0.85})
    end

    test "6" do
      assert "A-" ==
        Calculator.letter_grade(%{ homework: [0.8], labs: [0.8, 0.8, 0.8], midterm: 0.8, final: 0.8})
    end

    test "7" do
      assert "B+" ==
        Calculator.letter_grade(%{ homework: [0.75], labs: [0.75, 0.75, 0.75], midterm: 0.75, final: 0.75})
    end

    test "8" do
      assert "B" ==
        Calculator.letter_grade(%{ homework: [0.7], labs: [0.7, 0.7, 0.7], midterm: 0.7, final: 0.7})
    end

    test "9" do
      assert "C+" ==
        Calculator.letter_grade(%{ homework: [0.65], labs: [0.65, 0.65, 0.65], midterm: 0.65, final: 0.65})
    end

    test "10" do
      assert "C" ==
        Calculator.letter_grade(%{ homework: [0.6], labs: [0.6, 0.6, 0.6], midterm: 0.6, final: 0.6})
    end

    test "11" do
      assert "D+" ==
        Calculator.letter_grade(%{ homework: [0.55], labs: [0.55, 0.55, 0.55], midterm: 0.55, final: 0.55})
    end

    test "12" do
      assert "D" ==
        Calculator.letter_grade(%{ homework: [0.5], labs: [0.5, 0.5, 0.5], midterm: 0.5, final: 0.5})
    end

    test "13" do
      assert "E" ==
        Calculator.letter_grade(%{ homework: [0.5], labs: [0.4, 0.4, 0.4], midterm: 1, final: 0})
    end

    test "14" do
      assert "F" ==
        Calculator.letter_grade(%{ homework: [0.45], labs: [0.4, 0.4, 0.4], midterm: 0.8, final: 0})
    end

    test "15" do
      assert 0 ==
        Calculator.numeric_grade(%{ homework: [], labs: [], midterm: 0.9, final: 0.9})
    end

    test "16" do
      assert 10 ==
        Calculator.numeric_grade(%{ homework: [1], labs: [1, 1, 1], midterm: 1, final: 1})
    end

    test "17" do
      assert 9 ==
        Calculator.numeric_grade(%{ homework: [0.85], labs: [0.85, 0.85, 0.85], midterm: 0.85, final: 0.85})
    end

    test "18" do
      assert 8 ==
        Calculator.numeric_grade(%{ homework: [0.8], labs: [0.8, 0.8, 0.8], midterm: 0.8, final: 0.8})
    end

    test "19" do
      assert 7 ==
        Calculator.numeric_grade(%{ homework: [0.75], labs: [0.75, 0.75, 0.75], midterm: 0.75, final: 0.75})
    end

    test "20" do
      assert 6 ==
        Calculator.numeric_grade(%{ homework: [0.7], labs: [0.7, 0.7, 0.7], midterm: 0.7, final: 0.7})
    end

    test "21" do
      assert 5 ==
        Calculator.numeric_grade(%{ homework: [0.65], labs: [0.65, 0.65, 0.65], midterm: 0.65, final: 0.65})
    end

    test "22" do
      assert 4 ==
        Calculator.numeric_grade(%{ homework: [0.6], labs: [0.6, 0.6, 0.6], midterm: 0.6, final: 0.6})
    end

    test "23" do
      assert 3 ==
        Calculator.numeric_grade(%{ homework: [0.55], labs: [0.55, 0.55, 0.55], midterm: 0.55, final: 0.55})
    end

    test "24" do
      assert 2 ==
        Calculator.numeric_grade(%{ homework: [0.5], labs: [0.5, 0.5, 0.5], midterm: 0.5, final: 0.5})
    end

    test "25" do
      assert 1 ==
        Calculator.numeric_grade(%{ homework: [0.5], labs: [0.4, 0.4, 0.4], midterm: 1, final: 0})
    end

    test "26" do
      assert 0 ==
        Calculator.numeric_grade(%{ homework: [0.45], labs: [0.1, 0.1, 0.1], midterm: 0.8, final: 0})
    end

  end

end