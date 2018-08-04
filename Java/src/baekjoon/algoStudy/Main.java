package baekjoon.algoStudy;

import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] inputs = new int[n + 1];
        long[] sums = new long[n + 1];

        long sum = 0;
        double smallTemp = 999999999;

        for (int i = 1; i <= n; i++) {
            inputs[i] = sc.nextInt();
            sum += inputs[i];
            sums[i] = sum;

            if (i >= k) {
                double average = (double)(sums[i] - sums[i - k]) / k;
                double temp = 0;
                for (int j = i; j > i - k; j--)
                    temp += Math.pow(inputs[j] - average, 2);

                if (smallTemp > temp)
                    smallTemp = temp;
            }
        }

        DecimalFormat form = new DecimalFormat("#.###########");
        double dNumber = Math.sqrt(smallTemp / k);
        System.out.println(form.format(dNumber)); //10.12 출력
//        String answer = String.format("%.11f", Math.sqrt(smallTemp / k));
//        System.out.println(answer);
//        System.out.println(Math.sqrt(smallTemp / k));
    }
}