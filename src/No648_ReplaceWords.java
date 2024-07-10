import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class No648_ReplaceWords {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("batt");
        list.add("rat");

        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        System.out.println(new No648_ReplaceWords().replaceWords(list, "the cattle was rattled by the battery"));
        System.out.println(new No648_ReplaceWords().replaceWords(list1, "aadsfasf absbs bbab cadsfafs"));
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trieNode = new TrieNode();
        for (String dict : dictionary) {
            trieNode.insert(dict);
        }

        String[] result = sentence.split(" ");
        String rr = "";
        for (String r : result) {
            String temp = trieNode.search(r);
            rr = rr + " " + temp;
        }
        return rr.substring(1);
    }

    class TrieNode {
        public TrieNode[] children;
        public boolean isEndWord;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public void insert(String key) {
            // Initialize the currentNode pointer with the root node
            TrieNode currentNode = this;
            key = key.toLowerCase(Locale.ROOT);

            for (int i = 0; i < key.length(); i++) {
                int index = key.charAt(i) - 'a';
                // Create new node if not exist in currentNode pointer
                if (currentNode.children[index] == null) {
                    currentNode.children[index] = new TrieNode();
                }

                //Move to next children node
                currentNode = currentNode.children[index];
            }
            //Indicate the word end here
            currentNode.isEndWord = true;
        }

        public String search(String key) {
            // Initialize the currentNode  with the root node
            key = key.toLowerCase(Locale.ROOT);
            TrieNode currentNode = this;
            String result = "";
            // Iterate across the length of the string
            for (char c : key.toCharArray()) {
                //Get childNode from currentNode
                TrieNode childNode = currentNode.children[c - 'a'];
                if (currentNode.isEndWord) {
                    return result;
                } else {
                    result = result + c;
                }
                if (childNode == null) {
                    return key;
                }
                //step forward to next childNode
                currentNode = childNode;
            }

            return key;
        }
    }
}
