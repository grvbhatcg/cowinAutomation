
## cowinAutomation
### Introduction
- An API automation framework for [api setu's cowin public API](https://apisetu.gov.in/directory/api/cowin/cowin-public-v2)
- Tests have been written to cater to the following requirements:
    - Validate the state id of Karnataka is "16".
    - Validate the district id of Bangalore Urban is "265"
    - Validate  that all states/UTs have their state_id
    - Validate the price of vaccine does in Hospital "Springleaf Healthcare" [State :   Karnataka, District : Bangalore Urban] is > Rs 300
    - Validate that atleast one Hospital is providing vaccine as Free

### Running tests
The specified tests are inside the `TestGET` class which has to be run

### Viewing test results
To view the the test results, run the following command in the terminal (from the root directory)

    allure serve allure-results
