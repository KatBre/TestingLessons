package org.kb;

//public class CesarToAhmedConverter {
//    public int convert(String cesarInput) {
//        char[] cesars = cesarInput.toCharArray();
//        int ahmedResult = 0;
//
//        for (int i = 0; i < cesars.length - 1; i++) {
//            if (cesars.length > 1) {
//                if (cesars[i] >= cesars[i + 1]) {
//                    ahmedResult = addingAhmedResult(cesarInput, ahmedResult);
//                } else {
//                    ahmedResult = subtractingAhmedResult(cesarInput, ahmedResult);
//                }
//            } else {
//                ahmedResult = gettingAhmedResult(cesarInput, ahmedResult);
//            }
//        }
//        return ahmedResult;
//    }
//
//    private int gettingAhmedResult(String cesarInput, int ahmedResult) {
//        if (cesarInput.equals("I")) {
//            ahmedResult = 1;
//        } else if (cesarInput.equals("V")) {
//            ahmedResult = 5;
//        } else if (cesarInput.equals("X")) {
//            ahmedResult = 10;
//        } else if (cesarInput.equals("L")) {
//            ahmedResult = 50;
//        } else if (cesarInput.equals("C")) {
//            ahmedResult = 100;
//        } else if (cesarInput.equals("D")) {
//            ahmedResult = 500;
//        } else if (cesarInput.equals("M")) {
//            ahmedResult = 1000;
//        }
//        return ahmedResult;
//    }
//
//    private int subtractingAhmedResult(String cesarInput, int ahmedResult) {
//        if (cesarInput.equals("I")) {
//            ahmedResult -= 1;
//        } else if (cesarInput.equals("V")) {
//            ahmedResult -= 5;
//        } else if (cesarInput.equals("X")) {
//            ahmedResult -= 10;
//        } else if (cesarInput.equals("L")) {
//            ahmedResult -= 50;
//        } else if (cesarInput.equals("C")) {
//            ahmedResult -= 100;
//        } else if (cesarInput.equals("D")) {
//            ahmedResult -= 500;
//        } else if (cesarInput.equals("M")) {
//            ahmedResult -= 1000;
//        }
//        return ahmedResult;
//    }
//
//    private int addingAhmedResult(String cesarInput, int ahmedResult) {
//        if (cesarInput.equals("I")) {
//            ahmedResult += 1;
//        } else if (cesarInput.equals("V")) {
//            ahmedResult += 5;
//        } else if (cesarInput.equals("X")) {
//            ahmedResult += 10;
//        } else if (cesarInput.equals("L")) {
//            ahmedResult += 50;
//        } else if (cesarInput.equals("C")) {
//            ahmedResult += 100;
//        } else if (cesarInput.equals("D")) {
//            ahmedResult += 500;
//        } else if (cesarInput.equals("M")) {
//            ahmedResult += 1000;
//        }
//        return ahmedResult;
//    }
//}
public class CesarToAhmedConverter  {
    // przyjmuje stringa,który jest liczbą rzymską i zwraca arabską
    public int valueOfSingleRoman(char singleRoman) {
        int result = 0;
        if (singleRoman == 'I') {
            result = 1;
        }
        if (singleRoman == 'V') {
            result = 5;
        }
        if (singleRoman == 'X') {
            result = 10;
        }
        if (singleRoman == 'L') {
            result = 50;
        }
        if (singleRoman == 'C') {
            result = 100;
        }
        if (singleRoman == 'D') {
            result = 500;
        }
        if (singleRoman == 'M') {
            result = 1000;
        }
        return result;
    }
    public int convertRomanToArabic(String RomanNumber) {
        char[] chars = RomanNumber.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length-1; i++) {
            char current = chars[i];
            char next = chars[i+1];
            int currentValue = valueOfSingleRoman(current);
            int nextValue = valueOfSingleRoman(next);
            if (currentValue >= nextValue) {
                sum = sum + valueOfSingleRoman(current);
            } else {
                sum = sum - valueOfSingleRoman(current);
            }
        }
        return sum+valueOfSingleRoman(chars[chars.length-1]);
    }
}