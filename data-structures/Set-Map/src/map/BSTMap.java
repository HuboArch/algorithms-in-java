package map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        K    key;
        V    value;
        Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int  size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 向以node为根的二分搜索树中添加元素(key, value)
     *
     * @param node  二分搜索树的根节点
     * @param key   待插入的key
     * @param value 待插入的value
     * @return 返回插入新节点后的二分搜索树的根
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value; // 如果key值已经存在，则覆盖之前的value值
        }
        return node;
    }

    /**
     * 获取包含指定键的node节点
     *
     * @param node 根节点
     * @param key  待搜索键值
     * @return 返回在以node为根节点的二分搜索树中，key值所在的节点
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else { // key.compareTo(node.key) == 0
            return node;
        }
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);

        if (node == null) {
            throw new IllegalArgumentException(key + "does not exists.");
        }

        node.value = value;
    }
}
