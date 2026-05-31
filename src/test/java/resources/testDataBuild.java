package resources;

import java.util.ArrayList;

import PojoClasses.GoogleaddPlace;
import PojoClasses.location;

public class testDataBuild {

	public GoogleaddPlace requestTestData(String name,String language,String address) {

		GoogleaddPlace a = new GoogleaddPlace();
		a.setAccuracy(20);
		a.setAddress(address);
		a.setLanguage(language);
		a.setWebsite("www.indianArmy.com");
		a.setPhone_number("8109874008");
		a.setName(name);
		location l = new location();
		l.setLat(-12.324);
		l.setLng(-232112.23);
		a.setLocation(l);

		ArrayList<String> ab = new ArrayList<>();
		ab.add("kuch");
		ab.add("sachmekuchbhi");
		a.setTypes(ab);
		return a;
	}
	
	public String DeleteAPIPayload(String placeId) {
		return "{\n    \"place_id\": \""+placeId+"\"\n}";
	}
}
