@SmokeTest
Feature: Login function Test
@TC_001
Scenario: As a Luma Application user, must do successfull login with valid credintial
And open any browser
And go to application URL
When click sigh Btn
And put email
And put password
And click second sighin btn
Then validation login was successfull
