package prob5;

public class MyStack<T> {
	private int top;
	private T[] buffer;
	
	@SuppressWarnings("unchecked")
	public MyStack(int capacity) {
		top = -1;
		buffer = (T[])new Object[capacity];
	}
	
	public void push(T t) {
		if (top == buffer.length - 1) { //stack full
			resize();
		}
		
		buffer[++top] = t;
	}
	
	public T pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException();
		}
		
		T result = buffer[top];
		buffer[top--] = null;
		
		return result;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	@SuppressWarnings("unchecked")
	public void resize() {
		T[] temp = (T[]) new Object[buffer.length * 2];
		for(int i = 0; i < buffer.length; i++) {
			temp[i] = buffer[i];
		}
		
		buffer = temp;
	}
	
	/*
	 * private int top; private String[] buffer;
	 * 
	 * public MyStack(int n) { this.top = -1; this.buffer = new
	 * String[n]; }
	 * 
	 * public void push(String str) { if (top + 1 == buffer.length) { String[] tmp =
	 * new String[buffer.length]; for(int i = 0; i <= top; i++) { tmp[i] =
	 * buffer[i]; }
	 * 
	 * buffer = new String[buffer.length * 2]; for(int i = 0; i <= top; i++) {
	 * buffer[i] = tmp[i]; } }
	 * 
	 * top++;
	 * 
	 * buffer[top] = str; }
	 * 
	 * public String pop() throws MyStackException { if (top < 0) { throw new
	 * MyStackException(); }
	 * 
	 * String s = buffer[top]; top--;
	 * 
	 * return s;
	 * 
	 * }
	 * 
	 * public boolean isEmpty() { if (top >= 0) { return false; }
	 * 
	 * return true; }
	 */
}