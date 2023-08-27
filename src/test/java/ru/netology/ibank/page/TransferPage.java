package ru.netology.ibank.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.ibank.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement header = $("[data-test-id=dashboard]");
    private SelenideElement amount =  $("[data-test-id=amount] input");
    private SelenideElement cardFrom =$("[data-test-id=from] input");
    private SelenideElement replenish =$("[data-test-id=action-transfer]");
    public TransferPage() {
        header.shouldBe(visible);
    }

        public TransferPage transfer (String sum, DataHelper.CardNumber cardNumber) {
        amount.setValue(sum);
        cardFrom.setValue(cardNumber.getCard());
        replenish.click();
        return new TransferPage();
    }

}
