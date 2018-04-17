package pretest_2;
import java.util.*;
/**
 * Problem 3
 */
public class P3 {
    //표준입력을 수행할 Scanner를 선언한다
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {   //프로그램의 시작부
        int teamNum = scanner.nextInt();
        int clientNum = scanner.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        // 팀 점수 초기화
        for (int i = 1; i <= teamNum; i ++) {
            map.put(i, 0);
        }

        // 팀별 점수 합산
        for (int i = 0; i < clientNum; i ++) {
            int firstVote = scanner.nextInt();
            int secondVote = scanner.nextInt();

            if (firstVote == secondVote || Math.min(firstVote, secondVote) < 1 || Math.max(firstVote, secondVote) > 10) continue;
            else {
//                map.compute(firstVote, (K, V) -> V == null ? 5 : V + 5); //?
                map.compute(firstVote, (K, V) -> V + 5);
                map.compute(secondVote, (K, V) -> V + 3);
            }

        }

        // 순위 매기기

       // List<Integer>[] bucket = new ArrayList[teamNum + 1]; //?
        TreeMap<Integer, List<Integer>> ranking = new TreeMap<>((Integer k1, Integer k2) -> k2 - k1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int team = entry.getKey();
            int score = entry.getValue();
            if (!ranking.containsKey(score)) {
                ranking.put(score, new ArrayList<>());
            }
            ranking.get(score).add(team);
        }

        // 순위 출력
        int rank = 1;
        for (Map.Entry<Integer, List<Integer>> entry : ranking.entrySet()) { //for i = 0..?
            int score = entry.getKey();
            List<Integer> list = entry.getValue();
            for (Integer team : list) {
                System.out.printf("%d %d %d\n", rank, team, score);
            }
            rank += list.size();
        }
    }
}

/*
10 10
8 9
8 7
5 4
4 5
5 3
4 0
3 8
5 3
7 0
4 1
*/
