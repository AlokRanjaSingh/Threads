
public class RemoveThread implements Runnable{
	private BlockingQueue remove=null;
	
	public RemoveThread(BlockingQueue Q){
		remove=Q;
	}

	@Override
	public void run() {
		try {
			for(int i=0;i<=100;i++){
				removeFromQ();
	            Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void removeFromQ() throws Exception{
		System.out.println("Removed : "+remove.dequeue()+" from the Q : ");
	}
}
