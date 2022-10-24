package org.skan.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
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

        Configuration.baseUrl="https://demoqa.com";
        Configuration.holdBrowserOpen=true;
        //Configuration.pageLoadTimeout=150000;
        Configuration.browserSize="1920x1080";
        Configuration.remote="https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
}
