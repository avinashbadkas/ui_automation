Feature: User on application Home Page

  Background:
    Given navigate to the application url

  @home @regression
  Scenario Outline:
    Then user verify the "<top_title_menu_bar_list_names>"

    Examples:
      | top_title_menu_bar_list_names |
      | toptitlemenu                  |

