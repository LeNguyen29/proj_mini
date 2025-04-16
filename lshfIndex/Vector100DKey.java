package lshfIndex;

import global.*;
import btree.*;

/** Vector100DKey: It extends the KeyClass.
 *  It defines the Vector100Dtype Key with an associated hash value.
 */
public class Vector100DKey extends KeyClass {

    private int hashValue; // Hash value of the vector
    private Vector100Dtype vector; // Original vector

    /** Class constructor
     *  @param vector the original vector
     *  @param hashValue the hash value of the vector
     */
    public Vector100DKey(Vector100Dtype vector, int hashValue) {
        this.vector = new Vector100Dtype(vector.getVector());
        this.hashValue = hashValue;
    }

    public Vector100DKey(Vector100Dtype vector) {
      this.vector = new Vector100Dtype(vector.getVector());
      int prime = 31;
      int hash = 0;
    
      for (int j = 0; j < Vector100Dtype.SIZE; j++) {
        hash += vector.getVector()[j];
      }

      this.hashValue = (Math.abs(hash) % prime) + 1;
    }

    /** Get the hash value
     *  @return the hash value
     */
    public int getHashValue() {
        return hashValue;
    }
    /** Set the hash value
     *  @param hashValue the hash value to set
     */
    public void setHashValue(int hashValue) {
        this.hashValue = hashValue;
    }

    /** Get the original vector
     *  @return the original vector
     */
    public Vector100Dtype getVector() {
        return new Vector100Dtype(vector.getVector());
    }

    /** Compute the Euclidean distance between two vectors
     *  @param other the other Vector100DKey
     *  @return the Euclidean distance
     */
    public int computeDistance(Vector100DKey other) {
        int sum = 0;
        for (int i = 0; i < Vector100Dtype.SIZE; i++) {
            int diff = vector.getVector()[i] - other.getVector().getVector()[i];
            sum += diff * diff;
        }
        return (int) Math.sqrt(sum); // Euclidean distance
    }

    @Override
    public String toString() {
        return "Hash: " + hashValue + ", Vector: " + vector.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector100DKey other = (Vector100DKey) obj;
        return this.hashValue == other.hashValue;
    }

    public int compareTo(KeyClass o) {
        return Integer.compare(this.hashValue, ((Vector100DKey) o).hashValue);
    }

}
