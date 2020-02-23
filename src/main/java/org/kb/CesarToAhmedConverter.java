package org.kb;

public class CesarToAhmedConverter {
    public int convert(String cesarInput) {
        char[] cesars = cesarInput.toCharArray();
        int ahmedResult = 0;

        for (int i = 0; i < cesars.length; i++) {
            if (cesars.length > 1) {
                if (cesars[i] >= cesars[i + 1]) {
                    ahmedResult = addingAhmedResult(cesarInput, ahmedResult);
                } else {
                    ahmedResult = subtractingAhmedResult(cesarInput, ahmedResult);
                }
            } else {
                ahmedResult = gettingAhmedResult(cesarInput, ahmedResult);
            }
        }
        return ahmedResult;
    }

    private int gettingAhmedResult(String cesarInput, int ahmedResult) {
        if (cesarInput.equals("I")) {
            ahmedResult = 1;
        } else if (cesarInput.equals("V")) {
            ahmedResult = 5;
        } else if (cesarInput.equals("X")) {
            ahmedResult = 10;
        } else if (cesarInput.equals("L")) {
            ahmedResult = 50;
        } else if (cesarInput.equals("C")) {
            ahmedResult = 100;
        } else if (cesarInput.equals("D")) {
            ahmedResult = 500;
        } else if (cesarInput.equals("M")) {
            ahmedResult = 1000;
        }
        return ahmedResult;
    }

    private int subtractingAhmedResult(String cesarInput, int ahmedResult) {
        if (cesarInput.equals("I")) {
            ahmedResult -= 1;
        } else if (cesarInput.equals("V")) {
            ahmedResult -= 5;
        } else if (cesarInput.equals("X")) {
            ahmedResult -= 10;
        } else if (cesarInput.equals("L")) {
            ahmedResult -= 50;
        } else if (cesarInput.equals("C")) {
            ahmedResult -= 100;
        } else if (cesarInput.equals("D")) {
            ahmedResult -= 500;
        } else if (cesarInput.equals("M")) {
            ahmedResult -= 1000;
        }
        return ahmedResult;
    }

    private int addingAhmedResult(String cesarInput, int ahmedResult) {
        if (cesarInput.equals("I")) {
            ahmedResult += 1;
        } else if (cesarInput.equals("V")) {
            ahmedResult += 5;
        } else if (cesarInput.equals("X")) {
            ahmedResult += 10;
        } else if (cesarInput.equals("L")) {
            ahmedResult += 50;
        } else if (cesarInput.equals("C")) {
            ahmedResult += 100;
        } else if (cesarInput.equals("D")) {
            ahmedResult += 500;
        } else if (cesarInput.equals("M")) {
            ahmedResult += 1000;
        }
        return ahmedResult;
    }
}