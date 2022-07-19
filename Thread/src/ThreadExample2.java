public class ThreadExample2 {
    public static void main(String[] args) {
        // Thread 클래스를 상속받은 클래스를 인스턴스화하여 스레드를 생성
        Thread thread2 = new ThreadTask2();
        thread2.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("@");
        }
    }
}
// Thread 클래스를 상속받는 하위클래스 작성
class ThreadTask2 extends Thread {
    @Override
    // run() 메서드 바디에 스레드가 수행할 작업 내용 작성
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("#");
        }
    }
}