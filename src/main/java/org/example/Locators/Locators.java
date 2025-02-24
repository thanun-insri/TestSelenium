package org.example.Locators;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.TestData.TestData;
import java.io.InputStreamReader;

public class Locators {
    private JsonObject rootLocator;

    public Locators(String fileName) {
        ClassLoader classLoader = TestData.class.getClassLoader();
        try (InputStreamReader reader = new InputStreamReader(classLoader.getResourceAsStream("locators\\"+ fileName +".json"))) {
            rootLocator = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JsonObject getLocators() {
        return rootLocator;
    }
}
