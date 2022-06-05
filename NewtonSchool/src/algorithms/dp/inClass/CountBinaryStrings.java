package algorithms.dp.inClass;
/*
// Given a value of N, then we need to tell the total possible cases of
// creating binary strings of length N where given that two adjacent positions
// can never be 0.

// Ex: N = 4
// O/P -> 8
 */
public class CountBinaryStrings {

    // could have been done by using dp array too
    int  countBinaryStrings(int n){
        int old0=1;
        int old1=1;
        int new0=old0;
        int new1=old1;
        for (int i = 2; i <=n ; i++) {
            new0=old1;
            new1=old1+old0;
            old0=new0;
            old1=new1;
        }
        return new0+new1;
    }
}
