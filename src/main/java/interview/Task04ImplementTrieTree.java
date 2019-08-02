package interview;

public class Task04ImplementTrieTree {

    // Trie Tree

//apple
//and
//anp
//ans
//anse
//do

//search(apple) => true
//search(appl) => false

//[a-z] . 26
/*               ROOT
            /             \ ...   \
           a               d ...   z
         /   \             |
         n     p           o
       / | \     \
      p  d  s      p
            |        \
            e         l
                    /  \
                   s     e(*)


Implement Trie Tree
- void insert(String word) => add word into trie tree
- boolean search(String word) => returns true if there is a word in tree that is the same as word
- boolean startsWith(String phrase) => returns true if there is a word in trie tree that starts with that phrase
*/

        private static final int LETTERS_COUNT_IN_ALPHABET = 26;

        public static class TrieTree {

            //private Node root = new Node();
            private final Node[] rootes = new Node[LETTERS_COUNT_IN_ALPHABET];

            private class Node {
                char val;
                boolean isWordEnd = false;
                final Node[] nodes = new Node[LETTERS_COUNT_IN_ALPHABET];

                public Node(char val) {
                    this.val = val;
                }
            }


            public void insert(String word) {
                if (word.length() > 0) {
                    char firstChar = word.charAt(0);

                    Node root = insert2Node(firstChar, rootes);
                    for (int i = 1; i < word.length(); i++) {
                        root = insert2Node(word.charAt(i), root.nodes);
                    }
                    root.isWordEnd = true;
                }
            }

            public boolean search(String word) {
                boolean isWord = false;
                if (word.length() > 0) {
                    Node[] nodes = rootes;
                    for (int i = 0; i < word.length(); i++) {
                        char character = word.charAt(i);
                        Node curNode = nodes[character - 'a'];
                        if (curNode == null) {
                            return false;
                        }
                        nodes = curNode.nodes;
                        isWord = curNode.isWordEnd;
                    }
                }
                return isWord;
            }

            //startsWith(appl) => true
            public boolean startsWith(String phrase) {
                if (phrase.length() > 0) {
                    Node[] nodes = rootes;
                    for (int i = 0; i < phrase.length(); i++) {
                        char character = phrase.charAt(i);
                        Node curNode = nodes[character - 'a'];
                        if (curNode == null) {
                            return false;
                        }
                        nodes = curNode.nodes;
                    }
                    return true;
                }
                return false;
            }

            private Node insert2Node(char val, Node[] nodes) {
                Node root = nodes[val - 'a'];
                if (root == null) {
                    root = new Node(val);
                }
                return root;
            }


        }


}
