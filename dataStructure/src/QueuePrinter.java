import java.util.*;

public class QueuePrinter {
    public int queuePrinter(int bufferSize, int capacities, int[] documents) {
        //결과를 담을 변수를 선언 초기화합니다.
        int count = 0;

        //인쇄 환경을 담을 큐를 선언합니다. 큐는 추상 인터페이스로, LinkedList, 우선순위큐로 구현할 수 있습니다.
        Queue<Integer> queue = new LinkedList<>();

        //선언한 큐를 0으로 채워줍니다.
        for(int i = 0; i < bufferSize; i++) {
            queue.add(0);
        }

        //첫 시작은 초기값을 빼주고, 0번 문서를 넣어줍니다. 이후 결과 1 증가
        queue.poll();
        queue.add(documents[0]);
        documents = Arrays.copyOfRange(documents, 1, documents.length);//문서를 하나 지워줍니다.(배열 줄이기)
        count++;

        //반복을 시작합니다. (더이상 문서가 없을 경우 && !!!!중요!!!! 대기열이 존재하지 않는 경우) -> 멈춰야 합니다.
        while(documents.length != 0 || (queue.stream().reduce(0, Integer::sum) != 0)) {
            if(documents.length != 0) { //대기중인 문서가 남은 경우
                int sum = queue.stream().reduce(0, Integer::sum) + documents[0];
                if(sum > capacities) {//작업중인 문서와, 남은 문서중 가장 처음 문서의 크기가 capacities보다 큰 경우

                    queue.poll();
                    sum = queue.stream().reduce(0, Integer::sum) + documents[0];

                    if(sum <= capacities) {//문서가 제거되고, 남은 대기열의 첫번째 문서를 포함했을때 수용이 가능하다면,
                        queue.add(documents[0]);
                        documents = Arrays.copyOfRange(documents, 1, documents.length);//문서를 하나 지워줍니다.(배열 줄이기)
                        count++;
                    } else { //문서가 제거되고, 남은 대기열의 첫번째 문서를 포함했을때 수용이 불가능하다면, (if(sum > capacities))
                        queue.add(0);
                        count++;
                    }
                } else { //작업중인 문서와, 남은 문서중 가장 처음 문서의 크기가 capacities보다 작은 경우
                    queue.poll();
                    queue.add(documents[0]);
                    documents = Arrays.copyOfRange(documents, 1, documents.length);//문서를 하나 지워줍니다.(배열 줄이기)
                    count++;
                }
            }else { //대기중인 문서가 없을 경우
                queue.poll();
                queue.add(0);
                count++;
            }
        }
        return count;
    }
}