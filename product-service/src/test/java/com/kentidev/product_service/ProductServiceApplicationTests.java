package com.kentidev.product_service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

//Para evitar conflictos de puertos con diferentes instancias de la applicacion que puedan estar ejecutandose durante la prueba
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {


	//Creamos una instancia de mongo mediante TestContainer
	// @ServiceConnection registra automáticamente el contenedor de Testcontainers como una fuente de servicio
	// para el contexto de la aplicación Spring Boot. Esto permite que Spring Boot utilice este contenedor
	// como la base de datos (u otro servicio) durante las pruebas, configurando dinámicamente las propiedades
	// necesarias para evitar conflictos con la configuración de producción.
	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

	//Esta annotation inyecta el puerto en el que se ejecuta el servidor. Es util cuando se utiliza
	// SpringBootTest.WebEnvironment.RANDOM_PORT
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	//Inicio el contenedor de mongodb
	static{
		mongoDBContainer.start();
	}

	@Test
	void shouldCreateProduct() {
		String requestBody = """
				{
					"name":"tensiometro",
					"description":"Silfab 1300",
					"price":"50000"
				}
				""";

		RestAssured.given()
		.contentType("application/json")
		.body(requestBody)
		.when()
		.post("/api/products")
		.then()
		.statusCode(201)
		.body("id", Matchers.notNullValue())
		.body("name", Matchers.equalTo("tensiometro"))
		.body("description", Matchers.equalTo("Silfab 1300"))
		.body("price", Matchers.equalTo(50000));
	}

}
