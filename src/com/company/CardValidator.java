package com.company;

import java.util.ArrayList;
import java.util.List;

public class CardValidator {
    long cardNum;

    public CardValidator(String cardNum) {
        this.cardNum = processCardNum(cardNum);
    }

    public boolean isCardNumValid() {
        return sumOfDigits() % 10 == 0;
    }

    public int sumOfDigits() {
        List<Long> numberForEverySecondDigit = getNumberForEverySecondDigit(cardNum);

        if (numberForEverySecondDigit.isEmpty()) return (int)cardNum;

        long tempCardNum = cardNum;
        int sum = 0;

        for(int i = 0; i < numberForEverySecondDigit.size(); i++) {
            sum += sumOfSingleDigit(numberForEverySecondDigit.get(i));
            sum += tempCardNum % 10;
            tempCardNum = tempCardNum / 100;
        }

        if(tempCardNum > 0) {
            sum += tempCardNum % 10;
        }

        return sum;
    }

    public int sumOfSingleDigit(long num) {
        String sumStr = String.valueOf(num);
        int sum = 0;
        for(char c: sumStr.toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }

    List<Long> getNumberForEverySecondDigit(long cardNum) {
        List<Long> listOfSums = new ArrayList<>();
        cardNum = cardNum / 10;

        while(cardNum > 0) {
            listOfSums.add((cardNum % 10) * 2);
            cardNum = cardNum / 100;
        }
        return listOfSums;
    }

    long processCardNum(String cardNum) {
        cardNum = cardNum.strip();
        if (cardNum.isEmpty()) throw new RuntimeException("The credit card number is empty");
        char[] charArray = cardNum.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(char character: charArray) {
            if(Character.isDigit(character)) {
                builder.append(character);
            } else if (character == ' ') {
               continue;
            } else {
                throw new RuntimeException("The credit card number contains characters other than space or digits");
            }
        }
        return Long.parseLong(builder.toString());
    }
}
