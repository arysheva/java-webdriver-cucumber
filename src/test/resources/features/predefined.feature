@predefined
Feature: Smoke steps

  @predefined1 @bro
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"


  @predefined2 @bro
  Scenario: Predefined steps for Yahoo
    Given I open url "https://www.yahoo.com/"
    Then I should see page title as "Yahoo"
    Then element with xpath "//input[@id='header-search-input']" should be present
    When I type "behavior driven development" into element with xpath "//input[@id='header-search-input']"
    Then I click on element with xpath "//button[@id='header-desktop-search-button']"
    Then I wait for element with xpath "//div[@id='web']" to be present
    Then element with xpath "//div[@id='web']" should contain text "Cucumber"

  @predefined3
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com/"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "behavior driven development" into element with xpath "//input[@id='sb_form_q']"
    Then I click on element with xpath "//label[@for='sb_form_go']/*"
    Then I wait for element with xpath "//div[@id='b_content']" to be present
    Then element with xpath "//div[@id='b_content']" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I open url "https://gibiru.com/"
    Then I should see page title as "Gibiru – Protecting your privacy since 2009"
    Then element with xpath "//input[@id='q']" should be present
    When I type "behavior driven development" into element with xpath "//input[@id='q']"
    Then I click on element with xpath "//button[@id='button-addon2']/i"
    Then I wait for element with xpath "//div[@class='gsc-wrapper']" to be present
    Then I wait for 3 sec
    Then element with xpath "//div[@class='gsc-wrapper']" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for DuckDuckGo
    Given I open url "https://duckduckgo.com/"
    Then I should see page title as "DuckDuckGo — Privacy, simplified."
    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type "behavior driven development" into element with xpath "//input[@id='search_form_input_homepage']"
    Then I click on element with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@id='links']" to be present
    Then element with xpath "//div[@id='links']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com/"
    Then I should see page title contains "Swisscows the alternative"
    Then element with xpath "//input[@name='query']" should be present
    When I type "behavior driven development" into element with xpath "//input[@name='query']"
    Then I click on element with xpath "//button[@class='search-submit']/*"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for Searchencrypt
    Given I open url "https://www.searchencrypt.com/home"
    Then I should see page title as "Search Encrypt | Home"
    Then element with xpath "//div[@id='autosuggest']/input" should be present
    When I type "behavior driven development" into element with xpath "//div[@id='autosuggest']/input"
    Then I click on element with xpath "//i[@class='fas fa-search']"
    Then I wait for element with xpath "//section[@class='serp__results container']" to be present
    Then I wait for 3 sec
    Then element with xpath "//section[@class='serp__results container']" should contain text "test"

  @predefined8
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com/"
    Then I should see page title contains "Startpage.com"
    Then element with xpath "//input[@id='q']" should be present
    When I type "behavior driven development" into element with xpath "//input[@id='q']"
    Then I click on element with xpath "//div[@class='ico']"
    Then I wait for element with xpath "//h3[text()='Web Results']/.." to be present
    Then I wait for 3 sec
    Then element with xpath "//h3[text()='Web Results']/.." should contain text "cucumber"

  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://yandex.com/"
    Then I should see page title as "Yandex"
    Then element with xpath "//input[@id='text']" should be present
    When I type "behavior driven development" into element with xpath "//input[@id='text']"
    Then I click on element with xpath "//div[@class='search2__button']/button"
    Then I wait for element with xpath "//ul[@id='search-result']" to be present
    Then element with xpath "//ul[@id='search-result']" should contain text "cucumber"

  @predefined10
  Scenario: Predefined steps for Boardreader
    Given I open url "https://boardreader.com/"
    Then I should see page title contains "Boardreader"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "behavior driven development" into element with xpath "//input[@id='title-query']"
    Then I wait for element with xpath "//ul[@class='mdl-list']" to be present
    Then I wait for 3 sec
    Then element with xpath "//ul[@class='mdl-list']" should contain text "cucumber"

  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org/"
    Then I should see page title contains "Ecosia"
    Then element with xpath "//input[@name='q']" should be present
    When I type "behavior driven development" into element with xpath "//input[@name='q']"
    Then I click on element with xpath "//button[contains(@class, 'button-submit')]"
    Then I wait for element with xpath "//div[@class='mainline-results']" to be present
    Then element with xpath "//div[@class='mainline-results']" should contain text "Cucumber"
    
    
  @predefined12
  Scenario: 1 Validate responsive UI
    Given I open url "https://skryabin.com/market/quote.html"
    And I resize window to 1200 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    Then element with xpath "//b[@id='currentDate']" should be displayed
    Then element with xpath "//b[@id='currentTime']" should be displayed
    And I resize window to 800 and 1024
    Then element with xpath "//b[@id='location']" should be displayed
    Then element with xpath "//b[@id='currentDate']" should be displayed
    Then element with xpath "//b[@id='currentTime']" should be displayed
    And I resize window to 400 and 1024
    Then element with xpath "//b[@id='location']" should not be displayed
    Then element with xpath "//b[@id='currentDate']" should not be displayed
    Then element with xpath "//b[@id='currentTime']" should not be displayed

  @predefined13
  Scenario: 2 Min Length Username
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should be displayed
    When I type "b" into element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should not be displayed

  @predefined14
  Scenario: 3.1 Valid email field
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I type "@" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I type "c" into element with xpath "//input[@name='email']"
    Then element with xpath "//label[@id='email-error']" should not be displayed
    
  @predefined14
  Scenario: Email
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "arysheva.a" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//div[contains(@class, 'form-summary')]"
    Then element with xpath "//label[@id='email-error']" should be displayed
    And I click on element with xpath "//input[@name='email']"
    When I type "arysheva.a@gmail" into element with xpath "//input[@name='email']"
    Then element with xpath "//label[@id='email-error']" should not be displayed

  @predefined14
  Scenario: 3.2 Valid email field
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "@a" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I type "." into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed

  @predefined14
  Scenario: 3.3 Valid email field
    Given I open url "https://skryabin.com/market/quote.html"
    And I type "a@.c" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I clear element with xpath "//*[@name='email']"
    And I type "a@a.c" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should not be displayed

  @predefined15
  Scenario: 4 Fill out and validate “Password” set of fields
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@id='confirmPassword']" should be disabled
    When I type "a" into element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='confirmPassword']" should be enabled
    When I click on element with xpath "//input[@id='confirmPassword']"
    Then element with xpath "//label[@id='password-error']" should be displayed
    And I click on element with xpath "//input[@id='password']"
    When I type "bcde" into element with xpath "//input[@id='password']"
    And I type "aaaaa" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='confirmPassword-error']" should be displayed
    When I clear element with xpath "//input[@id='confirmPassword']"
    And I type "abcde" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='confirmPassword-error']" should be enabled

  @predefined16
  Scenario: 5 Validate “Name” field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    And I click on element with xpath "//input[@id='name']"
    Then element with xpath "//*[@aria-describedby='nameDialog']" should be displayed
    And I type "Anna" into element with xpath "//input[@id='firstName']"
    And I type "Smith" into element with xpath "//input[@id='lastName']"
    And I type "Maria" into element with xpath "//input[@id='middleName']"
    And I click on element with xpath "//span[text()='Save']"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Anna Maria Smith"

  @predefined17
  Scenario: 6 Validate that Accepting Privacy Policy is required
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I type "anna" into element with xpath "//input[@name='username']"
    And I type "anna@a.aa" into element with xpath "//input[@name='email']"
    And I type "abcde" into element with xpath "//input[@id='password']"
    And I type "abcde" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@id='name']"
    And I type "Anna" into element with xpath "//input[@id='firstName']"
    And I click on element with xpath "//span[text()='Save']"
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//legend[@class='applicationResult']" should be displayed

  @predefined18
  Scenario: 7 non-required fields
    Given I open url "https://skryabin.com/market/quote.html"
    #required
    When I type "anna" into element with xpath "//input[@name='username']"
    And I type "anna@a.aa" into element with xpath "//input[@name='email']"
    And I type "abcde" into element with xpath "//input[@id='password']"
    And I type "abcde" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@id='name']"
    And I type "Anna" into element with xpath "//input[@id='firstName']"
    And I click on element with xpath "//span[text()='Save']"
    And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    #additional
    And I type "4088169999" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//option[text()='France']"
    And I click on element with xpath "//span[text()='Female']"
    And I click on element with xpath "//span[contains(text(),'contact me')]"
    And I type "111 1st street" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//select[@name='carMake']/option[@value='Toyota']"
    And I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    And I click on element with xpath "//input[@id='dateOfBirth']"
    And I click on element with xpath "//select[@class='ui-datepicker-month']/option[@value='4']"
    And I click on element with xpath "//select[@class='ui-datepicker-year']/option[@value='1999']"
    And I click on element with xpath "//a[text()='2']"
    #iframe
    And I switch to iframe with xpath "//iframe[@name='additionalInfo']"
    And I type "Edvard Munch" into element with xpath "//input[@id='contactPersonName']"
    And I type "4088190090" into element with xpath "//input[@id='contactPersonPhone']"
    And I switch to first window
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//legend[@class='applicationResult']" should contain text "Submitted"


  @predefined19
  Scenario: 8 Submit the form and verify the data
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "anna" into element with xpath "//input[@name='username']"
    And I type "anna@a.aa" into element with xpath "//input[@name='email']"
    And I type "abcde" into element with xpath "//input[@id='password']"
    And I type "abcde" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@id='name']"
    And I type "Anna" into element with xpath "//input[@id='firstName']"
    And I click on element with xpath "//span[text()='Save']"
    And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//legend[@class='applicationResult']" should be displayed
    And element with xpath "//b[@name='username']" should contain text "an"
    And element with xpath "//b[@name='password']" should have text as "[entered]"
    And element with xpath "//b[@name='email']" should have text as "anna@a.aa"
    And element with xpath "//b[@name='agreedToPrivacyPolicy']" should have text as "true"
    And element with xpath "//b[@name='name']" should have text as "Anna"


    
    
    













  