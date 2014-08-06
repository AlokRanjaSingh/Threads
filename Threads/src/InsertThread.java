

public class InsertThread implements Runnable{

	private BlockingQueue qinsertion=null;
	
	public InsertThread(BlockingQueue Q){
		qinsertion=Q;
	}
	
	@Override
	public void run() {
		try {
			for(int i=0;i<=100;i++){
				insertInQ(i+"");
	            Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void insertInQ(String value) throws Exception{
		qinsertion.enqueue(value);
		System.out.println("Inserted : "+value+" in the Q : ");
		
	}
	

}
