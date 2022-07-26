import java.util.*;

public class PaveBox {
    public static int paveBox(Integer[] boxes) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < boxes.length; i++) {
            queue.add(boxes[i]);
        }
        int max = 0;
        for(int i = 0; i <= queue.size(); i++) {
            int cnt = 0;
            for (int j = 0; j < boxes.length; j++) {
                if (queue.peek() >= boxes[j]) {
                    cnt++;
                    continue;
                }
                else {
                    break;
                }
            }
            boxes = Arrays.copyOfRange(boxes, 1, boxes.length);
            if (max < cnt) {
                max = cnt;
            }
            queue.poll();
        }
        return max;
    }
}
//        // Queue 사용 풀이
//        // 입력받은 boxes를 저장할 queue 생성
//        Queue<Integer> queue = new LinkedList<>();
//        // super 클래스인 LinkedList를 받아들이고, 배열에 요소를 추가하기 위한 boxes 인자의 Arrays.asList 생성
//        List<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(boxes));
//
//        // boxes의 길이가 0보다 크다면, 반복한다.
//        while (arrayList.size() > 0) {
//            for(int i = 0; i < arrayList.size(); i++) {
//                // boxes[0] 보다 큰 인자를 가진 인덱스를 찾았다면, ex) [5, 1, 4, 6] 일 때, boxes[3]
//                if(arrayList.get(i) > arrayList.get(0)) {
//                    // queue에 해당 인덱스(=포장을 마친 인원수와 동일)를 넣고, ex) boxes[3]
//                    queue.add(i);
//                    // arraylist(boxes[])에서는 그 인덱스의 뒤에 있는 인덱스들을 삭제한다. ex) boxes[3] 뒤의 인자들 제거
//                    arrayList = arrayList.subList(i, arrayList.size());
//                    break;
//                }
//                // 만약 찾지 못했다면 queue에 arrayList 크기를 넣은 후, arrayList 내부의 요소를 전부 삭제
//                if(i == arrayList.size() - 1) {
//                    queue.add(arrayList.size());
//                    arrayList.clear();
//                }
//            }
//        }
//        // stream의 max 메서드 사용하여 max 원소를 담고 있는 객체를 리턴
//        return queue.stream().max(Integer::compare).orElse(-1);