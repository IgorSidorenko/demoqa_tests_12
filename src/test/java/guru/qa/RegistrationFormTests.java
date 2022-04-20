package guru.qa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class RegistrationFormTests {

    Faker fakerEn = new Faker(new Locale("en"));
    Faker fakerRu = new Faker(new Locale("ru"));
    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = fakerRu.name().firstName(),
            lastName = fakerRu.name().lastName(),
            email = fakerEn.internet().emailAddress(),
            gender = "Male",
            userNumber = fakerRu.phoneNumber().subscriberNumber(10),
            keyForSubjects = "c",
            subjects = "Computer Science",
            hobbies = "Sports",
            picture = "selenide-logo-big.png",
            currentAddress = fakerRu.address().fullAddress(),
            state = "NCR",
            city = "Delhi",
            title = "Thanks for submitting the form";

    @BeforeAll
    static void setUpTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate("25", "June", "1995")
                .setSubjects(keyForSubjects, subjects)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit()
                .checkResultTitle(title)
                .checkResultStudentName("Student Name", firstName, lastName)
                .checkResultStudentEmail("Student Email", email)
                .checkResultGender("Gender", gender)
                .checkResultMobile("Mobile", userNumber)
                .checkResultDateOfBirth("Date of Birth", "25 June,1995")
                .checkResultSubjects("Subjects", subjects)
                .checkResultHobbies("Hobbies", hobbies)
                .checkResultPicture("Picture", picture)
                .checkResultAddress("Address", currentAddress)
                .checkResultStateAndCity("State and City", state, city);

    }
}

