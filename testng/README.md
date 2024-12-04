# TestNG Project

This sample project demonstrates how to integrate a **TestNG** project with AgileTest automation test.

## Prerequisites

Before you start, ensure that you have the following installed:

- **Java 8 or higher**: [Download here](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Maven**: [Download here](https://maven.apache.org/install.html)

## Getting Started

### 1. Install Dependencies

To download and install the required dependencies, use Maven:

```bash
mvn clean install
```

### 2. Running Tests

You can execute the tests using the Maven command:

```bash
mvn test
```

This command compiles the test code and runs the TestNG tests defined in the src/test/java directory.

### 3. Viewing Test Results

Once the tests are executed, TestNG generates a default report in the test-output/ directory. You will find:

- index.html: A summary report.
- emailable-report.html: A simplified, email-ready report.
- testng-results.xml: An XML file with detailed test execution results.

You can open the test-output/index.html file in your web browser to view the report.

## Import Test Reports

### Get authenticated

You need to acquire client-id and client-secret first.
[Agile Test - API Integration](https://docs.devsamurai.com/agiletest/app-general-settings#Appgeneralsettings-4.APIIntegration)

```bash
curl -X 'POST' \
  'https://agiletest.atlas.devsamurai.com/api/apikeys/authenticate' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "clientId": "<client-id>",
  "clientSecret": "<client-secret>"
}'
```

### Upload test report

Now apply the token received from the last request.

```bash
curl -X 'POST' \
  'https://dev.api.agiletest.app/ds/test-executions/testng?projectKey=<project-key>' \
  -H 'accept: application/json' \
  -H 'Authorization: JWT <token>' \
  -H 'Content-Type: application/json' \
  --data-binary '@my-report.json'
```

For more details, please refer to relevant article
[Import TestNG report](https://devsamurai.atlassian.net/wiki/spaces/AA/pages/2333868033/TestNG+XML+result)

## CICD integration

For more details, please refer to relevant article
[CI/CD Tool Integration](https://devsamurai.atlassian.net/wiki/spaces/AA/pages/2265022839/CI+CD+Tool+Integration)

## Contributions

Feel free to fork the project, open a pull request, or report any issues!
