package _10_Danh_Sach.Bai_Tap.ArrrayList;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object element[];

    public MyList() {
        element = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        this.size = capacity;
    }

    public void add(int index, E e) {
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) element[i + 1] = element[i];
        element[index] = e;
        size++;
    }

    public E remove(int index) {
        checkIndex(index);

        E e = (E) element[index];

        for (int j = index; j < size - 1; j++)
            element[j] = element[j + 1];

        element[size - 1] = null;

        size--;
        return e;
    }
    public int size(){
        return size;
    }

    //E Clone

    public boolean contains(E e){
        for (int i = 0; i < size; i++)
            if (e.equals(element[i]))
                return true;
        return false;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(element[i])) return i;
        return -1;
    }

    //boolean addd

    private void ensureCapacity() {
        if (size >= element.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(element, 0, newData, 0, size);
            element = newData;
        }
    }
    public E get(int index) {
        checkIndex(index);
        return (E) element[index];


    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }


    public void clear() {
        element = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        System.out.println(size());
    }
}
