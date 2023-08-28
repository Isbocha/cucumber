package ru.netology.ibank.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.ibank.data.DataHelper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement header = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    private SelenideElement update = $("[data-test-id=action-reload]");

    public DashboardPage() {
        header.shouldBe(visible);
    }

    public TransferPage transferPage(DataHelper.CardNumber cardNumber) {
        cards.findBy(attribute("data-test-id", cardNumber.getCardID())).$("[data-test-id=action-deposit]").click();
        return new TransferPage();
    }

    public int getCardBalance(DataHelper.CardNumber cardNumber) {
        var text = cards.findBy(attribute("data-test-id", cardNumber.getCardID())).text();
        return extractBalance(text);
    }

    public int getCardBalanceForIndex(int index) {
        var text = cards.get(index).getText();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }


}
