package _recurssionAndBacktracking2;

import java.util.Scanner;
//1. You are given a list of words, a list of alphabets(might be repeating) and score of every alphabet
//     from a to z.
//2. You have to find the maximum score of any valid set of words formed by using the given
//     alphabets.
//3. A word can not be used more than one time.
//4. Each alphabet can be used only once.
//5. It is not necessary to use all the given alphabets.
public class MaxScoreSetInGivenStringOfWords {
    public static int solution(String[] words, int[] farr, int[] score, int idx) {
        //write your code here
        if(idx==words.length){
            return 0;
        }
        int notSelected = solution(words,farr,score,idx+1);

        int scoreWord=0;
        String word = words[idx];
        int i=0;
        boolean flag = true;
        for(i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(farr[ch-'a']==0){
                flag = false;
                break;
            }

            farr[ch-'a']--;
            scoreWord+=score[ch-'a'];
        }
        int wordSelected = 0;
        if(flag){
            wordSelected = scoreWord + solution(words,farr,score,idx+1);
        }

        for(int j=0; j < i ; j++){
            char ch = word.charAt(j);
            farr[ch-'a']++;
        }
        return Math.max(notSelected,wordSelected);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nofWords = scn.nextInt();
        String[] words = new String[nofWords];
        for(int i = 0 ; i < words.length; i++) {
            words[i] = scn.next();
        }
        int nofLetters = scn.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = scn.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {
            score[i] = scn.nextInt();
        }
        if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
                || score.length == 0) {
            System.out.println(0);
            return;
        }
        int[] farr = new int[score.length];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        System.out.println(solution(words, farr, score, 0));

    }
}
