package ru.netology.ibank.test;

import org.junit.jupiter.api.*;
import ru.netology.ibank.data.DataHelper;
import ru.netology.ibank.page.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");

    }

    @Test
    @DisplayName("1 Should Successful Transfer From First Card To Second Of The Amount 1000")
    void test01 () { //shouldSuccessfulTransferFromFirstCardToSecondOfTheAmount

        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var cardNumber1 = DataHelper.getFirstCardNumber();
        var cardNumber2 = DataHelper.getSecondCardNumber();
        var transferPage = dashboardPage.transferPage1(cardNumber1);
        var transferMoney = transferPage.transfer("1000", cardNumber2);
        Assertions.assertEquals(11_000, dashboardPage.getFirstCardBalance());
        Assertions.assertEquals(9_000, dashboardPage.getSecondCardBalance());
    }
    @Test
    @DisplayName("2 Should Successful Transfer From Second Card To First Of The Amount 1000")
    void test02() { //shouldSuccessfulTransferFromSecondCardToFirstOfTheAmount

        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var cardNumber1 = DataHelper.getFirstCardNumber();
        var cardNumber2 = DataHelper.getSecondCardNumber();
        var transferPage = dashboardPage.transferPage2(cardNumber2);
        var transferMoney = transferPage.transfer("1000", cardNumber1);
        Assertions.assertEquals(10_000, dashboardPage.getFirstCardBalance());
        Assertions.assertEquals(10_000, dashboardPage.getSecondCardBalance());
    }
    @Test
    @DisplayName("3 Should Successful Transfer From First Card To Second Of The Amount 0")
    void test03() { //shouldSuccessfulTransferFromFirstCardToSecondOfTheAmountZero

        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var cardNumber1 = DataHelper.getFirstCardNumber();
        var cardNumber2 = DataHelper.getSecondCardNumber();
        var transferPage = dashboardPage.transferPage1(cardNumber1);
        var transferMoney = transferPage.transfer("", cardNumber2);
        Assertions.assertEquals(10_000, dashboardPage.getFirstCardBalance());
        Assertions.assertEquals(10_000, dashboardPage.getSecondCardBalance());
    }
    @Test
    @DisplayName("4 Should Successful Transfer From Second Card To First Of The Amount 0")
    void test04() { //shouldSuccessfulTransferFromSecondCardToFirstOfTheAmountZero

        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var cardNumber1 = DataHelper.getFirstCardNumber();
        var cardNumber2 = DataHelper.getSecondCardNumber();
        var transferPage = dashboardPage.transferPage2(cardNumber2);
        var transferMoney = transferPage.transfer("", cardNumber1);
        Assertions.assertEquals(10_000, dashboardPage.getFirstCardBalance());
        Assertions.assertEquals(10_000, dashboardPage.getSecondCardBalance());
    }
    @Test
    @DisplayName("5 Should Successful Transfer From First Card To Second Of The Amount 1")
    void  test05 () { //shouldSuccessfulTransferFromFirstCardToSecondOfTheAmountOne

        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var cardNumber1 = DataHelper.getFirstCardNumber();
        var cardNumber2 = DataHelper.getSecondCardNumber();
        var transferPage = dashboardPage.transferPage1(cardNumber1);
        var transferMoney = transferPage.transfer("1", cardNumber2);
        Assertions.assertEquals(10_001, dashboardPage.getFirstCardBalance());
        Assertions.assertEquals(9_999, dashboardPage.getSecondCardBalance());
    }
    @Test
    @DisplayName("6 Should Successful Transfer From Second Card To First Of The Amount 1")
    void test06 () { //shouldSuccessfulTransferFromSecondCardToFirstOfTheAmountOne

        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var cardNumber1 = DataHelper.getFirstCardNumber();
        var cardNumber2 = DataHelper.getSecondCardNumber();
        var transferPage = dashboardPage.transferPage2(cardNumber2);
        var transferMoney = transferPage.transfer("1", cardNumber1);
        Assertions.assertEquals(10_000, dashboardPage.getFirstCardBalance());
        Assertions.assertEquals(10_000, dashboardPage.getSecondCardBalance());
    }
    @Test
    @DisplayName("7 Should Successful Transfer From First Card To Second Of The Amount 10_000")
    void test07 () { //shouldSuccessfulTransferFromFirstCardToSecondOfTheAmountTenThousand

        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var cardNumber1 = DataHelper.getFirstCardNumber();
        var cardNumber2 = DataHelper.getSecondCardNumber();
        var transferPage = dashboardPage.transferPage1(cardNumber1);
        var transferMoney = transferPage.transfer("10000", cardNumber2);
        Assertions.assertEquals(20_000, dashboardPage.getFirstCardBalance());
        Assertions.assertEquals(0, dashboardPage.getSecondCardBalance());
    }
    @Test
    @DisplayName("8 Should Successful Transfer From Second Card To First Of The Amount 10_000")
    void test08 () { //shouldSuccessfulTransferFromSecondCardToFirstOfTheAmountTenThousand

        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var cardNumber1 = DataHelper.getFirstCardNumber();
        var cardNumber2 = DataHelper.getSecondCardNumber();
        var transferPage = dashboardPage.transferPage2(cardNumber2);
        var transferMoney = transferPage.transfer("10000", cardNumber1);
        Assertions.assertEquals(10_000, dashboardPage.getFirstCardBalance());
        Assertions.assertEquals(10_000, dashboardPage.getSecondCardBalance());
    }
    @Test
    @DisplayName("9 Should Successful Transfer From First Card To Second Of The Amount 100_000")
    void test09 () { //shouldSuccessfulTransferFromFirstCardToSecondOfTheAmountOneHundredThousand
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var cardNumber1 = DataHelper.getFirstCardNumber();
        var cardNumber2 = DataHelper.getSecondCardNumber();
        var transferPage = dashboardPage.transferPage1(cardNumber1);
        var transferMoney = transferPage.transfer("100000", cardNumber2);
        Assertions.assertEquals(20_000, dashboardPage.getFirstCardBalance());
        Assertions.assertEquals(0, dashboardPage.getSecondCardBalance());
        var transferPage2 = dashboardPage.transferPage2(cardNumber2);
        var transferMoney2 = transferPage.transfer("100000", cardNumber1);
    }
    @Test
    @DisplayName("10 Should Successful Transfer From Second Card To First Of The Amount 100_000")
    void test10 () { //shouldSuccessfulTransferFromSecondCardToFirstOfTheAmountOneHundredThousand

        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var cardNumber1 = DataHelper.getFirstCardNumber();
        var cardNumber2 = DataHelper.getSecondCardNumber();
        var transferPage = dashboardPage.transferPage2(cardNumber2);
        var transferMoney = transferPage.transfer("100000", cardNumber1);
        Assertions.assertEquals(10_000, dashboardPage.getFirstCardBalance());
        Assertions.assertEquals(10_000, dashboardPage.getSecondCardBalance());
    }
}
