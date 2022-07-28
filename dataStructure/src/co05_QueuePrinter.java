import java.util.*;

public class co05_QueuePrinter {
    public int queuePrinter(int bufferSize, int capacities, int[] documents) {
        int count = 0; // 결과 담을 변수
        Queue<Integer> queue = new LinkedList<>(); // 인쇄 환경을 담을 큐

        for (int i = 0; i < bufferSize; i++) { // queue를 buffersize 만큼 0으로 채워줌
            queue.add(0);
        }
        // 처음 시작시 동작
        queue.poll(); // 작업중인 문서의 첫번째 인덱스인 0을 삭제 후,
        queue.add(documents[0]); // 대기열의 첫번째 문서를 작업중인 문서에 넣어주고,
        documents = Arrays.copyOfRange (documents, 1, documents.length); // 해당 문서를 지움
        count++; // 1초 증가

        // 문서가 있거나 대기열이 있는 경우, 반복
        while (documents.length != 0 || (queue.stream().reduce(0, Integer::sum) != 0)) {

            if (documents.length != 0) { // 대기열에 문서가 있고,
                int sum = queue.stream().reduce(0, Integer::sum) + documents[0];

                if (sum > capacities) { // 작업중인 문서 + 대기열의 첫번째 문서가 수용량보다 크다면,
                    queue.poll(); // 문서 삭제
                    sum = queue.stream().reduce(0, Integer::sum) + documents[0];

                    if (sum <= capacities) { // 문서 삭제 후, 작업중인 문서 + 대기열의 첫번째 문서를 수용할 수 있다면,
                        queue.add(documents[0]); // 대기열의 첫번째 문서를 작업중인 문서에 넣어주고,
                        documents = Arrays.copyOfRange (documents, 1, documents.length); // 해당 문서를 지움
                        count++; // 1초 증가
                    }
                    else { // 문서 삭제 후, 대기열의 첫번째 문서를 포함했을때 수용이 불가하다면,
                        queue.add(0); // 작업중인 문서의 두번째칸에 0을 넣어줌
                        count++; // 1초 증가
                    }
                }

                else { // 작업중인 문서와 대기열의 첫번째 문서의 크기가 수용량보다 작을 경우,
                    queue.poll(); // 작업중인 문서를 삭제 후,
                    queue.add(documents[0]); // 대기열의 첫번째 문서를 작업중인 문서에 넣어주고,
                    documents = Arrays.copyOfRange(documents, 1, documents.length); // 해당 문서를 지움
                    count++; // 1초 증가
                }
            }
            else { // 대기열에 문서가 없을 경우
                queue.poll(); // 작업중인 문서를 삭제 후.
                queue.add(0); // 작업중인 문서에 0을 넣어줌
                count++; // 1초 증가
            }
        }
        return count;
    }
}
