# Chartercustomerrewards

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction

(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total.

· Make up a data set to best demonstrate your solution

· Check solution into GitHub

# Test Data

Test Data is placed in the JSON file inside the resources folder in the project.
If you'd like to test for a different scenario, please another JSON file in the _**resources**_ folder according to the format given in the existing JSON.
And update the code in line 17 of RewardsSummaryService.java with the new JSON file name.

# Execution Instructions

git clone https://github.com/hvardhanr/Chartercustomerrewards.git

mvn clean compile

mvn spring-boot:run


# Usage

Once the service is running on port 9090, according to the port number mentioned in application.properties file, you can visit the following URL for output

http://localhost:9090/getRewardsSummary/1

Expected Output for http://localhost:9090/getRewardsSummary/1
```json
{
  "id" : 1,
  "name" : "Linda",
  "firstMonthRewards" : 0,
  "secondMonthRewards" : 100,
  "thirdMonthRewards" : 0,
  "totalRewardAmount" : 100
}
```
# Exception Handling & Logging

Added the customer exception handling code for customer not found and logged the info and error messages though out the project.

# Running the Tests

Import the code into Eclipse or any IDE and select the **_run coverage as_** option in the IDE.
The tests encompass multiple scenarios of monthly transactions.

