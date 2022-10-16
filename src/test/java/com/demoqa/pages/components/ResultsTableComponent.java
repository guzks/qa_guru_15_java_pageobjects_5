package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultsTableComponent {

    private static final String TITLE_TEXT = "Thanks for submitting the form";
    public ResultsTableComponent checkVisible() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public ResultsTableComponent checkResults(String key, String value) {
        $$(".table-responsive").findBy(text(key)).shouldHave(text(value));
        return this;
    }
}
