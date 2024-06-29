defmodule Calculator do
  def grade_student(homework, exams, labs) do
    avg_homework = avg(homework)
    avg_exams = avg(exams)
    avg_labs = avg(labs)

    if failed_to_participate?(avg_homework, avg_exams, num_labs(labs)) do
      :fail
    else
      calculate_grade(avg_labs, avg_homework, midterm, final)
    end
  end

  defp avg(grades) do
    if Enum.count(grades) == 0 do
      0
    else
      Enum.sum(grades) / Enum.count(grades)
    end
  end

  defp failed_to_participate?(avg_homework, avg_exams, labs_count) do
    avg_homework < 0.4 || avg_exams < 0.4 || labs_count < 3
  end

  defp calculate_grade(avg_labs, avg_homework, midterm, final) do
    0.2 * avg_labs + 0.3 * avg_homework + 0.2 * midterm + 0.3 * final
  end

  defp num_labs(labs), do: Enum.count(labs)
end
