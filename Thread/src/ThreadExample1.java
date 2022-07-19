public class ThreadExample1 {
    public static void main(String[] args) {
        // Runnable 인터페이스를 구현한 객체 생성
        Runnable task1 = new ThreadTask1();
        // Runnable 구현 객체를 인자로 전달하면서 Thread 클래스를 인스턴스화하여 스레드를 생성
        Thread thread1 = new Thread(task1);
        // 작업 스레드 실행
        thread1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("@");
        }
    }
}
// Runnable 인터페이스 구현
class ThreadTask1 implements Runnable {
    @Override
    //Runnable 에는 run()이 정의되어 있기 때문에 반드시 run()을 구현
    public void run() { // 바디에 스레드가 수행할 작업 내용 작성
        for (int i = 0; i < 100; i++) {
            System.out.println("#");
        }
    }
}