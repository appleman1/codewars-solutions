package com.falkenberg.viktor.codewars.kata4;

import java.util.Arrays;

public class Solution {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";

    public static void main(String[] args) {
        System.out.println(Arrays.toString(flapDisplay(new String[] {"CAT"}, new int[][] {{1, 13, 27}})));

    }

    public static String[] flapDisplay(final String[] lines, final int[][] rotors) {
        String[] result = new String[lines.length];
        for (int i = 0; i < rotors.length; i++) {
            int[] rotor = rotors[i];
            for (int j = i; j < lines.length; j++) {
                String line = lines[j];
                String[] splitLine = line.split("");
                String[] splitAlphabet = ALPHABET.split("");
                StringBuilder builder = new StringBuilder();
                for (int n = 0; n < splitLine.length; n++) {
                    for (int m = 0; m < splitAlphabet.length; m++) {
                        if (splitLine[n].equals(splitAlphabet[m])) {
                            int sum = 0;
                            for (int p = 0; p <= n; p++) {
                                sum = sum + rotor[p];
                            }
                            int finalAddress = m + sum;
                            int val = finalAddress / splitAlphabet.length;
                            if (val > 0) {
                                finalAddress = finalAddress - (splitAlphabet.length * val);
                            }
                            builder.append(splitAlphabet[finalAddress]);
                        }
                    }
                }
                result[j] = builder.toString();
            }
        }

        return result;
    }
//not my
    public static String[] flapDisplay2(final String[] lines, final int[][] rotors) {
        // Your code here
        String [] board = new String[lines.length];
        for (int i = 0; i < lines.length; i++){
            int shift = 0;
            String line = "";
            for (int j = 0; j < lines[i].length(); j++){
                shift += rotors[i][j];
                line += ALPHABET.charAt((ALPHABET.indexOf(lines[i].charAt(j)) + shift) % ALPHABET.length());
            }
            board[i] = line;
        }
        return board;
    }
}
