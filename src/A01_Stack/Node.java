/**
 * Author: Markus Stoff
 * Date: 2023-11-05
 */

package A01_Stack;

public class Node<T>
{
    private final T data;

    private Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
