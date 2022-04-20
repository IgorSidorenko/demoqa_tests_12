package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();

    //locators
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            subjectsWrapper = $("#subjectsWrapper"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            resultTitle = $("#example-modal-sizes-title-lg"),
            tableResponsive = $(".table-responsive");

    //actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");

        Selenide.zoom(0.75);
        Selenide.executeJavaScript("document.getElementById('fixedban').remove()");
        Selenide.executeJavaScript("document.getElementsByTagName('footer')[0].remove()");

        $(".practice-form-wrapper").shouldHave(Condition.text("Student Registration Form"));

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String key, String value) {
        subjectsInput.sendKeys(key);
        subjectsWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();

        return this;
    }

    //asserts
    public RegistrationPage checkResultTitle(String value) {
        resultTitle.shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkResultStudentName(String key, String value1, String value2) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value1 + " " + value2));

        return this;
    }

    public RegistrationPage checkResultStudentEmail(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkResultGender(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkResultMobile(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkResultDateOfBirth(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkResultSubjects(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkResultHobbies(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkResultPicture(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkResultAddress(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkResultStateAndCity(String key, String value1, String value2) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value1 + " " + value2));
        return this;
    }
}


