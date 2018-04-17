package pretest_2;

import java.util.*;
/**
 * Problem 4
 */
public class P4
{
    //표준입력을 수행할 Scanner를 선언한다
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args)
    {   //프로그램의 시작부
        int N = scanner.nextInt();

        int[] x = new int[N];
        int[] y = new int[N];
        boolean[][] position = new boolean[1001][1001];
        for (int i = 0; i < N; i ++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
            position[x[i]][y[i]] = true;
        }

        // 거리, 갯수 저장
        int max = 0;
        for (int i = 0; i < N; i ++) {
            int x1 = x[i];
            int y1 = y[i];
            for (int j = i + 1; j < N; j ++) {
                int x2 = x[j];
                int y2 = y[j];

                int vectorX = x2 - x1;
                int vectorY = y2 - y1;

                // 90도 회전한 좌표
                int px = x1 - vectorY;
                int py = y1 + vectorX;
                int qx = x2 - vectorY;
                int qy = y2 + vectorX;

                if (Math.min(px,py) < 0 || Math.max(px, py) > 1000 || Math.min(qx,qy) < 0 || Math.max(qx,qy) > 1000) continue;
                if (position[px][py] && position[qx][qy]) {
                    int currSquare = vectorX * vectorX + vectorY * vectorY;
                    max = max > currSquare ? max : currSquare;
                }
            }
        }
        System.out.printf("%.2f\n", (double)max);
    }
}
