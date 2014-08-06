import java.util.ArrayList;
import java.util.List;


public class QueueOperations {
	private InsertThread enqThread=null;
	private RemoveThread dqThread=null;
	private BlockingQueue bqueue=null;
 
	
		public static void main(String[] args) {
			try {
				List<Thread> threadList=new ArrayList<Thread>();
				QueueOperations qops=new QueueOperations();
				qops.intiateProcess(threadList);
				qops.kickStart(threadList);
				Thread.sleep(4000);

			} catch (Exception e) {
				e.printStackTrace();		}
		}
		
		private void intiateProcess(List<Thread> threads){
			bqueue=new BlockingQueue(10);
			createDqThread(bqueue);
			createEnqThread(bqueue);
			threads.add(new Thread(dqThread, "RemoveQ"));
			threads.add(new Thread(enqThread, "InsertQ"));
		
		}
		
		private  void createEnqThread(BlockingQueue queue){
			enqThread=new InsertThread(queue);
		}
		
		private void createDqThread(BlockingQueue queue){
			dqThread=new RemoveThread(queue);
		}

		private void kickStart(List<Thread> threadslist){
			for(Thread thread: threadslist){
				thread.start();
			}

	  }
}
