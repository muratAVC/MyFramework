Feature:Coin market
  The user should be able to click the community module on the main page and write and post a message as a guest after entering there.
AC: The max character can be 99
Without entering a message, the user can't click Post
2.
The user should be able to see three options for the "Show rows", and set the table based on three options;
AC: First option 100
Second option 50
Third option 20

The user should be able to click "Filters" on the main page and add a price filter between 10 to 20.
AC: The table should not display any price which is more than 20 and less than 10 dolar.

  Background: Coin Market
    Given open coin market

  @Coin1
  Scenario Outline: Coin market
    Given guest enter
    And The user should be able to click the community module
    And write and post "<message>"

    Examples: coin message
      |message|
    |selam nasilsln|
    |lkdmvrdihg idugh diugh idugh dg iugn vlrug djjg diug vklerjgn isdugh ekrjgn rugeyrgbcurbfcuwrybcwurbcvuwr uwr cwur wcur uwr cuwgr curf cuygr ucwgr cuwgr cuwgr cuw |
    |rjgv8dtjmv  g5g h d 5 5yr5g dtg5g                                               |

    @Coin2
  Scenario Outline: coin market
    Given The user should be able to see three options "<row>"
    And verify row count "<row>"

    Examples: choose
      |row|
      |100|
      |50 |
      |20 |

      @Coin3
  Scenario: Coin market
    Given The user should be able to click Filters
    And verify all price

        @Testt
  Scenario: Create contact using a map o  Left side is key, and right is value   2 columns only
    Given I logged into suiteCRM
    When I create a new contact:
  | first_name | John  |
  | last_name  | Smith  |
  | cell_phone | 801 888 8889  |
  Then I should see contact information for "John Smith"
