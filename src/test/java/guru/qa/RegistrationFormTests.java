package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    @BeforeAll
    static void setUpTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        Selenide.zoom(0.75);

        $("#firstName").setValue("Konstantin");
        $("#lastName").setValue("Konstatinopolski");
        $("#userEmail").setValue("test@mail.ru");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("7991000000");
        $("label[for='hobbies-checkbox-1']").click();
        // $("#uploadPicture").uploadFromClasspath(".png");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1995");
        $("div[aria-label='Choose Sunday, June 25th, 1995']").click();
        $("#subjectsInput").setValue("Computer science").pressEnter();
        $("#currentAddress").setValue("Baumana 10");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();


        $("[class=modal-open]").shouldHave(text("Konstantin"), text("Konstatinopolski"),
                text("test@mail.ru"), text("Male"), text("7991000000"),
                text("25 June,1995"), text("Sports"), text("Computer science"), text("Baumana 10"), text("NCR Delhi"));


    }

}

