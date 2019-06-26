說明:
1.建立local mysql ex.mysql://localhost:3306/test
2.修正/src/main/resource/application.yml spring.datasource.url為1.
3.至專案目錄./gradlew build && java -jar build/libs/cc-0.0.1-SNAPSHOT.jar
4.postman test: Http.post url:http://localhost:8082/api/user/ header:Content-Type=application/json; 
body:{
	"username":"ab6c11"
  }
=>response:{
    "username": "ab6c13",
    "userid": 4
}
