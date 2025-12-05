package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void hasMinLength_ShouldReturnFalse_WhenPasswordLengthLessThanMinLength() {
        //GIVEN
            String password = "12345678";
            int length = password.length() + 1;
            boolean expected = false;
        //WHEN
            boolean actual = PasswordValidator.hasMinLength(password, length);
        //THEN
            assertEquals(expected, actual);
    }

    @Test
    void hasMinLength_ShouldReturnFalse_WhenPasswordIsNull() {
        //GIVEN
        String password = null;
        int length = 8;
        boolean expected = false;
        //WHEN
        boolean actual = PasswordValidator.hasMinLength(password, length);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void hasMinLength_ShouldReturnTrue_WhenPasswordLengthEqualMinLength() {
        //GIVEN
        String password = "123456789";
        int length = 9;
        boolean expected = true;
        //WHEN
        boolean actual = PasswordValidator.hasMinLength(password, length);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    void containsDigit_ShouldReturnTrue_WhenPasswordContainsDigit() {
        //GIVEN
            String password = "sss2ssss";
            boolean expected = true;
        //WHEN
            boolean actual = PasswordValidator.containsDigit(password);
        //THEN
            assertEquals(expected, actual);
    }

    @Test
    void containsUpperAndLower_ShouldReturnTrue_WhenPasswordContainsUpperChar() {
        //GIVEN
            String password = "ssS2ssss";
            boolean expected = true;
        //WHEN
            boolean actual = PasswordValidator.containsUpperAndLower(password);
        //THEN
            assertEquals(expected, actual);
    }

    @Test
    void containsUpperAndLower_ShouldReturnFalse_WhenPasswordNotContainsLowerChar() {
        //GIVEN
            String password = "QWERTYYUU";
            boolean expected = false;
        //WHEN
            boolean actual = PasswordValidator.containsUpperAndLower(password);
        //THEN
            assertEquals(expected, actual);
    }

    @Test
    void containsUpperAndLower_ShouldReturnFalse_WhenPasswordIsOnlyOneCharacter() {
        //GIVEN
            String password = "Q";
            boolean expected = false;
        //WHEN
            boolean actual = PasswordValidator.containsUpperAndLower(password);
        //THEN
            assertEquals(expected, actual);
    }

    @Test
    void isCommonPassword_ShouldReturnTrue_WhenPasswordIs12345678() {
        //GIVEN
            String password = "12345678";
            boolean expected = true;
        //WHEN
            boolean actual = PasswordValidator.isCommonPassword(password);
        //THEN
            assertEquals(expected, actual);
    }

    @Test
    void containsSpecialChar_ShouldReturnTrue_WhenPasswordWithSpecialCharDot() {
        //GIVEN
            String password = "12adf.45678";
            String specialChar = ".";
            boolean expected = true;
        //WHEN
            boolean actual = PasswordValidator.containsSpecialChar(password, specialChar);
        //THEN
            assertEquals(expected, actual);
    }

    @Test
    void containsSpecialChar_ShouldReturnFalse_WhenPasswordWithNotSpecialCharQuestion() {
        //GIVEN
            String password = "12adf.45678";
            String specialChar = "?";
            boolean expected = false;
        //WHEN
            boolean actual = PasswordValidator.containsSpecialChar(password, specialChar);
        //THEN
            assertEquals(expected, actual);
    }

    @Test
    void isValid_shouldReturnTrue_WhenPasswordIsValid() {
        //GIVEN
            String password = "12adf.4567Ab8";
            boolean expected = true;
        //WHEN
            boolean actual = PasswordValidator.isValid(password);
        //THEN
         assertEquals(expected, actual);
    }

    @Test
    void isValid_shouldReturnFalse_WhenPasswordIsInvalid() {
        //GIVEN
            String password = "abcdefg1";
            boolean expected = false;
        //WHEN
            boolean actual = PasswordValidator.isValid(password);
        //THEN
            assertEquals(expected, actual);
    }
}