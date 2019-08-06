package com.test.adneom;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class SumFromStringTest
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void when_string_is_null_return_zero() throws Exception{
        SumFromString sumFromString = new SumFromString();

        Assert.assertEquals(0L, sumFromString.sumFromColonDelimitedStringNumbers(null));
    }

    @Test
    public void when_string_is_empty_return_zero() throws Exception {
        SumFromString sumFromString = new SumFromString();

        Assert.assertEquals(0L, sumFromString.sumFromColonDelimitedStringNumbers(""));
    }

    @Test
    public void when_string_is_not_null_return_sum() throws Exception {
        SumFromString sumFromString = new SumFromString();

        Assert.assertEquals(6L, sumFromString.sumFromColonDelimitedStringNumbers("1;2;3"));
    }

    @Test(expected = Exception.class)
    public void when_string_is_not_valid_comma_limited_throws_exception() throws Exception {
        SumFromString sumFromString = new SumFromString();
        sumFromString.validateAndConvertNumber("1,2,3");
    }

    @Test(expected = Exception.class)
    public void when_string_is_not_valid_space_throws_exception() throws Exception {
        SumFromString sumFromString = new SumFromString();
        sumFromString.validateAndConvertNumber(" 1");
    }

    @Test
    public void when_string_is_valid_with_multiple_delimiters_return_sum() throws Exception {
        SumFromString sumFromString = new SumFromString();

        String testString = "1" + SumFromString.DELIMITER1 + "2" + SumFromString.DELIMITER2 + "3";

        Assert.assertEquals(6L, sumFromString.sumFromColonDelimitedStringNumbers(testString));
    }

    @Test
    public void when_string_is_valid_with_different_delimiter_return_sum() throws Exception {
        SumFromString sumFromString = new SumFromString();

        String testString = "1" + SumFromString.DELIMITER2 + "2" + SumFromString.DELIMITER2 + "3";

        Assert.assertEquals(6L, sumFromString.sumFromColonDelimitedStringNumbers(testString));
    }

    @Test
    public void when_string_is_valid_and_contains_number_superior_to_max_return_sum() throws Exception {
        SumFromString sumFromString = new SumFromString();

        String testString = "1" + SumFromString.DELIMITER2 + "1005" + SumFromString.DELIMITER2 + "3";

        Assert.assertEquals(4L, sumFromString.sumFromColonDelimitedStringNumbers(testString));
    }
}
