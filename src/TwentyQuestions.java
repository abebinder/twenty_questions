
public class TwentyQuestions {
	Queue<String> qandAQueue;

	public void printQueue(){
		if(qandAQueue.getSize()>0){
			String current=qandAQueue.deQueue();
			System.out.println(current);
		}

	}




}
