package com.test.adneom;

public class SumFromString
{
    public static final String DELIMITER1 = ";";
    public static final String DELIMITER2 = "|";
    public static final String REGEX_DELIMITER = String.format("[%s\\%s]", DELIMITER1, DELIMITER2);

    public static final long MAX_NUMBER = 1000;

    public long sumFromColonDelimitedStringNumbers(String numbers) throws Exception {

        if(numbers == null || numbers.isEmpty()) {
            return 0L;
        }

        String [] arrayOfStringNumbers = numbers.split(REGEX_DELIMITER);

        long sum = 0L;
        for (String number : arrayOfStringNumbers) {

            long numberAsLong = validateAndConvertNumber(number);

            if (numberAsLong <= MAX_NUMBER) {
                sum += Long.parseLong(number);
            }
        }

        return sum;
    }

    public long validateAndConvertNumber(String number) throws Exception {
        try {
            return Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new Exception(number + " is not a number");
        }
    }
}
