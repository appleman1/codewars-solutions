package com.falkenberg.viktor.codewars.kata2;

public class Solution {
    public static void main(String[] args) {
        System.out.println(nextBiggerNumber(12L));
        System.out.println(nextBiggerNumber(513));
        System.out.println(nextBiggerNumber(2017));
        System.out.println(nextBiggerNumber(414));
        System.out.println(nextBiggerNumber(144));
        System.out.println(nextBiggerNumber(10990));
    }

    public static long nextBiggerNumber(long n) {
        String[] splitN = String.valueOf(n).split("");

        for (int i = splitN.length - 1; i > 0; i--) {
            if (Integer.parseInt(splitN[i]) > Integer.parseInt(splitN[i - 1])) {
                String buf = splitN[i];
                splitN[i] = splitN[i - 1];
                splitN[i - 1] = buf;
                break;
            }
        }

        String result = String.join("", splitN);
        return  Long.parseLong(result);
//        List<Integer> numbers = new ArrayList<>();
//        int finishIndex = 0;
//        if (splitN.length == 1) {
//            return -1L;
//        } else {
//            int i = splitN.length - 1;
//            while (i != 0) {
//                int nextN = Integer.parseInt(splitN[i - 1]);
//                int currentN = Integer.parseInt(splitN[i]);
//                numbers.add(currentN);
//                if ((currentN < nextN) || (currentN > nextN && i == splitN.length - 1)) {
//                    splitN[i - 1] = String.valueOf(++nextN);
//                    finishIndex = i;
//                    break;
//                }
//                i--;
//            }
//
//        }
//        if (numbers.size() == splitN.length) {
//            return -1L;
//        }
//        Collections.sort(numbers);
//        String result = Stream.concat(Arrays.stream(splitN).limit(finishIndex), numbers.stream().map(Objects::toString))
//            .collect(Collectors.joining());
//        return Long.getLong(result);
    }
}
