import jdk.jfr.Frequency;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class WritePoetry {

    /**
     * read File to array
     *
     * @param file contains document to read
     * @param startWord first word of poem
     * @param length how many words (including punctuation to generate
     * @param printHashtable if true, pring hash table
     * @return a generated poem
     */
    public String writePoem(String file, String startWord, int length, boolean printHashtable)  {

        try {
            //create Hash table
            HashTable<String, WordFreqInfo> myTable = buildHash(file);
            if (printHashtable) {
                System.out.println(myTable.toString(myTable.size()));
            }

            String poem = "";
            String currWord = startWord;
            poem = poem + currWord;

            for (int i = 0; i < length-1; i++) {

                WordFreqInfo currFreq = myTable.find(currWord);

                Random rnd = new Random();
                int num = rnd.nextInt(currFreq.getOccurCount());

                currWord = currFreq.getFollowWord(num);

                //poem += currWord;
                // If currWOrd is punct do crap
                if (currWord.length() == 1 && !Character.isAlphabetic(currWord.charAt(0))) {
                    poem += currWord + "\n";

                }
                else {
//                    poem = String.join(" ", poem, currWord);
                    char lastChar = poem.charAt(poem.length() - 1);
                    if (lastChar != '\n'){
                        poem += " ";
                    }
                    poem += currWord;
                }

            }

            //check for last punctuation
            char lastChar = poem.charAt(poem.length() - 1);
            if (Character.isAlphabetic(lastChar)){
                poem += ".";
                //System.out.println("printed");
            }
            return poem;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    private HashTable<String, WordFreqInfo> buildHash(String fileName) throws FileNotFoundException {
        // create hash table
        HashTable<String,WordFreqInfo> hashTable = new HashTable<>();
        // Create the array of words
        ArrayList<String> wordArray = readToArray(fileName);
//        System.out.println(wordArray);

        for (int i = 0; i < wordArray.size(); i++) {
            String currWord = wordArray.get(i);

            if (hashTable.contains(wordArray.get(i))) {
                //if it exists, increment count
                WordFreqInfo currWordInfo = hashTable.find(currWord);
                if (i < wordArray.size() - 1) {
                    String nextWord = wordArray.get(i + 1);
                    currWordInfo.updateFollows(nextWord);
                }
            }
            else {
                //if not exists, create WordFreqInfo
                WordFreqInfo newWordInfo = new WordFreqInfo(currWord, 0);
                if (i < wordArray.size() - 1) {
                    String nextWord = wordArray.get(i + 1);
                    newWordInfo.updateFollows(nextWord);
                }
                hashTable.insert(currWord, newWordInfo);
                //System.out.println(newWordInfo);

            }

        }
        //System.out.println(hashTable);

        return hashTable;

        /*
        go through each word in the array.
        need to know what words follow said word, and how many times
        create HashTable table
        table.insert(word, [wordProb, nextProb...])
        table.insert(word, [wordProb, nextProb...])
         */
    }


    private ArrayList<String> readToArray(String file) throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<>();

        try (Scanner s = new Scanner(new File(file))) {
            while (s.hasNext()) {
                String word = s.next();
                // word = word.toLowerCase();

                char lastChar = word.charAt(word.length() - 1);

                if (!Character.isAlphabetic(lastChar)){
                    words.add(word.toLowerCase().substring(0, word.length()-1));
                    words.add(word.toLowerCase().substring(word.length()-1));
                }
                else {
                    words.add(word.toLowerCase());
                }
            }
        }
        return words;

    }

}
