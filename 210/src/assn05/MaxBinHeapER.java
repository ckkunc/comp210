package assn05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MaxBinHeapER<V,     P extends Comparable<P>> implements BinaryHeap<V, P> {
    private List<Prioritized<V,P>> _heap;

    public MaxBinHeapER() {
        _heap = new ArrayList<>();
    }

    public MaxBinHeapER(Prioritized<V, P>[] initialEntries) {
        _heap = new ArrayList<>(Arrays.asList(initialEntries));
        for (int i = _heap.size() / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    @Override
    public int size() {
        return _heap.size();
    }

    @Override
    public void enqueue(V value, P priority) {
        Prioritized<V, P> patient = new Patient<>(value, priority);
        _heap.add(patient);
        int i = _heap.size() - 1;
        while (i > 0 && _heap.get(parent(i)).compareTo(_heap.get(i)) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public void enqueue(V value) {
        Prioritized<V, P> patient = new Patient<>(value);
        _heap.add(patient);
        int i = _heap.size() - 1;
        while (i > 0 && _heap.get(parent(i)).compareTo(_heap.get(i)) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    @Override
    public V dequeue() {
        if (_heap.isEmpty()) {
            return null;
        }
        V max = _heap.get(0).getValue();
        _heap.set(0, _heap.get(_heap.size() - 1));
        _heap.remove(_heap.size() - 1);
        maxHeapify(0);
        return max;
    }

    @Override
    public V getMax() {
        return _heap.isEmpty() ? null : _heap.get(0).getValue();
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }

    private void maxHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;

        if (left < _heap.size() && _heap.get(left).compareTo(_heap.get(largest)) > 0) {
            largest = left;
        }

        if (right < _heap.size() && _heap.get(right).compareTo(_heap.get(largest)) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    private void swap(int i, int j) {
        Prioritized<V, P> temp = _heap.get(i);
        _heap.set(i, _heap.get(j));
        _heap.set(j, temp);
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }
}
