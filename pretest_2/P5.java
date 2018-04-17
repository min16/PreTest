package pretest_2;

import java.util.*;
/**
 * Problem 5
 */
public class P5 {
    //표준입력을 수행할 Scanner를 선언한다
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args)
    {   //프로그램의 시작부
        Queue<Integer> min = new PriorityQueue<>((Integer i1, Integer i2) -> i2 - i1);
        Queue<Integer> max = new PriorityQueue<>();
        int N = scanner.nextInt();

        for (int i = 0; i < N; i ++) {
            String command = scanner.next();
            int x;
            if (command.equals("PUSH")) {
                x = scanner.nextInt();
                if (min.size() == 0 || min.peek() > x) {
                    min.add(x);
                } else {
                    max.add(x);
                }
                updateMedian(max, min);
                printMedian(min);
            } else if (command.equals("POP")) {
                if (min.size() != 0) {
                    min.poll();
                    updateMedian(max, min);
                }
                printMedian(min);
            } else {
                System.out.println(min.size() + max.size());
            }
        }
    }
    public static void updateMedian(Queue<Integer> max, Queue<Integer> min) {
        while(min.size() != max.size() + 1) {
            if (max.size() == min.size()) return;
            else if(min.size() <= max.size()) {
                min.add(max.poll());
            } else {
                max.add(min.poll());
            }
        }
    }
    public static void printMedian(Queue<Integer> queue) {
        if (queue.size() == 0) {
            System.out.println("NO ITEM");
        } else {
            System.out.println(queue.peek());
        }
    }
}

/*
7
PUSH 10
POP
PUSH 1
PUSH 3
SIZE
PUSH 4
POP
 */