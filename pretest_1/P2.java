package pretest_1;
import java.util.*;
/**
 * Problem 2
 */
public class P2 {
    public static Scanner scanner = new Scanner(System.in);
    public static int getDuplicatedArea(Point p, Point q, Point r, Point s)
    {
        int area = 0; //두 사각형이 교차하는 영역의 넓이
        int left = Math.min(p.getX(), q.getX());
        int right = Math.max(p.getX(), q.getX());
        int down = Math.min(p.getY(), q.getY());
        int up = Math.max(p.getY(), q.getY());

        int newLeft = Math.min(r.getX(), s.getX());
        int newRight = Math.max(r.getX(), s.getX());
        int newDown = Math.min(r.getY(), s.getY());
        int newUp = Math.max(r.getY(), s.getY());

        left = Math.max(left, newLeft);
        right = Math.min(right, newRight);
        up = Math.min(up, newUp);
        down = Math.max(down, newDown);

        int width = right - left;
        int height = up - down;
        if (width >= 0 && height >= 0) {
            area = width * height;
            return area;
        }
        return area;
    }

    /*
    -7 5
0 0
-3 -3
4 2
    ** 메인 함수에는 테스트케이스와 입출력에 대한 기본적인 뼈대 코드가 작성되어 있습니다.
    ** 상단의 함수만 완성하여도 문제를 해결할 수 있으며,
    ** 메인 함수를 제거한 후 스스로 코드를 모두 작성하여도 무방합니다.
    ** 단, 스스로 작성한 코드로 인해 발생한 에러 등은 모두 참가자에게 책임이 있습니다.
    */
    public static void main(String[] args) {
        //네 점 p, q, r, s를 차례로 입력받는다.
        Point p = new Point(scanner.nextInt(), scanner.nextInt());
        Point q = new Point(scanner.nextInt(), scanner.nextInt());
        Point r = new Point(scanner.nextInt(), scanner.nextInt());
        Point s = new Point(scanner.nextInt(), scanner.nextInt());

        //주어진 함수를 통해 교차하는 영역의 넓이를 계산한다
        int answer = getDuplicatedArea(p, q, r, s);

        //정답을 형식에 맞게 출력한다
        System.out.println(answer);
    }
}

/**
 @description
 하나의 점(좌표)를 나타내는 클래스
 **/
class Point{
    public int x;
    public int y;
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
}
