package global;

public class Vector100Dtype {
    public static final int SIZE = 100; // 100 dimensions
    public static final short MIN_VALUE = -10000;
    public static final short MAX_VALUE = 10000;

    private short[] vector;

    public Vector100Dtype() {
        vector = new short[SIZE];
    }

    public Vector100Dtype(short[] vector) {
        if (vector.length != SIZE || vector == null) {
            throw new IllegalArgumentException("Vector must have " + SIZE + " elements");
        }

        this.vector = new short[SIZE];
        
        for (int i = 0; i < SIZE; i++) {
            short val = vector[i];
            if (val < MIN_VALUE || val > MAX_VALUE) {
                throw new IllegalArgumentException("Value at index " + i + " is out of range: " + val);
            }
            this.vector[i] = val;
        }
    }

    public short[] getVector() {
        return vector;
    }

    /**
     * Get the element at the specified index
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     */
    public short getVector100DElement(int index) {
        if (index < 0 || index >= SIZE) {
            throw new IndexOutOfBoundsException("Index must be between 0 and " + (SIZE - 1));
        }
        return vector[index];
    }
}
