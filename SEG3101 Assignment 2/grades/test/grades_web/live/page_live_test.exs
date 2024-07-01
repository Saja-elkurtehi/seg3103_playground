defmodule GradesWeb.PageLiveTest do
  use GradesWeb.ConnCase

  import Phoenix.LiveViewTest

  test "disconnected and connected render", %{conn: conn} do
    {:ok, page_live, disconnected_html} = live(conn, "/")
    assert disconnected_html =~ "Grades"
    assert render(page_live) =~ "Grades"
  end
end
