package Chapter14;

class Trie {
    private final Trie[] node_list;
    private boolean is_end;

    public Trie() {
        // 单词均由小写字母组成
        // 一般情况可以用hashmap
        node_list = new Trie[26];
        // 该节点是否为字符串的结尾
        is_end = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.node_list[index] == null) node.node_list[index] = new Trie();
            node = node.node_list[index];
        }
        // 不要忘记
        node.is_end = true;
    }

    public boolean search(String word) {
        return searchPrefix(word) != null && searchPrefix(word).is_end;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.node_list[index] == null) return null;
            node = node.node_list[index];
        }
        return node;
    }
}

