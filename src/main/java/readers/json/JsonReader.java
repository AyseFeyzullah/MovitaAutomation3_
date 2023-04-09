package readers.json;


import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonReader {

    public static By getBy(String anaBaslik, String altBaslik) throws FileNotFoundException {
        String JasonFile = "config.json";
        JSONObject object = (JSONObject) JSONValue.parse(new FileReader(JasonFile));
        JSONObject anabaslikBilgi = (JSONObject) object.get(anaBaslik);
        JSONObject altbaslikBilgi = (JSONObject) anabaslikBilgi.get(altBaslik);

        String type = altbaslikBilgi.get("type").toString();
        String locator = altbaslikBilgi.get("locator").toString();

        switch (type.toLowerCase()) {
            case "xpath":
                return By.xpath(locator);
            case "id":
                return By.id(locator);
            case "tagname":
                By.tagName(locator);
            case "partiallinktext":
                By.partialLinkText(locator);
            case "css":
                By.cssSelector(locator);
            case "linktext":
                By.linkText(locator);
            case "class":
                By.className(locator);
            default:
                return null;
        }


    }
    public static  String getValue(String ana, String alt) throws FileNotFoundException {

        String jsonFile = "src/test/resources/config.json";

        JSONObject object= (JSONObject) JSONValue.parse(new FileReader(jsonFile));
        JSONObject anabilgi = (JSONObject) object.get(ana);
        return  anabilgi.get(alt).toString();
    }


}
