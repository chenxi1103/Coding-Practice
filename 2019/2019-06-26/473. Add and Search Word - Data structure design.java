class TrieNode {
    TrieNode[] children;
    boolean hasWord;
    public TrieNode() {
        children = new TrieNode[26];
    }

    public void add(String word, int index) {
        if (word.length() == index) {
            this.hasWord = true;
            return;
        }
        int pos = word.charAt(index) - 'a';
        if (children[pos] == null) {
            children[pos] = new TrieNode();
        }
        children[pos].add(word, index + 1);
    }

    public boolean search(String word, int index, TrieNode currNode) {
        if (index == word.length() && currNode.hasWord) return true;
        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode node : currNode.children) {
                if (search(word, index + 1, node)) return true;
            }
            return false;
        } else if (currNode.children[c - 'a'] != null) {
            return search(word, index + 1, currNode.children[c - 'a']);
        } else {
            return false;
        }
    }
}
public class WordDictionary {
    TrieNode tireNode;
    public WordDictionary() {
        tireNode = new TrieNode();
    }
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    public void addWord(String word) {
        // write your code here
        tireNode.add(word, 0);
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        return tireNode.search(word, 0, tireNode);
    }
}
