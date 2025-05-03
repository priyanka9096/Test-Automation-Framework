
🚀 Test Automation Framework

This is a Java-based Test Automation Framework. 

Built for UI and data-driven testing using TestNG, Maven, and various supporting libraries. 
It supports both local and cloud (LambdaTest) execution with options for headless mode. 




## 🚀 About Me
Hi, My name is Priyanka Patil I have 5 years of experience in Automation Testing using technologies Selenium Webdriver

My major experties is in java Programming Language.


## Author

- [@priyanka9096](https://github.com/priyanka9096)
- EmailAddress: priyankapatil9096@gmail.com









## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/priyanka9096)


[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/priyanka-patil-00a45a89/)





## Prerequisites

- **Java 11**  installed and JAVA_HOME configured
- **Maven** installed
- **IDE** like IntelliJ IDEA or Eclipse


✅ Features

- Java 11 based framework
- TestNG for test execution
- Maven for build and CLI execution
- Data-driven testing with Excel CSV, JSON, Excel
- Faker library for fake data generation
- Logging with Log4j
- Extent Reports for detailed HTML test reports
- LambdaTest integration for cloud-based        cross-browser execution
- Headless mode for faster execution

🛠️ Technologies used 

- Java 11 
- TestNG 
- Maven
- OpenCSV	
- GSON
- Apache POI
- Faker
- Log4j
- ExtentReports
- LambdaTest


## Setup Instruction

**Clone the Repository**


```bash
 git Clone https://github.com/priyanka9096/Test-Automation-Framework.git

 cd  Test-Automation-Framework
```
    


**Runing tests on LambdaTest**


```bash
 mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X
```
    



**Runing tests on chrome browser on Local Machine in Headless Mode**


```bash
 mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X
```
    
## 📊 Reports and Logs
After test execution:

- **HTML Report:** reports/reports.html (Generated via ExtentReports)

- **Log File:** logs/automation.log (Generated via Log4j)



## integrated the project Github Actions 

This automation framework is integrated with github action. 
The  tests will be executed at 11.30PM IST every single day.

The reports will be archieved in gh-pages branch 
