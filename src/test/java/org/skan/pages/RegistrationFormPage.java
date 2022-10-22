package org.skan.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.skan.pages.components.CalendarComponent;
import org.skan.pages.components.ResultsTableComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private CalendarComponent calendarComponent=new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderElement = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            birthDateInput=$("#dateOfBirthInput"),
            subjectInput=$("#subjectsInput"),
            hobbiesElement=$("#hobbiesWrapper"),
            uploadInput = $("#uploadPicture"),
            addressInput=$("#currentAddress"),
            stateInput=$("#react-select-3-input"),
            cityInput=$("#react-select-4-input");

    @Step("Открыть главную страницу")
    public RegistrationFormPage openPage (){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    @Step("Заполнить поле имя")
    public RegistrationFormPage setFirstName(String name){
        firstNameInput.setValue(name);
        return this;
    }

    @Step("Заполнить поле фамилия")
    public RegistrationFormPage setLastName(String name){
        lastNameInput.setValue(name);
        return this;
    }

    @Step("Ввести адрес электронной почты")
    public RegistrationFormPage setEmail(String email){
        emailInput.setValue(email);
        return this;
    }

    @Step("Выбрать пол")
    public RegistrationFormPage setGender(String value){
        genderElement.$(byText(value)).click();
        return this;
    }

    @Step("Ввести номер телефона")
    public RegistrationFormPage setPhone(String value){
        phoneInput.setValue(value);
        return this;
    }

    @Step("Выбрать дату рождения")
    public RegistrationFormPage setBirthDate(String day, String month, String year){
        birthDateInput.click();
        calendarComponent.setDate(day,month,year);
        return this;
    }

    @Step("Выбрать предмет")
    public RegistrationFormPage setSubject(String value){
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Выбрать увлечение")
    public RegistrationFormPage chooseHobbies(String value){
        hobbiesElement.$(byText(value)).click();
        return this;
    }

    @Step("Загрузить картинку")
    public RegistrationFormPage uploadImage(String path){
        uploadInput.uploadFile(new File(path));
        return this;
    }

    @Step("Заполнить адрес")
    public RegistrationFormPage setAddress(String value){
        addressInput.setValue(value);
        return this;
    }

    @Step("Выбрать штат")
    public RegistrationFormPage selectState(String value){
        stateInput.setValue(value).pressTab();
        return this;
    }
    @Step("Выбрать город")
    public RegistrationFormPage selectCity(String value){
        cityInput.setValue(value).pressEnter().pressEnter();
        return this;
    }

    @Step("Проверяем, что открылась таблица результатов")
    public RegistrationFormPage checkResultsTableVisible(){
        resultsTableComponent.checkVisible();
        return this;
    }

    @Step("Проверяем что поле {key} заполнено верно")
    public RegistrationFormPage checkResult(String key, String value){
        resultsTableComponent.checkResult(key, value);
        return this;
    }
}
