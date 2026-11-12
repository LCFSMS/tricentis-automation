package api;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ApiTest {

    @Test
    public void testGetUse(){

            given()//блок подготовки запроса (URL, заголовки, параметры)
                .baseUri("https://jsonplaceholder.typicode.com")//базовый URL API
                .when()//блок выполнения действий (отправка запроса)
                .get("/users/1")//отправка Get-запроса на /users/1
                .then()//блок проверки отвта
                .statusCode(200)//проверка что статус код ответа == 200(OK)
                .body("id", equalTo(1))//проверка, что поле id == 1 в JSON
                .body("name", notNullValue());// проверка , что поле name существует и не null
    }

    @Test
    public void testCreatePost(){
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .header("Content-Type", "application/json")//говрим серверу, что запрос в формате json
                .body("{\"title\": \"foo\", \"body\": \"bar\", \"userId\":1}")//тело запроса - jsonстрока
                .when()//выполняем действие
                .post("/posts")//отправка post-запроса
                .then()//проверяем ответ
                .statusCode(201)
                .body("title", equalTo("foo"))//проверка заголовка
                .body("userId", equalTo(1));//проверка id
    }
}
