package thread0303;


//왔다갔다함
// 서브스레드를 만든다
// 서브스레드의 메서드를 오버라이딩한다 @@ 수퍼클래스 Runnable을 상속해야한다
// 서브스레드를 
// Thread 클래스에 타켓 객체를 넣으면 서브스레드의 메서드가 실행된다
// 하나의 약속이다
// t1.start를 하면 서브스레드와 메인스레드를 번갈아가면서 실행을한다
// 번갈아 왔다갔다하는것을 context Switching

class SubThread implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i < 6; i++) {
			System.out.println("서브스레드 :" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class ThreadEx01 {
	// 자바의 메인 스레드
	public static void main(String[] args) {
		SubThread st = new SubThread();
			Thread t1 = new Thread(st); 
			// 타겟 선정 st
			// 현재 스레드가 어떤 쓰레드인지 밝히기 위해서 
			// Thread 클래스르 클릭하면 매개변수에 Runnable target 이 있다
			// Runnable을 상속받은게 SubThread이니까 이 클래스의 run메서드가 실행 될 것이다.
			t1.start();// SubThread의 run 메서드 실행
		for(int i = 1; i < 6; i++) {
			System.out.println("메인 스레드: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
