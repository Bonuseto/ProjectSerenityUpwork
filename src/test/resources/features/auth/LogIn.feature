Feature: User can log in to website

  @Login
  Scenario Outline: Login successfully with username and password
    Given User is on a Home page
    When User login with '<user>' and '<password>'
    Then appears message 'You are logged in as user "<user>".' on a home page

    Examples:
      |user|password|
      |admin|admin|
      |user |user|
