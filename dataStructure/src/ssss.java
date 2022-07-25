import java.util.*;

public class ssss {
    public int paveBox(Integer[] boxes) {
        // TODO:
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < boxes.length; i++) {
            queue.add(boxes[i]);
        }
        int max = 0;
        for(int i = 0; i < boxes.length; i++) {
            int cnt = 0;
            for(int j = i; j < boxes.length; j++) {
                if(queue.peek() >= boxes[j]) {
                    cnt++;
                }
            }
            if(max < cnt) {
                max = cnt;
            }
            queue.poll();
        }
        return max;
    }
}