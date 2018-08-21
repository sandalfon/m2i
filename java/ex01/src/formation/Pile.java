package formation;

public class Pile<E>{
	
	private E[] data = (E[])new Object[10];
	private int position=0;
	
	public void push(E e) {
		this.data[position++]=e;
	}
	public void pop() {
		this.position--;
	}
	
	public E get(int i) {
		if(i <= this.position) {
			return this.data[i];
		}
		return null;
	}

	public void set(int  i, E e) {
		if(i <= this.position) {
			this.data[i]=e;
		}
		
	}
	

	public String toString() {
		String str ="[";
		for(int i = 0 ; i < this.position;i++) {
			str =str+this.data[i].toString()+", ";
		}
		str = str.substring(0,str.length()-2)+"]";
		return str;
	}
	public int length() {
		return this.position+1;
	}
	
	public static void main(String args[]) {
		Pile<Integer> pi = new Pile<Integer>();
		pi.push(1);
		pi.push(3);
		pi.push(2);
		System.out.println(pi.get(1));
		System.out.println(pi.get(3));
		System.out.println(pi.length());
		System.out.println(pi.toString());
		pi.pop();
		System.out.println(pi.toString());
		
		
	}
}

