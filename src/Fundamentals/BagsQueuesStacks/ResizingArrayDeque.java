package Fundamentals.BagsQueuesStacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by apple on 16/2/26.
 */
public class ResizingArrayDeque<Item> implements Iterable<Item> {
    private Item[] q;       // queue elements
    private int N;          // number of elements on queue
    private int first;      // index of first element of queue
    private int last;       // index of next available slot

    public ResizingArrayDeque() {
        q = (Item[]) new Object[2];
        N = 0;
        first = 0;
        last = 0;
    }
    /**
     * Is this queue empty?
     * @return true if this queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue
     */
    public int size() {
        return N;
    }
    private void resize(int max) {
        assert max >= N;
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        first = 0;
        last  = N;
    }

    public void pushLeft(Item item){

    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext()  { return i < N;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }
}
