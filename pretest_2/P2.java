package pretest_2;

import java.util.*;

/**
 * Problem 2
 */
public class P2 {

    //표준입력을 수행할 Scanner를 선언한다
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args)
    {   //프로그램의 시작부
        //첫 번째 점 P의 좌표
        int px = scanner.nextInt();
        int py = scanner.nextInt();
        //두 번째 점 Q의 좌표
        int qx = scanner.nextInt();
        int qy = scanner.nextInt();
        String answer;

        if (px - qx == 0 && py - qy == 0) answer = "DOT";
        else if (px - qx == 0 || py - qy == 0) answer = "SEGMENT";
        else if (px - qx == py - qy) answer = "SQUARE";
        else answer = "RECTANGLE";

        System.out.println(answer);
    }
}
