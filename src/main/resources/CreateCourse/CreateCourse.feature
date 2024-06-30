Feature: create course

    Scenario: create course
      Given	User open https://swinji.azurewebsites.net
      And  User enter testregister@aaa.com and Wakram_123
      And Open Courses Page
      When User Click on Add Course Button And Enter "Maths" as the name, "3" as Year and "Omar Ahmad" as Teacher of course
      And User click create
      Then Course should be appear in courses List
