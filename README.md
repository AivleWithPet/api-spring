## 시작하기

### Requirements
- [Intellij (IDE)](https://www.jetbrains.com/ko-kr/idea/download/?section=windows)
- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [MySQL Workbench 8.0.34](https://dev.mysql.com/downloads/workbench/)
- 운영체제에 따라 시스템 환경 변수 설정이 필요할 수 있습니다.

### Installation
``` bash
$ git clone https://github.com/AivleWithPet/api-spring.git
```

#### 📌 MySQL Setting
1. Mysql Workbench를 실행합니다.
2. mysql 서버가 켜져있는지 확인합니다.
3. <strong>bowwow</strong> 스키마를 생성합니다.

#### 📌 Intellij Setting
1. Intellij를 실행하고 클론해온 프로젝트를 열어줍니다.
2. Setting에서 build 방식을 변경하고 JDK를 설정해줍니다.
   <div align="center">
     <h5>Setting > Build, Execution, Deployment > Build Tools > Gradle<h5>
   <img width="450" alt="Screenshot 2023-07-22 at 3 18 02 PM" src="https://github.com/AivleWithPet/api-spring/assets/86587037/05b73654-529b-41a5-9b11-7b30b3be40c9">
   </div>

3. <strong>src/main/resources/application.yml</strong>에서 나의 mysql 계정으로 변경해줍니다. (line5, line6)
4. 서버를 실행합니다. (Run 'ApiSpringApplication' ▶️) 🎉
