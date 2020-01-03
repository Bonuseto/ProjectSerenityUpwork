Feature: User can log in to website

  @Login
  Scenario Outline: Login successfully with username and password
    Given User likes to browse with '<browser>'
    When User login with '<user>' and '<password>'
    Then appears message 'You are logged in as user "<user>".' on a home page

    Examples:
    |browser|user |password
    |firefox|admin|admin
    |chrome |user |user
    |firefox|user |admin
