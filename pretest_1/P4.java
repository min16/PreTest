package pretest_1;

import java.util.*;

/**
 * Problem 4
 *
 2
 3 0
 40 95 21
 */
public class P4 {
    public static int getLeastQuantities(int n, int g, int[] needs)
    {
        int answer = 0;
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int need : needs) {
            queue.add(need);
        }


        int[] minNeeds = new int[3];
        while (count < g) {
            for (int i = 0; i < minNeeds.length; i ++) {
                minNeeds[i] = queue.poll() + 1;
            }
            for (int i = 0; i < minNeeds.length; i ++) {
                queue.add(minNeeds[i]);
            }
            count ++;
        }
        while (queue.size() != 1) {
            queue.remove();
        }
        int maxAmount = queue.poll();

        answer = maxAmount / 50;
        if (maxAmount % 50 > 0) answer ++;
        return answer;
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

        //테스트케이스의 수를 입력받는다
        int caseNum = scanner.nextInt();

        //각 테스트케이스에 대하여 순서대로 데이터를 입력받고 정답을 출력한다
        for(int caseIndex = 1; caseIndex <= caseNum; caseIndex++)
        {
            //기본 물질의 종류의 수 N과 필요한 합성 물질의 양 G를 입력받는다
            int n = scanner.nextInt();
            int g = scanner.nextInt();

            //N개의 기본 물질이 필요한 양을 각각 입력받는다
            int[] needs = new int[n];
            for(int i = 0 ; i < n ; i ++){
                needs[i] = scanner.nextInt();
            }

            //주어진 함수를 이용해 정답을 계산한다
            int answer = getLeastQuantities(n, g, needs);

            //출력 형식에 맞게 정답을 출력한다
            System.out.printf("Case #%d\n", caseIndex);
            System.out.println(answer);
        }
    }
}
