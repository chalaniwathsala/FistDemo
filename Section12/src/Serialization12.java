import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Serialization12 {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		//use response veriable
		AddPlace12 adplace=new AddPlace12();
		adplace.setAccuracy(20);
		adplace.setAddress("Kandy");
		adplace.setLanguage("Sinhala");
		adplace.setName("Sryyani");
		adplace.setPhone_number("0812345454");
		adplace.setWebsite("https://rahulshettyacademy.com");
		List<String> myList =new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		adplace.setTypes(myList);
		Location12 l =new Location12();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		adplace.setLocation(l);
		Response res=given().queryParam("key", "qaclick123")
				.body(adplace)
				. when().post("/maps/api/place/add/json").
				then().assertThat().statusCode(200) .extract().response();

				String responseString=res.asString();
				System.out.println(responseString);
	}

}
