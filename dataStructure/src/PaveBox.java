import java.util.*;

public class PaveBox {
    public static int paveBox(Integer[] boxes) {
        ArrayList<Integer> queue = new ArrayList<>();
        List<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(boxes));

        while (arrayList.size() > 0) { // 만약 찾았다면, 해당 key를 answer에 넣고, ArrayList에서 그만큼 제외합니다.
            for(int i = 0; i < arrayList.size(); i++) {
                if(arrayList.get(i) > arrayList.get(0)) {
                    queue.add(i);
                    arrayList = arrayList.subList(i , arrayList.size());
                    break;
                }
                // 만약 찾지 못했다면 answer에 arrayList 크기를 넣은 후, arrayList 내부의 요소를 전부 삭제합니다.
                if(i == arrayList.size() - 1) {
                    queue.add(arrayList.size());
                    arrayList.clear();
                }
            }
        }
        return queue.stream().max(Integer::compare).orElse(-1);
    }
}