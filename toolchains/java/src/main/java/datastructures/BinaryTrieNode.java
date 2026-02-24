package datastructures;

/** Node for binary trie structures (data-structures toolchain). */
public class BinaryTrieNode<T> {
    public T value;
    public BinaryTrieNode<T> left;
    public BinaryTrieNode<T> right;

    public BinaryTrieNode(T value, BinaryTrieNode<T> left, BinaryTrieNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTrieNode(T value) {
        this(value, null, null);
    }
}
