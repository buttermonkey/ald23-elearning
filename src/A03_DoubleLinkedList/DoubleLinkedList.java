package A03_DoubleLinkedList;

public class DoubleLinkedList<T>
{
    Node<T> first;
    Node<T> last;
    Node<T> current;

    /**
     * Einfügen einer neuen <T>
     * @param a <T>
     */
    public void add(T a) {
        Node<T> node = new Node<>(a);
        if (last == null)
            first = last = node;
        else {
            last.setNext(node);
            node.setPrevious(last);
            last = node;
        }
    }

    /**
     * Internen Zeiger für next() zurücksetzen
     */
    public void reset() {
        current = first;
    }

    /**
     * analog zur Funktion reset()
     */
    public void resetToLast() {
        current = last;
    }

    /**
     * Liefert erste Node der Liste retour oder null, wenn Liste leer
     * @return Node|null
     */
    public Node<T> getFirst() {
    	return first;
    }
    
    /**
     * Liefert letzte Node der Liste retour oder null, wenn Liste leer
     * @return Node|null
     */
    public Node<T> getLast() {
    	return last;
    }
    
    /**
     * Gibt aktuelle <T> zurück und setzt internen Zeiger weiter.
     * Falls current nicht gesetzt, wird null retourniert.
     * @return <T>|null
     */
    public T next() {
        if (current == null)
            return null;
        T data = current.getData();
        current = current.getNext();
    	return data;
    }

    /**
     * analog zur Funktion next()
     * @return <T>|null
     */
    public T previous() {
        if (current == null)
            return null;
        T data = current.getData();
        current = current.getPrevious();
        return data;
    }
    
    /**
     * Current-Pointer auf nächste <T> setzen (aber nicht auslesen).
     * Ignoriert still, dass current nicht gesetzt ist.
     */
    public void moveNext() {
        if (current != null)
            current = current.getNext();
    }
    
    /**
     * Analog zur Funktion moveNext()
     */
    public void movePrevious() {
        if (current != null)
            current = current.getPrevious();
    }
   
    /**
     * Retourniert aktuelle (current) <T>, ohne Zeiger zu ändern
     * @return <T>
     * @throws CurrentNotSetException
     */
    public T getCurrent() throws CurrentNotSetException {
        if (current == null)
            throw new CurrentNotSetException();
    	return current.getData();
    }

    /**
     * Gibt <T> an bestimmter Position zurück
     * @param pos Position, Nummerierung startet mit 1
     * @return <T>|null
     */
    public T get(int pos) {
        Node<T> node = getNode(pos);
        return node != null ? node.getData() : null;
    }

    private Node<T> getNode(int pos) {
        int i = 1;
        for (Node<T> cur = first; cur != null; cur = cur.getNext())
            if (i == pos)
                return cur;
            else
                i++;
        return null;
    }

    /**
     * Entfernen des Elements an der angegebenen Position.
     * Falls das entfernte Element das aktuelle Element ist, wird current auf null gesetzt.
     * @param pos
     */
    public void remove(int pos) {
        removeNode(getNode(pos));
    }

    private void removeNode(Node<T> node) {
        if (node != null) {
            if (node == current)
                current = null;
            if (node.getPrevious() != null)
                node.getPrevious().setNext(node.getNext());
            else
                first = node.getNext();
            if (node.getNext() != null)
                node.getNext().setPrevious(node.getPrevious());
            else
                last = node.getPrevious();
        }
    }

    /**
     * Entfernt das aktuelle Element.
     * Als neues aktuelles Element wird der Nachfolger gesetzt oder
     * (falls kein Nachfolger) das vorhergehende Element 
     * @throws CurrentNotSetException
     */
    public void removeCurrent() throws CurrentNotSetException {
        if (current == null)
            throw new CurrentNotSetException();
        Node<T> newCurrent = current.getNext() != null ? current.getNext() : current.getPrevious();
        removeNode(current);
        current = newCurrent;
    }
    
    /**
     * Die Methode fügt die übergebene <T> nach der aktuellen (current) ein
     * und setzt dann die neu eingefügte <T> als aktuelle (current) <T>.
     * @throws CurrentNotSetException 
     */
    public void insertAfterCurrentAndMove(T a) throws CurrentNotSetException {
        if (current == null)
            throw new CurrentNotSetException();
        Node<T> node = new Node<>(a);
        node.setPrevious(current);
        node.setNext(current.getNext());
        current.setNext(node);
        current = node;
    }
}
