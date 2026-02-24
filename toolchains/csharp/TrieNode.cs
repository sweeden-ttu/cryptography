namespace DataStructures;

/// <summary>Node for trie structures (data-structures toolchain).</summary>
public class TrieNode<T>
{
    public T Value { get; set; }
    public List<TrieNode<T>> Children { get; } = new();

    public TrieNode(T value, List<TrieNode<T>>? children = null)
    {
        Value = value;
        if (children != null)
            Children.AddRange(children);
    }
}
