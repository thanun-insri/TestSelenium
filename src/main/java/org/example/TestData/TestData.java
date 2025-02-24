package org.example.TestData;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStreamReader;

public class TestData {
    private JsonObject rootTestData;

    public TestData() {
        ClassLoader classLoader = TestData.class.getClassLoader();
        try (InputStreamReader reader = new InputStreamReader(classLoader.getResourceAsStream("testData\\testData.json"))) {
            //Load JSON test data content to be JsonObject
            this.rootTestData = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JsonObject getData() {
        return this.rootTestData;
    }
}