/**
 * 
 */
package com.javatech.vertex;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

/**
 * @author tenny
 *
 */
public class VertexSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//Create a vertx	
	Vertx vertx = Vertx.vertx();
	
	//Create a HTTP server
	HttpServer httpServer = vertx.createHttpServer();
	
	//create Router
	Router router = Router.router(vertx);
	
	Route handler1 = router
				//.route("/hello")
				.get("/hello/:name")
				.handler(routingContext ->{
					String name = routingContext.request().getParam("name");
					System.out.println("came to get name:"+name);
			
					HttpServerResponse serverResponse = routingContext.response();
					serverResponse.setChunked(true);
					serverResponse.write("Welcome to first page111111111:"+name);
					serverResponse.end();
	});
	
	
	Route handler2 = router.post("/hello")
					.handler(routingContext ->{
					System.out.println("came to post");		
					HttpServerResponse serverResponse = routingContext.response();
					serverResponse.setChunked(true);
					serverResponse.write("Welcome to second page111111111 from post");
					serverResponse.end();
	});
	
	httpServer.requestHandler(router::accept).listen(9080);
	}

	
}
