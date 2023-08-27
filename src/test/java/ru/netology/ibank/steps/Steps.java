package ru.netology.ibank.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.netology.ibank.data.DataHelper;
import ru.netology.ibank.page.DashboardPage;
import ru.netology.ibank.page.LoginPage;
import ru.netology.ibank.page.TransferPage;
import ru.netology.ibank.page.VerificationPage;

public class Steps {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static VerificationPage verificationPage;
    private static TransferPage transferPage;

    @Пусть("пользователь залогинен с именем «vasya» и паролем «qwerty123»")
    public void authPage(String login, String password) {
        loginPage = Selenide.open("http://localhost:9999", LoginPage.class);
        var code = DataHelper.getAuthInfo();
        var authInfo = DataHelper.getOthersInfo(login, password);
        var verificationPage = loginPage.validLogin(authInfo);
        dashboardPage = verificationPage.validVerify(DataHelper.getVerificationCodeFor(code));
    }

    @Когда("когда пользователь переводит 5 000 рублей с карты с номером 5559 0000 0000 0002 на свою 1 карту с главной страницы,")
    public void transfer(String amount, String firstNumberCard, int secondNumberCard) {
        var cardNumber1 = DataHelper.getFirstCardNumber();
        var cardNumber2 = DataHelper.getSecondCardNumber();
        var transferPage = dashboardPage.transferPage1(cardNumber1);
        var dashboardPage = transferPage.transfer(amount, cardNumber2);
    }

    @Тогда("баланс его 1 карты из списка на главной странице должен стать 15 000 рублей.")
    public void balance(int cardNumber, int newBalance) {
        cardNumber = dashboardPage.getFirstCardBalance();
        Assertions.assertEquals(newBalance, cardNumber);
    }
}

