package Graph;

import java.util.Scanner;

public class Trie {
    private static class Node {
        Node[] son = new Node[26];
        boolean end;
    }

    private final Node root = new Node();

    public Trie() {}

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (cur.son[c] == null) {
                cur.son[c] = new Node();
            }
            cur = cur.son[c];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return find(word) == 2;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != 0;
    }

    private int find(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (cur.son[c] == null) {
                return 0;
            }
            cur = cur.son[c];
        }
        return cur.end ? 2 : 1;
    }

    public static void main(String[] args) {
        Trie solution = new Trie();
        solution.insert("apple");
        System.out.println(solution.search("apple"));
        System.out.println(solution.search("app"));
        System.out.println(solution.startsWith("app"));
        solution.insert("app");
        System.out.println(solution.search("app"));
    }
}
