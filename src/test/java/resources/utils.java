package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class utils {
	public static RequestSpecification AddPlacereqSpec;
	RequestSpecBuilder r;

	public RequestSpecification addPlaceAPIRequestSpecification() throws IOException 
	
	{
		if(AddPlacereqSpec==null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		r = new RequestSpecBuilder();
		r.setBaseUri(getGlobalValues("baseUrl")).addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log));
		AddPlacereqSpec = r.build();
		return AddPlacereqSpec;
		}
		else {
			return AddPlacereqSpec;
		}
		
	}
	
	public static String getGlobalValues(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\APIFrameworkDesign\\src\\test\\java\\resources\\global.properties");
	prop.load(fis);
	prop.getProperty(key);
	return prop.getProperty(key);
	}
	
	public String getJsonPath(Response response,String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
		
	}
	
	
}
