package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjects {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()

                //ввод
                .setFirstName("Bananov")
                .setLastName("Norman")
                .setUserEmail("banorman@demoqa.com")
                .setGender("Male")
                .setNumber("8909909909")
                .setBirthDate("21", "April", "1997")
                .setSubjects("History")
                .setHobbies("Music")
                .setAttach("1.PNG")
                .setAddress("current Address")
                .setStateCity("NCR", "Gurgaon")
                .setSubmit()

                //проверка
                .checkResultsTableVisible()
                .checkResults("Student Name", "Bananov Norman")
                .checkResults("Student Email", "banorman@demoqa.com")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "8909909909")
                .checkResults("Gender", "Male")
                .checkResults("Date of Birth", "21 April,1997")
                .checkResults("Subjects", "History")
                .checkResults("Hobbies", "Music")
                .checkResults("Picture", "1.PNG")
                .checkResults("Address", "current Address")
                .checkResults("State and City", "NCR Gurgaon");
    }
}
