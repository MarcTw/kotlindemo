說明:<br />
1.建立local mysql ex.mysql://localhost:3306/test <br />
2.修正/src/main/resource/application.yml spring.datasource.url,username,password<br />
3.至專案目錄./gradlew build && java -jar build/libs/cc-0.0.1-SNAPSHOT.jar<br />
4.postman test: Http.post url:http://localhost:8082/api/user/ header:Content-Type=application/json; <br />
body:{
	"username":"ab6c11"
  }
=>response:{
    "username": "ab6c13",
    "userid": 4
}
