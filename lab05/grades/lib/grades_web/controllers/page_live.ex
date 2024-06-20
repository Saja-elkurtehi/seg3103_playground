defmodule GradesWeb.PageLive do
  use GradesWeb, :live_view
  alias Grades.Calculator

  @impl true
  def mount(_params, _session, socket) do
    socket
    |> assign_grades()
    |> my_reply(:ok)
  end

  @impl true
  def handle_event("calculate", fields, socket) do
    grades = %{
      homework: lookup(fields, "h", socket.assigns[:num_homeworks]),
      labs: lookup(fields, "l", socket.assigns[:num_labs]),
      midterm: fields["midterm"],
      final: fields["final"]
    }

    socket
    |> assign(:grades, grades)
    |> assign(:letter_grade, Calculator.letter_grade(grades))
    |> assign(:percentage_grade, Calculator.percentage_grade(grades))
    |> assign(:numeric_grade, Calculator.numeric_grade(grades))
    |> my_reply(:noreply)
  end

  def label_input(assigns) do
    ~H"""
    <div class="rounded-md px-3 pb-1.5 pt-2.5 shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-indigo-600">
      <label for={@id} class="block text-xs font-medium text-gray-900">
        <%= @label %>
      </label>
      <input
        type="text"
        name={@id}
        id={@id}
        class="block w-full border-0 p-0 text-gray-900 placeholder:text-gray-400 focus:ring-0 sm:text-sm sm:leading-6"
        value={@value}
      />
    </div>
    """
  end

  def label_output(assigns) do
    ~H"""
    <div class="rounded-md px-3 pb-1.5 pt-2.5 shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-indigo-600">
      <label for={@id} class="block text-xs font-medium text-gray-900">
        <%= @label %>
      </label>
      <input
        type="text"
        name={@id}
        id={@id}
        class="block w-full border-0 p-0 text-gray-900 placeholder:text-gray-400 focus:ring-0 sm:text-sm sm:leading-6"
        disabled
        value={@value}
      />
    </div>
    """
  end

  @impl true
  def render(assigns) do
    ~H"""
    <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
      <div class="mx-auto max-w-3xl">
        <h1 class="text-4xl font-bold mt-10">Grades</h1>
        <.form for={nil} phx-submit="calculate" class="mt-4">
          <div class="grid grid-cols-3 gap-x-4 items-top">
            <div class="grid grid-cols-1 gap-y-4">
              <%= for n <- 1..@num_homeworks do %>
                <.label_input
                  id={"h#{n}"}
                  label={"Homework ##{n}"}
                  value={Enum.at(@grades[:homework], n - 1, nil)}
                />
              <% end %>
              <.label_input id="midterm" label="Midterm" value={@grades[:midterm]} />
              <.label_input id="final" label="Final" value={@grades[:final]} />
            </div>
            <div class="grid grid-cols-1 gap-y-4">
              <%= for n <- 1..@num_labs do %>
                <.label_input
                  id={"l#{n}"}
                  label={"Labs ##{n}"}
                  value={Enum.at(@grades[:labs], n - 1, nil)}
                />
              <% end %>
            </div>
            <div>
              <h2 class="text-2xl font-bold">Final Grade</h2>

              <div class="grid grid-cols-1 gap-y-4 mt-4">
                <.label_output id="letter_grade" label="Letter Grade" value={@letter_grade} />
                <.label_output id="numeric_grade" label="Numeric Grade" value={@numeric_grade} />
                <.label_output id="percent" label="Percent" value={@percentage_grade} />
              </div>

              <div class="mt-10">
                <button
                  type="submit"
                  phx-disable-with="Calculating..."
                  class="rounded-md bg-indigo-600 px-3.5 py-2.5 w-full text-sm font-semibold text-white shadow-sm hover:bg-indigo-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
                >
                  Calculate
                </button>
              </div>
            </div>
          </div>
        </.form>
      </div>
    </div>
    """
  end

  defp assign_grades(socket) do
    grades = %{homework: [], labs: [], midterm: nil, final: nil}

    socket
    |> assign(:num_homeworks, 4)
    |> assign(:num_labs, 6)
    |> assign(:grades, grades)
    |> assign(:letter_grade, "--")
    |> assign(:percentage_grade, "--")
    |> assign(:numeric_grade, "--")
  end

  defp lookup(fields, prefix, num) do
    Enum.reduce(num..1, [], fn n, acc -> [fields["#{prefix}#{n}"] | acc] end)
  end

  defp my_reply(socket, ok), do: {ok, socket}
end
