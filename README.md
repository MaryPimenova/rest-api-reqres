> "Testing leads to failure, and failure leads to understanding" - Burt Rutan
# :woman_technologist:Test automation project for [REQRES.IN](https://reqres.in/) service
![WB_logo.jpg](media/logotypes/reqres_logo.png)
> - The process of automatically testing and verifying the functionality of an application programming interface (API) is known as API automation.
> - It helps ensure that the API functions as intended and reduces the time and effort spent on manual testing.
> - API automation is implemented using software tools that send requests to the API, parse the responses, and compare them to the expected results.
> - The goal of API automation is to increase the reliability and consistency of the testing process, which saves time and resources.
> - REST API stands for Representational State Transfer API, which is a web standards-based architecture for building web services.
> - REST API is a common way of communication between clients and servers over the Internet. REST APIs use HTTP requests to manipulate data, such as POST, PUT, GET, and DELETE.

## 🎀 Table of contents
- [Tools and technologies](#hammer_and_wrench-tools-and-technologies)
- [List of implemented API tests](#bookmark_tabs-list-of-implemented-api-tests)
- [Running autotests from the terminal](#desktop_computer-running-autotests-from-the-terminal)
- [Build in Jenkins](#-build-in-jenkins)
- [Allure report](#-allure-report)
- [Allure TestOps](#-allure-testops)
- [Integration with Jira](#-integration-with-jira)
- [Telegram notifications using a bot](#-telegram-notifications-using-a-bot)
## :hammer_and_wrench: Tools and technologies

| IntelliJ IDEA | Java | Rest Assured | Allure Report |  Allure TestOps | Gradle | JUnit5 | GitHub | Jenkins| Telegram | Jira |
|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|
| <img width="90%" title="IntelliJ IDEA" src="media/logotypes/Intelij_IDEA.svg"> | <img width="110%" title="Java" src="media/logotypes/Java.svg"> | <img width="80%" title="Rest_Assured" src="media/logotypes/RestAssured.png"> |<img width="100%" title="Allure Report" src="media/logotypes/Allure_Report.svg"> |<img width="60%" title="Allure TestOps" src="media/logotypes/AllureTestOps.svg"> |<img width="90%" title="Gradle" src="media/logotypes/Gradle.svg"> |<img width="90%" title="JUnit5" src="media/logotypes/JUnit5.svg"> |<img width="90%" title="GitHub" src="media/logotypes/GitHub.svg"> |<img width="90%" title="Jenkins" src="media/logotypes/Jenkins.svg"> |<img width="80%" title="Telegram" src="media/logotypes/Telegram.svg">|<img width="45%" title="Jira" src="media/logotypes/Jira.svg">|

- To create autotests in this project the <code>[Java](https://www.java.com/)</code> language was used.
- <code>[Gradle](https://gradle.org/)</code> was used as an automatic build system.  
- Framework <code>[JUnit5](https://junit.org/junit5/)</code> for automated unit testing has been applied.
- The models of the received data are described using the <code>[Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok)</code> library.
- API testing is done using the <code>[Rest Assured](https://rest-assured.io/)</code> library. This library helps identify and fix bugs and issues early in the development process.
- To run tests remotely a job was implemented in <code>[Jenkins](https://jenkins.autotests.cloud/job/MaryPimenova-VacancyProjectUnit14/)</code> with the creation of an <code>[Allure-report](https://jenkins.autotests.cloud/job/MaryPimenova-VacancyProjectUnit14/7/allure/)</code> and sending the results to <code>Telegram</code> using special Telegram bot.
- Integrations with с <code>[Allure TestOps](https://allure.autotests.cloud/project/2434/dashboards)</code> and <code>[Jira](https://jira.autotests.cloud/browse/HOMEWORK-720)</code> were implemented.

## 🚩 List of HTTP response status codes used
#### ✓ List of successful responses
| **CODE** | **STATUS** | **MEANING** |
|:---------:|:---------:|:---------:|
| <code>200</code>| OK| The request succeeded|
| <code>201</code>| Created |The request succeeded, and a new resource was created as a result|
| <code>204</code>| No Content |There is no content to send for this request, but the headers may be useful|
#### ✓ List of client error responses
| **CODE** | **STATUS** | **MEANING** |
|:---------:|:---------:|:---------:|
| <code>400</code>| Bad Request |The server can't process the request due to a client error|
| <code>404</code>| Not Found |The server can't find the requested resource (resource itself doesn't exist)|

## :bookmark_tabs: List of implemented API tests
 <b> API POST </b>
 <br>:white_check_mark: Successful user authorization (code 200)  <br />
:white_check_mark: Unsuccessful user authorization as login and password are invalid (code 400) <br />
:white_check_mark: Unsuccessful user authorization as password is missed (code 400) <br />
:white_check_mark: Successful user registration (code 200) <br />
:white_check_mark: Unsuccessful user registration as password is missed (code 400) <br />
:white_check_mark: Creation a new user (code 201) <br />
<b> API DELETE</b>
 <br>:white_check_mark: Deleting a user (code 204) <br />
<b> API PATCH</b>
 <br>:white_check_mark: Updating user data (code 200) <br />
<b> API PUT</b>
 <br>:white_check_mark: User data update (code 200) <br />
<b> API GET</b>
 <br>:white_check_mark: Get user list page №2 and check its scheme (code 200) <br />
:white_check_mark: Get user list page №2 and check users by IDs and names (code 200) <br />
:white_check_mark: Attempt to get data about a non-existent single user (code 404) <br />
:white_check_mark: Get single user data and check it by ID and name (code 200) <br />
:white_check_mark: Get colors data and check it by IDs and names (code 200) <br />


## :desktop_computer: Running autotests from the terminal
Lauching tests can be done using the following command from the terminal:
```bash  
gradle clean test
```
___
Running the following command in the IDE terminal will run the tests locally.

## <img src="media/logotypes/Jenkins.svg" title="Jenkins" width="4%"/> Build in Jenkins
#### Link to job in Jenkins
Using the link below you can go to the build of the project:

> :globe_with_meridians: <code>[Link to the job in Jenkins](https://jenkins.autotests.cloud/job/MaryPimenova-ReqresRestAPI/)</code>

#### Job in Jenkins: algorithm and autotests results
1. Open the project from the link above. The screenshot shows the appearance of the project window in Jenkins.
<p align="center">
<img title="Jenkins" src="media/screenshots/jenkins_main_page.png">
</p>

2. Select the item "Collect now" on the left panel
   
3. The results of running a build can be viewed in <code>Allure report</code> and <code>Allure TestOps</code>
<p align="center">
<img title="Jenkins_build" src="media/screenshots/Jenkins_build_upd.jpg">
</p>

## <img src="media/logotypes/Allure_Report.svg" title="Allure_Report" width="4%"/> Allure report
#### Link to Allure report
Using the link below you can go to the Allure report:

> :globe_with_meridians: <code>[Link to the  Allure report](https://jenkins.autotests.cloud/job/MaryPimenova-VacancyProjectUnit14/7/allure/)</code>

#### Allure report: overview
The screenshot below shows the main page of the report.
<p align="center">
<img title="Allure_report_overview" src="media/screenshots/Allure_report_overview.jpg">
</p>

#### Allure report: test cases
On the Suites tab a standard structural representation of executed tests can be found.
<p align="center">
<img title="Allure_report_suits" src="media/screenshots/Allure_report_suits_optimal.jpg">
</p>


#### Allure report: graphs
Graphs allow you to see different statistics collected from the test data: statuses breakdown or severity and duration diagrams.
<p align="center">
<img title="Allure_report_graphs1" src="media/screenshots/Allure_report_graphs1.jpg">
</p>
<p align="center">
<img title="Allure_report_graphs2" src="media/screenshots/Allure_report_graphs2.jpg">
</p>

## <img src="media/logotypes/AllureTestOps.svg" title="Allure_TestOps" width="4%"/> Allure TestOps
#### Link to Allure TestOps
Using the link below you can go to the Allure TestOps:

> :globe_with_meridians: <code>[Link to the  Allure TestOps](https://allure.autotests.cloud/project/2434/dashboards)</code>

#### Allure TestOps: dashboard
Standard dashboard (see the picture below) provides instant insight on status of tests you're having in your project and resides in the Dashboards section of a project.
<p align="center">
<img title="Allure_testOps_overview" src="media/screenshots/Allure_testOps_overview_mini.jpg">
</p>
The default dashboard contains:

1. Number of test cases and distribution per state (active, in review, outdated etc.)
2. Number of test cases and distribution between the manual tests and automated tests
3. Automation trend with the insight regarding the number of test during last 14 days
4. Information about launches and thier results status (failed, passed)
5. Mutes trend, i.e. the number of tests excluded from statistics due to permanent failed state or flaky state.

#### Allure TestOps: test cases
Allure TestOps supports working with both – manual and automated test cases. Steps of a test case are described in the scenario.

<p align="center">
<img title="Allure_testOps_test_cases" src="media/screenshots/Allure_testOps_test_cases.jpg">
</p>

#### Allure TestOps: manual tests
Manual test cases with scenario of execution are shown on the picture below.

<p align="center">
<img title="Allure_testOps_manual" src="media/screenshots/Allure_testOps_manual.jpg">
</p>

#### Allure TestOps: automated tests
Automated test cases are generated based on test results received from automated tests.

<p align="center">
<img title="Allure_testOps_automated" src="media/screenshots/Allure_testOps_automated.jpg">
</p>

## <img src="media/logotypes/Jira.svg" title="Jira" width="5%"/> Integration with Jira
#### Link to Jira
Using the link below you can go to the Jira:
> :globe_with_meridians: <code>[Link to the  Jira](https://jira.autotests.cloud/browse/HOMEWORK-720)</code>
<p align="center">
<img title="Jira" src="media/screenshots/Jira.jpg">
</p>

## <img src="media/logotypes/Telegram.svg" title="Jira" width="5%"/> Telegram notifications using a bot
As a result of running autotests, a config.json file is generated in the notifications/ folder. On the basis of this file a notification is generated that the bot sends (a diagram is drawn and the corresponding text is added).

```mermaid
flowchart LR
    A(Autotests execution) -->|1| B(json file generation)
    B -->|2| C[notification generation: diagram and text]
    subgraph Allure notifications
    C -->|3| D[sending a notification to the messenger]
    end
```

<p align="center">
<img title="Telegram" src="media/screenshots/Telegram.jpg">
</p>

*After the completion of the autotests for each of them screenshots, page source, browser console logs and a video recording of the test are available in the report.*

## <img src="media/logotypes/Selenoid.svg" title="Selenoid" width="5%"/> Video example of running tests in Selenoid
The test report is accompanied by a video in the Attachment section.
<p align="center">
  <img title="Selenoid Video" src="media/video/Selenoid_video.gif">
</p>
