package org.skan.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PracticeFormWithFakerTest extends BaseTest {

    @Feature("Формы на сайте https://demoqa.com")
    @Story("Создание формы Practice Form")
    @Owner("serhiikan")
    @DisplayName("Проверка заполнения формы")
    @Test
    void fillPracticeFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(day, month,year)
                .setSubject(subject)
                .chooseHobbies(hobbies)
                .uploadImage("src/test/resources/"+image)
                .setAddress(address)
                .selectState(state)
                .selectCity(city)
                .checkResultsTableVisible()
                .checkResult("Student Name", firstName+" "+lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", day+" "+month+","+year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", image)
                .checkResult("Address", address)
                .checkResult("State and City", state+" "+city);

    }
}
