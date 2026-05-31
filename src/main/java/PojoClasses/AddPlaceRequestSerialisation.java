package PojoClasses;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;

public class AddPlaceRequestSerialisation {
	public static void main(String[] args) {
		GoogleaddPlace a = new GoogleaddPlace();
		a.setAccuracy(20);
		a.setAddress("36,Dabri Extension Main, New Delhi");
		a.setLanguage("English");
		a.setWebsite("www.indianArmy.com");
		a.setPhone_number("8109874008");
		a.setName("Pratiksha");
		location l = new location();
		l.setLat(-12.324);
		l.setLng(-232112.23);
		a.setLocation(l);
		
		ArrayList<String> ab = new ArrayList<>();
		ab.add("kuch");
		ab.add("sachmekuchbhi");
		a.setTypes(ab);
		String responseBody = given().queryParam("key", "qaclick123").body(a).log().all().when().post("https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123").then().assertThat().statusCode(200).extract().response().asString();
			System.out.println("Response_Body is " + responseBody);	
		
		
		
		
		
	}
}
