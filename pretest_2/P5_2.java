package pretest_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class P5_2 {

    /*
        left: 중앙값 포함하여 작은 값들 저장 (내림차순, 중앙값이 제일 큼)
        right: 중앙값보다 큰 값들 저장 (오름차순)
     */

    static class MedianQueue {

        private PriorityQueue<Integer> left;
        private PriorityQueue<Integer> right;

        public MedianQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        void push(int value) {
            if (left.size() == 0 || value <= left.peek()) {
                left.add(value);
            } else {
                right.add(value);
            }
            rebalance();
        }

        void pop() {
            if (size() == 0) return;
            left.poll();
            rebalance();
        }

        int size() {
            return (left.size() + right.size());
        }

        int getMedian() {
            return left.peek();
        }

        private void rebalance() {
            while (left.size() < right.size()) {
                int value = right.poll();
                left.add(value);
            }

            while (left.size() > right.size() + 1) {
                int value = left.poll();
                right.add(value);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int nCommands = Integer.parseInt(reader.readLine().trim());

        MedianQueue medianQueue = new MedianQueue();

        for (int i = 0; i < nCommands; i ++) {
            String line = reader.readLine().trim();

            if (line.equals("SIZE")) {
                writer.write((medianQueue.size() + "\n"));
            } else if (line.equals("POP")) {
                medianQueue.pop();

                if (medianQueue.size() == 0) {
                    writer.write("NO ITEM\n");
                } else {
                    writer.write((medianQueue.getMedian() + "\n"));
                }
            } else if (line.startsWith("PUSH")) {
                String[] words = line.split(" ");
                int value = Integer.parseInt(words[1]);

                medianQueue.push(value);
                writer.write(medianQueue.getMedian() + "\n");
            }

            writer.flush();
        }

        reader.close();
        writer.close();
    }
}
