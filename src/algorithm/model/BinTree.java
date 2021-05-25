package algorithm.model;

import java.util.Comparator;

/**
 * @author : "NKT"
 * @date : 2021-01-07 11:11
 * @description ==============================================================
 * 이진 검색 트리
 * P 378 ~ 391
 * ==============================================================
 */
public class BinTree<K, V> {

    class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> left;
        private Node<K, V> right;

        Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = value;
            this.left = left;
            this.right = right;
        }

        K getKey() {
            return this.key;
        }

        V getValue() {
            return this.data;
        }

        void print() {
            System.out.println(this.data);
        }
    }

    private Node<K, V> root;
    private Comparator<? super K> comparator = null;

    public BinTree() {
        root = null;
    }

    public BinTree(Comparator<? super K> c) {
        this();
        this.comparator = c;
    }

    @SuppressWarnings({"unchecked", "unused"})
    private int compare(K k1, K k2) {
        return (this.comparator == null) ? ((Comparable<K>) k1).compareTo(k2) : comparator.compare(k1, k2);
    }

    public V serach(K key) {
        Node<K, V> p = root;

        while (true) {
            if (p == null) return null;

            int cond = compare(key, p.getKey());
            // 원하는 키를 찾은 경우
            if (cond == 0)
                return p.getValue();
            else if (cond < 0)
                p = p.left;

                // key가 존재하지만 더 안쪽에 있는 경우
            else
                p = p.right;
        }
    }

    @SuppressWarnings("unused")
    private void addNode(Node<K, V> node, K key, V data) {
        int cond = compare(key, node.getKey());

        if (cond == 0) return;
        else if (cond < 0) {
            if (node.left == null) node.left = new Node<K, V>(key, data, null, null);
            else addNode(node.left, key, data);
        } else {
            if (node.right == null) node.right = new Node<K, V>(key, data, null, null);
            else addNode(node.right, key, data);
        }
    }

    public void add(K key, V data) {
        if (root == null) {
            root = new Node<K, V>(key, data, null, null);
        } else {
            addNode(root, key, data);
        }
    }

    public boolean remove(K key) {
        Node<K, V> p = root;
        Node<K, V> parent = null;
        boolean isLeftChild = true;

        // 삭제하고 싶은 key값이 있는 위치로 이동
        while (true) {
            if (p == null) return false;

            int cond = compare(key, p.getKey());

            if (cond == 0) break;
            else {
                parent = p;
                if (cond < 0) {
                    isLeftChild = true;
                    p = p.left;
                } else {
                    isLeftChild = false;
                    p = p.right;
                }
            }
        }

        // 해당 위치의 왼쪽 자식이 없는 경우
        if (p.left == null) {
            if (p == root) {
                root = p.right;
            } else if (isLeftChild) {
                parent.left = p.right;
            } else {
                parent.right = p.right;
            }

            // 해당 위치의 오른쪽 자식이 없는 경우
        } else if (p.right == null) {
            if (p == root) {
                root = p.left;
            } else if (isLeftChild) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
            // 해당 위치에 왼쪽, 오른쪽 자식이 둘다 있는 경우
        } else {
            parent = p;
            Node<K, V> left = p.left;
            isLeftChild = true;
            while (left.right != null) {
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            p.key = left.key;
            p.data = left.data;
            if (isLeftChild) {
                parent.left = left.left;
            } else {
                parent.right = left.left;
            }
        }

        return true;
    }

    public void printSubTree(Node<K, V> node) {
        if (node != null) {
            printSubTree(node.left);
            System.out.println(node.key + " : " + node.data);
            printSubTree(node.right);
        }
    }

    public void print() {
        printSubTree(root);
    }

    public void printReverseSubTree(Node<K, V> node) {
        if (node != null) {
            printReverseSubTree(node.right);
            System.out.println(node.key + " : " + node.data);
            printReverseSubTree(node.left);
        }
    }

    public void printReverse() {
        printReverseSubTree(root);
    }

    private Node<K, V> getMinNode() {
        if (root == null) return null;
        else {
            Node<K, V> p = root;

            while (p.left != null)
                p = p.left;

            return p;
        }
    }

    private Node<K, V> getMaxNode() {
        if (root == null) return null;
        else {
            Node<K, V> p = root;
            while (p.right != null)
                p = p.right;
            return p;
        }
    }

    public K getMinKey() {
        Node<K, V> minNode = getMinNode();
        return (minNode == null ? null : minNode.getKey());
    }

    public V getDataWithMinKey() {
        Node<K, V> minNode = getMinNode();
        return (minNode == null ? null : minNode.getValue());
    }

    public K getMaxKey() {
        Node<K, V> maxNode = getMaxNode();
        return (maxNode == null ? null : maxNode.getKey());
    }

    public V getDataWithMaxKey() {
        Node<K, V> maxNode = getMaxNode();
        return (maxNode == null ? null : maxNode.getValue());
    }

}
