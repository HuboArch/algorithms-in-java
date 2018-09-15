package map;

public interface Map<K, V> {

    int getSize();

    boolean isEmpty();

    boolean contains(K key);

    void add(K key, V value);

    void remove(K key);

    V get(K key);

    void set(K key, V value);

}
