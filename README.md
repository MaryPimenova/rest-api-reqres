> "Testing leads to failure, and failure leads to understanding" - Burt Rutan
# :woman_technologist:Test automation project for [REQRES.IN]([https://www.mzta.ru/](https://reqres.in/)) service
![WB_logo.jpg](media/logotypes/reqres_logo.png)
> - The process of automatically testing and verifying the functionality of an application programming interface (API) is known as API automation.
> - It helps ensure that the API functions as intended and reduces the time and effort spent on manual testing.
> - API automation is implemented using software tools that send requests to the API, parse the responses, and compare them to the expected results.
> - The goal of API automation is to increase the reliability and consistency of the testing process, which saves time and resources.
> - REST API stands for Representational State Transfer API, which is a web standards-based architecture for building web services.
> - REST API is a common way of communication between clients and servers over the Internet. REST APIs use HTTP requests to manipulate data, such as POST, PUT, GET, and DELETE.

## 🎀 Table of contents
- [Tools and technologies](#hammer_and_wrench-tools-and-technologies)
- [List of implemented tests](#bookmark_tabs-list-of-implemented-tests)
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
✓ Проверка валидации пароля
✓ Проверка наличия выбранного email
✓ Проверка наличия выбранного наименования цвета
✓ Проверка данных пользователя

## :bookmark_tabs: List of implemented tests
#### ✓ List of realized API tests
- [x] Checking for the presence of the main menu items of the site
- [x] Checking drop-down of the list elements in the main menu
- [x] Checking for the presence of correct page titles when navigating through menu items
- [x] Checking shopping cart filling
- [x] Checking downloading files from the web-site
- [x] Checking searching for the production by its arcticle or name
- [x] Checking fulfilling of the registration form with valid/invalid data

Проверка валидации логина
✓ Проверка валидации пароля
✓ Проверка наличия выбранного email
✓ Проверка наличия выбранного наименования цвета
✓ Проверка данных пользователя
✓ Создание нового пользователя
✓ Проверка отсутствия ресурса
✓ Удаление данных
Получение списка пользователей
Проверка наличия пользователя в базе
Создание нового пользователя
Обновление данных пользователя
Успешная регистрация
Проверка id, email пользователя
Проверка успешного логина
Проверка наличия Michael Lawson в списке пользователей
Проверка создания пользователя
Проверка обновления данных пользователя
Проверка статус кода при удалении пользователя
Проверка успешной регистрации
Проверка id и email пользователя

✅ Успешная авторизация API POST

✅ Изменение пользователя API PUT

✅ Получение пользователя API GET

✅ Регистрация пользователя API POST

✅ Создание юзера API POST

✅ Список пользователей API GET

✅ Удаление пользователя API DELETE


## :desktop_computer: Running autotests from the terminal
Lauching tests on a ***remote server*** using Jenkins and Selenoid (login and password are required for authorization) can be done using the following command from the terminal:
```bash  
gradle clean remote
```
___
Running the following command in the IDE terminal will run the tests remotely in Selenoid taking into account the specified ***parameters***:
```bash  
gradle clean remote -Dbase_url=https://www.mzta.ru -Dselenoid_url=https://selenoid.autotests.cloud/wd/hub -Dselenoid_login_password=user1:1234  -Dbrowser=chrome:100.0 -Dbrowser_size=1920x1080
```
If you do not specify any parameters, then the test will run with the default values that we set above.

## <img src="media/logotypes/Jenkins.svg" title="Jenkins" width="4%"/> Build in Jenkins
#### Link to job in Jenkins
Using the link below you can go to the parameterized build of the project:

> :globe_with_meridians: <code>[Link to the job in Jenkins](https://jenkins.autotests.cloud/job/Students/job/MaryPimenova-VacancyProjectUnit14/7/)</code>

#### Build options
The table below shows the build options in Jenkins, their purpose and default settings.

| **PARAMETER** | **DESCRIPTION** | **DEFAULT VALUE** |
|:---------:|:---------:|:---------:|
| <code>BASE_URL</code>| Base URL of the site for configuration settings|https://www.mzta.ru|
| <code>SELENOID_URL</code>| Selenoid URL for configuration settings|https://selenoid.autotests.cloud/wd/hub|
| <code>USER_LOGIN</code>| Login to the Selenoid account|	:lock:	:lock:	:lock:	:lock:|
| <code>USER_PASSWORD</code>| Password to the Selenoid account|	:lock:	:lock:	:lock:	:lock:|
| <code>BROWSER</code>| Browser type and its version|Chrome : 100.0|
| <code>BROWSER_SIZE</code>| Browser size |1920x1080|

#### Job in Jenkins: algorithm and autotests results
1. Open the project from the link above. The screenshot shows the appearance of the project window in Jenkins.
<p align="center">
<img title="Jenkins" src="media/screenshots/Jenkins.jpg">
</p>

2. Select the item "Collect with parameters" on the left panel

3. If necessary, change the parameters by selecting values from the drop-down lists

4. Click "Collect" button

5. The results of running a parameterized build can be viewed in <code>Allure report</code> and <code>Allure TestOps</code>
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
