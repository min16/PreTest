package pretest_2;

import java.util.Scanner;

public class P1_1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] jobs = new int[5];
        for (int i = 0; i < jobs.length; i ++) {
            jobs[i] = sc.nextInt();
        }

        int firstMin = Math.min(jobs[0], jobs[1]);
        int secondMin = Math.max(jobs[0], jobs[1]);
        int max = secondMin;

        for (int i = 2; i < jobs.length; i ++) {
            if (jobs[i] < firstMin) {
                secondMin = firstMin;
                firstMin = jobs[i];
            } else if (jobs[i] < secondMin) {
                secondMin = jobs[i];
            } else if (jobs[i] > max) {
                max = jobs[i];
            }
        }
        int answer = Math.max(firstMin + secondMin, max);
        System.out.println(answer);
    }
}
