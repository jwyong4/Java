public class ThreadExample4 {
    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            public void run() {
                try {
                    // 일시정지 상태로 만듬
                    while (true) Thread.sleep(1000);
                }
                catch (Exception e) {}
                System.out.println("Woke Up!!!");
            }
        };
        // NEW : start() 메소드가 호출되지 않은 상태
        System.out.println("thread1.getState() = " + thread1.getState());

        thread1.start();
        // RUNNABLE : 실행 대기 상태
        System.out.println("thread1.getState() = " + thread1.getState());
        // TIMED_WAITING : 일시정지 상태
        while (true) {
            if (thread1.getState() == Thread.State.TIMED_WAITING) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }
        thread1.interrupt();
        // interrupt에 의해 예외 발생
        while (true) {
            if (thread1.getState() == Thread.State.RUNNABLE) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }
        // TERMINATE : 실행 종료
        while (true) {
            if (thread1.getState() == Thread.State.TERMINATED) {
                System.out.println("thread1.getState() = " + thread1.getState());
                break;
            }
        }
    }
}