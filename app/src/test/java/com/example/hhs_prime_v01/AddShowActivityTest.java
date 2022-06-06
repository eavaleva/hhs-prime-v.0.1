package com.example.hhs_prime_v01;
import org.junit.Assert;
import org.junit.Test;



public class AddShowActivityTest {
    @Test
    public void
    inputValidString_should_return_false_when_string_contains_number() {
//Arrange
        String testString = "l33t";
//Act
        boolean result = Validator.inputValidString(testString);
//Assert
        Assert.assertFalse(result);
    }
}