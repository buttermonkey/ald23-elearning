package A02_Queue;

public class Queue<T>
{
    // Markus Stoff

    private Node<T> first;
    
    private Node<T> last;
    /**
     * Das vorderste (=erste) Element aus der Queue entfernen und zurückliefern.
     * Existiert kein Element, wird eine Exception ausgelöst.
     * @throws QueueEmptyException 
     */
    public T dequeue() throws QueueEmptyException {
        if (first == null)
            throw new QueueEmptyException();
        Node<T> front = first;
        first = front.getNext();
    	return front.getData();
    }
    
    
    
    /**
     * Übergebenen Integer am Ende der Queue anhängen.
     * @param i Zahl
     */
    public void enqueue(T i) {
        Node<T> back = new Node<>(i);
        if (last != null)
            last.setNext(back);
        last = back;
        if (first == null)
            first = back;
    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return size of queue
     */
    public int getCount() {
    	int n = 0;
        for (Node<T> cur = first; cur != null; cur = cur.getNext())
            n++;
        return n;
    }
}
