
// package ru.ak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.ak.emailvalidator.Validator;

public class EmailTest {

    private Validator validator = new Validator();

    @Test
    void address_1() {
        Assertions.assertTrue(this.validator.isValid("test@test.com", true));
    }

    @Test
    void address_2() {
        Assertions.assertFalse(this.validator.isValid("test@test", true));
    }

    @Test
    void address_3() {
        Assertions.assertFalse(this.validator.isValid("test#@test.com", true));
    }

    @Test
    void address_4() {
        Assertions.assertFalse(this.validator.isValid("test@test@test.com", false));
    }

    @Test
    void address_5() {
        Assertions.assertTrue(this.validator.isValid("test-test@test.com", true));
    }
}