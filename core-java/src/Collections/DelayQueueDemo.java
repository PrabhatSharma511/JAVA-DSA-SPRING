package Collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<DelayedTask> dq = new DelayQueue<>();
		dq.put(new DelayedTask("Task1",5,TimeUnit.SECONDS));
		dq.put(new DelayedTask("Task2",3,TimeUnit.SECONDS));
		dq.put(new DelayedTask("Task3",10,TimeUnit.SECONDS));

		while(!dq.isEmpty()) {
			DelayedTask task = dq.take();
			System.out.println("Executed: "+task.getTaskName()+" at "+ System.currentTimeMillis());
		}
	}
	
}

class DelayedTask implements Delayed{
	String taskName;
	long startTime;

	public DelayedTask(String taskName, long delay,TimeUnit unit) {
		this.taskName = taskName;
		this.startTime = System.currentTimeMillis()+unit.toMillis(delay);
	}
	
	@Override
	public int compareTo(Delayed o) {
		if(this.startTime<((DelayedTask) o).startTime) {
			return -1;
		}
        if(this.startTime>((DelayedTask) o).startTime) {
			return 1;
		}
        return 0;
	}
	@Override
	public long getDelay(TimeUnit unit) {
		long remainingTime = startTime-System.currentTimeMillis();
		return unit.convert(remainingTime,TimeUnit.MILLISECONDS);
	}

	public String getTaskName() {
		return taskName;
	}

}
