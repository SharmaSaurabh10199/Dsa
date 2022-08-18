package dataStructures.strings;

/*
ip: abc,
op: abc,acb,bac,bca,cab,cba;

approach:
making the tree here implies:
                      abc
                    /  \         \
                  a(bc) b(ac)      c(ba)
                / \     /  \        /   \
           ab(c) ac(b) ba(c) bc(a) cb(a)  ca(b)
      the idea is to swap elements and then didvding it inot the subproblems, 
      additionally since we are swapping we need to swap back(backtracking)
      for the root nodes

 */
public class PermutationsOfString {
    void printPermutations(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
            return;
        }
        for (int i = l; i <= r; i++) {
            str = swap(str, i, l);
            printPermutations(str, l + 1, r);
            // backtracking
            str = swap(str, i, l);
        }
    }

    String swap(String s, int i, int j) {
        char[] helper = s.toCharArray();
        char temp = helper[i];
        helper[i] = helper[j];
        helper[j] = temp;
        return new String(helper);
    }

    public static void main(String[] args) {
        PermutationsOfString p = new PermutationsOfString();
        p.printPermutations("abc", 0, 2);
    }
}
