package A01_Stack;


public class Stack<T>
{
	// Markus Stoff

	 private Node<T> first;
    /**
     * Oberstes Element entfernen und zurückliefern.
     * Existiert kein Element, wird eine Exception ausgelöst.
     * @throws StackEmptyException 
     */
    public T pop() throws StackEmptyException {
		if (first == null)
			throw new StackEmptyException();
		Node<T> top = first;
		first = top.getNext();
    	return top.getData();
    }
    
    /**
     * Übergebenen T auf Stack (als oberstes Element) speichern.
     * @param i data
     */
    public void push(T i) {
		Node<T> top = new Node<>(i);
		top.setNext(first);
		first = top;
    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return size of stack
     */
    public int getCount() {
		int n = 0;
    	for (Node<T> cur = first; cur != null; cur = cur.getNext())
			n++;
		return n;
    }
}
