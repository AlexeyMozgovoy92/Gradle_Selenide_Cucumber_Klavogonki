package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class BeforeStep {
    @Given("open website {string}")
    public void openWebsite(String url) {
        Configuration.timeout = 60000;
        Selenide.open(url);
    }
}
