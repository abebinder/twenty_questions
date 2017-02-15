import java.util.*;
public class Queue<T> {
	private ArrayList<T>list=new ArrayList<T>();
	private boolean isEmpty=true;


	public void enQueue(T element){
		if(isEmpty){
			list.add(element);
			isEmpty=false;
		}
		else{
			list.add(0, element);
		}
	}
	public T deQueue(){
		if(!isEmpty){
			T element=list.get(0);
			list.remove(0);
			list.trimToSize();
			if(list.size()==0){
				isEmpty=true;
			}
			return element;
		}
		else{
			return null;
		}
	}
	public T peek(){
		T element=list.get(0);
		return element;
	}
	public boolean checkEmpty(){
		return isEmpty;
	}
	public int getSize(){
		return list.size()	;
	}

}
