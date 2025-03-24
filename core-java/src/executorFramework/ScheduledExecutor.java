package executorFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {

	public static void main(String[] args) {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		Executors.newCachedThreadPool();
		scheduler.schedule(()->{System.out.println("Print after every 5 seconds");}, 5, TimeUnit.SECONDS);
		scheduler.scheduleAtFixedRate(()->{System.out.println("Print after every 5 seconds");}, 5,5, TimeUnit.SECONDS);
		scheduler.schedule(()->scheduler.shutdown(), 20, TimeUnit.SECONDS);//required with scheduleAtFixedRate
		//when we run schedule the taks is immedialtely put into queue and then shutdown waits for it to complete execution and then shutdown
		//but scheduleAtFixedRate runs periodic tasks so if we run shutdown immediately it does not get time to go in queue so scheduleAtFixedRate requires proper handling
		
//		ScheduledFuture<?> future = scheduler.scheduleWithFixedDelay(()->{System.out.println("Print after every 5 seconds");}, 5,5, TimeUnit.SECONDS);
//		System.out.println(future.getDelay(TimeUnit.SECONDS));
//		scheduler.shutdown();
	}
	
}
