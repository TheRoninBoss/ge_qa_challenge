# GE QA Challenge

QA Challenge for GE

## Test automation architecture

This project is organized in two major directories: `main` and `test`

Directory `main` contains all the necessary components to run the tests: this includes
the page object models, and the test data. This folder is where the webdriver setup
would be located as well but for the moment this is not needed.

Directory `test` as the name suggest is home to all the tests that are to be executed.

## To run tests:

First you must have maven installed then:

* To run all tests run: `mvn clean test -P suite`
* To specify a browser, add the argument : `-Dbrowser=chrome` or `-Dbrowser=firefox`. Tests will run on chrome by
  default.

## Test execution report

After test are executed, the report can be found
in [target/surefire-reports/TestSuite/GETests.html](target/surefire-reports/TestSuite/GETests.html)
