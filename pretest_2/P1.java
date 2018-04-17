package pretest_2;

import java.util.*;
/**
 * Problem 1
 */
public class P1 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {   //프로그램의 시작부
        int[] job = new int[5];
        int answer; //이 변수에 답을 저장한다
        for(int i = 0 ; i < 5; i++){
            job[i] = scanner.nextInt();
        }

        int min = Math.min(job[0], job[1]);
        int max = Math.max(job[0], job[1]);
        int secondMin = max;    // 초기화 방법*

        for (int i = 2; i < job.length; i ++) {
            if (max < job[i]) {
                max = job[i];
            }
            else if (min > job[i]) {
                secondMin = min;
                min = job[i];
            } else if (secondMin > job[i]) {
                secondMin = job[i];
            }
        }

        answer = Math.max(min + secondMin, max);

        //정답을 출력한다
        System.out.printf("%d\n", answer);
    }
}
