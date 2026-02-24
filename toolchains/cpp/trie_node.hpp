#ifndef DATASTRUCTURES_TREE_NODE_HPP
#define DATASTRUCTURES_TREE_NODE_HPP

#include <vector>
#include <memory>

namespace datastructures {

template <typename T>
struct TrieNode {
    T value;
    std::vector<std::unique_ptr<TrieNode<T>>> children;

    explicit TrieNode(T v) : value(std::move(v)) {}
};

} // namespace datastructures

#endif
