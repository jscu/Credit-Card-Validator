package com.company;

import org.junit.Assert;
import org.junit.Test;

public class UnitTest {
    @Test(expected = RuntimeException.class)
    public void isCardNumValid_cardNumberContainsInvalidChars_throwsException() {
        CardValidator cardValidator = new CardValidator("17394%@");
    }

    @Test
    public void isCardNumValid_cardNumberContainsSpaceAndValid_true() {
        CardValidator cardValidator = new CardValidator(" 0");
        boolean result = cardValidator.isCardNumValid();
        Assert.assertTrue(result);
    }

    @Test
    public void isCardNumValid_cardNumberContainsSpaceAndInValid_false() {
        CardValidator cardValidator = new CardValidator(" 5");
        boolean result = cardValidator.isCardNumValid();
        Assert.assertFalse(result);
    }

    @Test
    public void isCardNumValid_cardNumberValid_true() {
        CardValidator cardValidator = new CardValidator("49927398716");
        boolean result = cardValidator.isCardNumValid();
        Assert.assertTrue(result);
    }
}
