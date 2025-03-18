import java.util.Objects;

public class ObjectContainer<T> {
    private T value;
    protected static int getCount; // Counts number of times the object is read with get() method.

    public ObjectContainer(T object) {
        this.value = object; 
    }

    public T get() {
        getCount++;
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public boolean equals(ObjectContainer<T> other) {
        if (this == other) {
            return true; // First, check if both references are the same
        }

        if (other == null || getClass() != other.getClass()) {
            return false; // Null check and class type
        }

        return this.value != null && this.value.equals(other.value); // Compare the values in each object
    }
}