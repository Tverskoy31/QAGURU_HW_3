package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Evgen");
        $("#lastName").setValue("Medvedev");
        $("#userEmail").setValue("Medvedev_test@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8911234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1900");
        $(".react-datepicker__month").$(byText("22")).click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("cat.jpg");
        $("#currentAddress").setValue("Мой текущий аддрес");
        $("#state").click();
        $(byText("Rajasthan")).click();
        $("#city").click();
        $(byText("Jaipur")).click();
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Merrut").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $$("tr").get(1).shouldHave(text("Evgen Medvedev"));
        $$("tr").get(2).shouldHave(text("Medvedev_test@mail.ru"));
        $$("tr").get(3).shouldHave(text("Male"));
        $$("tr").get(4).shouldHave(text("8911234567"));
        $$("tr").get(5).shouldHave(text("22 July,1900"));
        $$("tr").get(6).shouldHave(text("Arts"));
        $$("tr").get(7).shouldHave(text("Sports, Music"));
        $$("tr").get(8).shouldHave(text("cat.jpg"));
        $$("tr").get(9).shouldHave(text("Мой текущий аддрес"));
        $$("tr").get(10).shouldHave(text("Uttar Pradesh Merrut"));

        $("#closeLargeModal").click();
    }
}