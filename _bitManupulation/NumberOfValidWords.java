package _bitManupulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class NumberOfValidWords {
    static HashMap<Character,ArrayList<Integer>> map = new HashMap<>();

    public static void fillMapWithWordInt(String[] words){
        for(String word:words){
            int wordMask=0;
            for(int i=0; i<word.length();i++){
                int targetBit = word.charAt(i)-'a';
                wordMask = wordMask | (1<<targetBit);
            }
            char ch = 'a';
            while (ch<='z'){
                int targetBit= ch-'a';
                int checkMask = 1<<targetBit;
                if((wordMask & checkMask)!=0){
                    if(!map.containsKey(ch)){
                        map.put(ch,new ArrayList<>());
                    }
                    map.get(ch).add(wordMask);
                }
                ch++;
            }
        }
    }

    private static int getPuzzleMask(String puzzle) {
        int puzzleMask=0;
        for(int i=0; i<puzzle.length(); i++){
            int targetBit = puzzle.charAt(i)-'a';
            puzzleMask = puzzleMask | (1<<targetBit);
        }
        return puzzleMask;
    }
    public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        //write your code here
        ArrayList<Integer> ans = new ArrayList<>();

        // to create wordMask and put it into hashmap which contains list of words corresponding to characters
        fillMapWithWordInt(words);

        for(int i=0; i< puzzles.length; i++){
            int puzzleMask = getPuzzleMask(puzzles[i]);
            int count = 0;
            ArrayList<Integer> list = map.get(puzzles[i].charAt(0));
            if(list == null){
                ans.add(count);
                continue;
            }
            for(int wordMask:list){
                if((wordMask & puzzleMask) == wordMask){
                    count++;
                }
            }
            ans.add(count);
        }
        return ans;
    }



    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0 ; i < words.length; i++) {
            words[i] = scn.next();
        }
        int m = scn.nextInt();
        String[] puzzles = new String[m];
        for (int i = 0 ; i < m ; i++) {
            puzzles[i] = scn.next();
        }

        ArrayList<Integer> ans = findNumOfValidWords(words, puzzles);
        for (int i=0; i<puzzles.length;i++) {
            System.out.println(puzzles[i] + " -> " + ans.get(i));
        }
    }
}
