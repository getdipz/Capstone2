Feature: IFrame Image Slider on WebDriverUniversity

  Scenario: Verify image slider in IFRAME section
    Given the user navigates to the WebDriver University homepage
    Then the page title should contain "WebDriverUniversity"
    When the user clicks on the "IFRAMES" section link
    Then a new browser tab should open for the IFRAME page
    And the user switches to the new browser tab
    Then an image should be displayed inside the iframe
    When the user clicks the right arrow button on the slider
    Then the image should change accordingly
