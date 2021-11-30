package RequestRespnseSpecBuilder;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace;
import POJO.Location;

public class MainApi {
	
	public static void main(String[] args) {
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setName("Frontline house");
		p.setPhone_number("8889737919");
		p.setWebsite("http://google.com");
		List<String> listTpye = new ArrayList<>();
		listTpye.add("shoe park");
		listTpye.add("shop");
		p.setTypes(listTpye);
		
		Location locObject = new Location();
		locObject.setLat(38.383494);
		locObject.setLng(33.789);
		p.setLocation(locObject);
		
		given().log().all().spec(RequestSpecBuider.getRequestSpecBuilder()).body(p)
		.when().post("/maps/api/place/add/json")
		.then().log().all().spec(ResponseBuilder.getResponseSpecBuilder()).extract().response();
		
	}
}

