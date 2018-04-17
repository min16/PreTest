package pretest_2;
import java.util.*;
/**
 * Problem 3
 * using priority queue
 */
public class P3_2 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int teamNum = scanner.nextInt();
        int voterNum = scanner.nextInt();

        // hashmap으로 팀번호, 점수 저장
        // 배열에 저장하면? -> teamNo 갯수만큼 미리 초기화 됨. output에서 모든 팀 출력하므로 배열에 저장하면 팀 갯수만큼 확보
        // hash는 팀갯수만큼 확보되지 않아 따로 초기화 까먹고 안하면 혹은 null 발생
        // 바로 객체로 만들지 않은 이유 -> 생성된 객체 수정 해야하는데 생성된 객체 접근 불가
        // 객체타입의 배열은? -> 미리 index 세팅후 score update

        // Team 초기화
        Team[] teams = new Team[teamNum];
        for (int i = 0; i < teamNum; i ++) {
            teams[i] = new Team(i + 1);
        }

        // Team 배열 저장 // index = teamNo - 1?
        for (int i = 0; i < voterNum; i ++ ){
            int firstVote = scanner.nextInt();
            int secondVote = scanner.nextInt();

            if (firstVote == secondVote || Math.max(firstVote, secondVote) > teamNum || Math.min(firstVote, secondVote) < 1) continue;
            teams[firstVote - 1].score += 5;
            teams[secondVote - 1].score += 3;
        }

        // 정렬
        Arrays.sort(teams, (Team t1, Team t2) -> {
            if (t1.score == t2.score) return t1.no - t2.no;
            return t2.score - t1.score;
        });

        // 순위 출력
        for (int i = 0, rank = 0; i < teams.length; i ++) {
            if (i == 0 || teams[i - 1].score != teams[i].score) {
                rank = i + 1;
            }
            System.out.printf("%d %d %d\n", rank, teams[i].no, teams[i].score);
        }
    }

    public static class Team {
        int no;
        int score;

        public Team (int no) {
            this.no = no;
            this.score = 0;
        }
    }
}
