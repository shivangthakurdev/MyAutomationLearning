@All
  Feature: Facebook Page

    Scenario: Login to Facebook
      And user is on login page
      Then user enter username "shivangthakur" and password "123456"
      Then user open "http://www.yopmail.com/en/" in new tab
      And user enter email as "shivangthakur1234"