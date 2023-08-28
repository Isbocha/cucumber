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

    @Пусть("пользователь залогинен с именем {string} и паролем {string}")
    public void authPage(String login, String password) {
        loginPage = Selenide.open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getOthersInfo(login, password);
        var verificationPage = loginPage.validLogin(authInfo);
        dashboardPage = verificationPage.validVerify(DataHelper.getVerificationCodeFor());
    }

    @Когда("пользователь переводит {string} рублей с карты с номером {string} на свою {int} карту с главной страницы,")
    public void transfer(String amount, String firstNumberCard, int secondNumberCard) {
        var secondCard = DataHelper.getCardIndex(secondNumberCard);
        var transferPage = dashboardPage.transferPage(secondCard);
        transferPage.transfer(amount, DataHelper.getCardNumber(firstNumberCard));
    }

    @Тогда("баланс его {int} карты из списка на главной странице должен стать {int} рублей.")
    public void balance(int cardNumber, int newBalance) {
        var cardIndex = cardNumber - 1;
        var actualBalance = dashboardPage.getCardBalanceForIndex(cardIndex);
        Assertions.assertEquals(newBalance, actualBalance);
    }
}

