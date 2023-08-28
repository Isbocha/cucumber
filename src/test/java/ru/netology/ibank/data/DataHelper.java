package ru.netology.ibank.data;

import lombok.Value;

import java.util.Random;

import static com.codeborne.selenide.Condition.attribute;

public class DataHelper {
    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOthersAutInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }

    public static AuthInfo getOthersInfo(String login, String password) {
        return new AuthInfo(login, password);
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor() {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardNumber {
        private String cardNumber;
        private String cardID;
    }

    public static CardNumber getFirstCardNumber() {
        return new CardNumber("5559 0000 0000 0001", "92df3f1c-a033-48e6-8390-206f6b1f56c0");
    }

    public static CardNumber getSecondCardNumber() {
        return new CardNumber("5559 0000 0000 0002", "0f3f5c2a-249e-4c3d-8287-09f7a039391d");
    }

    public static CardNumber getCardNumber(String cardNumber) {
        if (cardNumber.equals(getFirstCardNumber())) {
            return getFirstCardNumber();
        } else
            return getSecondCardNumber();
    }

    public static CardNumber getCardIndex(int index) {
        if (index == 1) {
            return getFirstCardNumber();
        } else
            return getSecondCardNumber();
    }
}
