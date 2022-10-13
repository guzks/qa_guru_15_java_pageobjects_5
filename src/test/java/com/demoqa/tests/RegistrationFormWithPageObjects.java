package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationFormWithPageObjects {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {


        //ввод
        $("#firstName").setValue("Bananov");
        $("#lastName").setValue("Norman");
        $("#userEmail").setValue("banorman@demoqa.com");
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue("8909909909");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1997");
        $("[class*='react-datepicker__day--021']").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        File attach = new File("src/test/resources/1.PNG");
        $("#uploadPicture").uploadFile(attach);
        $("#currentAddress").setValue("current Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();

        //проверка
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $$(".table-responsive").findBy(text("Student Name")).shouldHave(text("Bananov Norman"));
        $$(".table-responsive").findBy(text("Student Email")).shouldHave(text("banorman@demoqa.com"));
        $$(".table-responsive").findBy(text("Gender")).shouldHave(text("Male"));
        $$(".table-responsive").findBy(text("Mobile")).shouldHave(text("8909909909"));
        $$(".table-responsive").findBy(text("Date of Birth")).shouldHave(text("21 April,1997"));
        $$(".table-responsive").findBy(text("Subjects")).shouldHave(text("History"));
        $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text("Music"));
        $$(".table-responsive").findBy(text("Picture")).shouldHave(text("1.PNG"));
        $$(".table-responsive").findBy(text("Address")).shouldHave(text("current Address"));
        $$(".table-responsive").findBy(text("State and City")).shouldHave(text("NCR Gurgaon"));
    }
}
