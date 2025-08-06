import java.io.*;
import java.util.*;

public class Main {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<Integer> wordIndices = new ArrayList<>();
    }

    static class Result {
        int maxLength = -1;
        int bestSIndex = -1;
        int bestTIndex = -1;
        String word1 = "";
        String word2 = "";

        void updateWithOrder(int length, int sIndex, int tIndex, String[] words) {
            if (length > maxLength ||
                    (length == maxLength && sIndex < bestSIndex)) {
                maxLength = length;
                bestSIndex = sIndex;
                bestTIndex = tIndex;
                word1 = words[sIndex];
                word2 = words[tIndex];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        TrieNode root = new TrieNode();
        Result result = new Result();
        
        for (int i = 0; i < N; i++) {
            insertAndFind(root, words[i], i, words, result);
        }

        System.out.println(result.word1);
        System.out.println(result.word2);
    }

    private static void insertAndFind(TrieNode root, String word, int wordIndex, String[] words, Result result) {
        TrieNode current = root;

        for (int depth = 0; depth < word.length(); depth++) {
            int charIndex = word.charAt(depth) - 'a';

            if (current.children[charIndex] == null) {
                current.children[charIndex] = new TrieNode();
            }

            current = current.children[charIndex];
            
            for (int existingIndex : current.wordIndices) {
                int prefixLen = depth + 1;
                if (existingIndex < wordIndex) {
                    result.updateWithOrder(prefixLen, existingIndex, wordIndex, words);
                } else {
                    result.updateWithOrder(prefixLen, wordIndex, existingIndex, words);
                }
            }
            
            current.wordIndices.add(wordIndex);
        }
    }
}