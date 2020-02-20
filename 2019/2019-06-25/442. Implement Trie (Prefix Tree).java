class TrieNode {
    TrieNode[] children;
    boolean hasWord;

    public TrieNode() {
        children = new TrieNode[26];
    }

    public void insert(String word, int index) {
        if (index == word.length()) {
            hasWord = true;
            return;
        }
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            children[pos] = new TrieNode();
        }
        children[pos].insert(word, index + 1);
    }

    public TrieNode search(String word, int index) {
        if (index == word.length()) return this;
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            return null;
        }
        return children[pos].search(word, index + 1);
    }
}

public class Trie {
    TrieNode trieNode;
    public Trie() {
        // do intialization if necessary
        trieNode = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        trieNode.insert(word, 0);
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        TrieNode node = trieNode.search(word, 0);
        return node != null && node.hasWord;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        return trieNode.search(prefix, 0) != null;
    }
}
