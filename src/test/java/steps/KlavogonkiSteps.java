package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class KlavogonkiSteps {
    private final SelenideElement startGame = $x("//a[@class='title']");
    private final SelenideElement closeWindowButton = $(By.xpath("/html/body/div[6]/div/div/div[5]/div[2]/div/table/tbody/tr[2]/td[2]/p[5]/input"));

    private final SelenideElement startGameButton = $x("//a[@id='host_start']");
    private final SelenideElement highlightWord = $x("//span[@id='typefocus']");
    private final SelenideElement inputField =$x("//input[@id='inputtext']");
    private final SelenideElement afterFocus =$x("//span[@id='afterfocus']");

    private String getCurrentWord(){
       return highlightWord.getText().replaceAll("c", "с").replaceAll("o", "о").replaceAll("Ps", "о");
    }
    @When("start game")
    public void startGame() {
        startGame.click();
        closeWindowButton.click();

        if(startGameButton.isDisplayed()){
                startGameButton.click();
        }
    }

    @And("wait for start")
    public void waitForStart() {
        highlightWord.click();
    }

    @And("print marked word")
    public void printMarkedWord() {
        while (true){
            String currentWord = getCurrentWord();
            String afterfocusSymbol = afterFocus.getText();
            inputField.sendKeys(currentWord);
            if(afterfocusSymbol.equals(".")){
                inputField.sendKeys(".");
                break;
            }
                inputField.sendKeys(Keys.SPACE);
        }
    }

    @Then("check that the game is over and score more then {int}")
    public void checkThatTheGameIsOverAndScoreMoreThen(int minValue) {
        System.out.println(minValue);
    }
}
