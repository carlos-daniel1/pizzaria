package pizzaria;

public class Pilha {
	String elementos[];
	int topo;

	public Pilha() {
		elementos = new String[10];
		topo = -1;
	}

	public void push(String e) {
		//if (isFull()) {
			//System.out.println("Pilha cheia!");		
			topo++;
			elementos[topo] = e;

	}

	public String pop() {
		String e;
		e = elementos[topo];
		topo--;
		return e;
	}

	public boolean isEmpty() {
		return (topo == -1);
	}

	public boolean isFull() {
		return (topo == 9);
	}

	public String top() {
		//if (isEmpty()) {
			//System.out.println("Pilha vazia!");
		//}
		return elementos[topo];
	}

	public static void main(String[] args) {
		Pilha p = new Pilha();

		p.pop();

	}
}
