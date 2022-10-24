package org.skan.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.skan.helpers.Attach;
import org.skan.pages.RegistrationFormPage;
import org.skan.utils.Month;

public class BaseTest {

    Faker faker= new Faker();

    String firstName=faker.name().firstName(),
            lastName=faker.name().lastName(),
            email=faker.internet().emailAddress(),
            gender=faker.demographic().sex(),
            phone=faker.phoneNumber().subscriberNumber(10),
            day= String.valueOf(faker.number().numberBetween(10,28)),
            month= String.valueOf(Month.getRandomMonth()),
            year= String.valueOf(faker.number().numberBetween(1970,2004)),
            address=faker.address().fullAddress(),
            subject="Maths",
            hobbies="Sports",
            image="testpicture.jpeg",
            state="NCR",
            city="Delhi";

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @BeforeAll
    static void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("browserVersion", "100.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl="https://demoqa.com";
        Configuration.holdBrowserOpen=true;
        //Configuration.pageLoadTimeout=150000;
        Configuration.browserSize="1920x1080";
        Configuration.remote="https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
