package pretest_1;

import java.util.*;
import java.io.*;
/**
 * Problem 3
 */
public class P3 {

    public static void simulate(int[][] m, int r, int c)
    {
        int nowR = 0;
        int nowC = 0;
        int flag = 0;
        int[] rM = {0, 1, 0, -1};
        int[] cM = {1, 0, -1, 0};
        int count = 1;

        while (count <= r * c) {
            m[nowR][nowC] = count;
            count ++;

            if (nowR + rM[flag] >= r || nowR + rM[flag] < 0 || nowC + cM[flag] >= c || nowC + cM[flag] < 0 || m[nowR + rM[flag]][nowC + cM[flag]] != 0) {
                flag ++;
                flag %= 4;
            }

            nowR += rM[flag];
            nowC += cM[flag];
        }
    }

    /*
        ** 메인 함수에는 테스트케이스와 입출력에 대한 기본적인 뼈대 코드가 작성되어 있습니다.
        ** 상단의 함수만 완성하여도 문제를 해결할 수 있으며,
        ** 메인 함수를 제거한 후 스스로 코드를 모두 작성하여도 무방합니다.
        ** 단, 스스로 작성한 코드로 인해 발생한 에러 등은 모두 참가자에게 책임이 있습니다.
        */
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트케이스의 수를 입력받는다
        int caseNum = scanner.nextInt();

        //각 테스트케이스에 대하여 순서대로 데이터를 입력받고 정답을 출력한다
        for(int caseIndex = 1; caseIndex <= caseNum; caseIndex++)
        {
            //행과 열의 수를 입력받는다
            int r = scanner.nextInt();
            int c = scanner.nextInt();

            //0으로 초기화 된 r행 c열의 벡터를 생성한다
            int[][] m = new int[r][c];

            //주어진 함수를 실행하여 각 칸을 로봇 청소기가 방문하는 순서를 벡터에 계산한다
            simulate(m, r, c);

            //케이스 번호를 출력한다
            writer.write(String.format("Case #%d\n", caseIndex));

            //각 칸의 방문 순서를 출력 형식에 맞게 출력한다
            for(int i = 0 ; i < r ; i ++)
            {
                for(int j = 0 ; j < c ; j++)
                {
                    if(j > 0)
                        writer.write(" ");
                    writer.write(String.format("%d", m[i][j]));
                }
                writer.write("\n");
                writer.flush();
            }
        }
        writer.close();
    }
}
