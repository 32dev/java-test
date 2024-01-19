import java.util.Timer;
import java.util.TimerTask;

public class SimpleTimerExample {

    public static void main(String[] args) {
        // 타이머 객체 생성
        Timer timer = new Timer();

        // 타이머 작업 정의 (TimerTask 상속)
        TimerTask task = new TimerTask() {
            int secondsPassed = 0;
            
            @Override
            public void run() {
                secondsPassed++;
                System.out.println("Seconds passed: " + secondsPassed);

                // 원하는 시간이 지나면 타이머 취소
                if (secondsPassed == 5) {
                    System.out.println("Timer canceled.");
                    timer.cancel();
                }
            }
        };

        // 타이머 시작 (1000 밀리초마다 실행, 최초 실행까지 0 밀리초 대기)
        timer.schedule(task, 0, 1000);
    }
}
