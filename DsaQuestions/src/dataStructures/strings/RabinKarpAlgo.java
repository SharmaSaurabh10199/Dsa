package dataStructures.strings;

/*
 this algorithm is for pattern matching in strings
 steps:
 create the hash function of pattern and text, iterate over text and keep matching text.
 if there is a match, go for checking if the pattern is same in text.

 */
public class RabinKarpAlgo {
    int prime = 101;

    // function to calculate the hash
    long createHash(char[] str, int start, int end) {
        long hash = 0;
        for (int i = start; i <= end; i++) {
            hash += str[i] * Math.pow(prime, i);
        }
        return hash;
    }

    // for recalculating hash from previous value
    long reCalculateHash(char[] str, int oldIndex, int newIndex, long oldHash) {
        long newHash = oldHash - str[oldIndex];
        newHash /= prime;
        newHash += str[newIndex] * Math.pow(prime, newIndex - oldIndex - 1);
        return newHash;
    }

    // for checking match if the hash function matches
    boolean checkMatch(char[] text, char[] pattern, int start1, int end1, int start2, int end2) {
        if ((end1 - start1) != (end2 - start2)) {
            return false;
        }
        while (start1 <= end1) {
            if (text[start1] != pattern[start2]) {
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }

    // for iterating and checking the match
    int rabinKarp(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        long textHash = createHash(text, 0, m - 1);
        long patternHash = createHash(pattern, 0, m - 1);
        for (int i = 1; i <= n - m + 1; i++) {
            if ((textHash == patternHash) && checkMatch(text, pattern, i - 1, i + m - 2, 0, m - 1)) {
                return i - 1;
            }
            if (i < n - m + 1) {
                textHash = reCalculateHash(text, i - 1, i + m - 1, textHash);
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        RabinKarpAlgo r= new RabinKarpAlgo();
        System.out.println(r.rabinKarp("TusharRoy".toCharArray(),"Roy".toCharArray()));
    }
}
