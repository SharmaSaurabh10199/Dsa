package algorithms.hashing;

public class Theory {
    // this class contains all the important theoritical points for hashtables in bullet points:


    //---------Hash Tables----------------
    /*
     -> in practice, hashing performs extremely well. Under reasonable assumptions, the average time to search for an element in
        a hash table is o(1).


     --> Direct address table:
        This is simply an array having key as index and having the vlaues as array elements

        -- It is feasiable and good when the no of the elements are small.
        -- insert, delete search all the operations are in o(1);


     --> Hash Tables:
       -- if u is too large, direct address table won't be practical. or set of the keys may e very smakke relative to u so space
        allocated to t will be wasted.

       -- we can map the keys to the Hash-table slots using hash function.

       -- t[j] contains linked list of all the the keys whose hash value is j, two keys hitting on same slot is called as colliosion

       -- Chaining: In chaining, we place all the elements that hash to the same slot into the same
linked list, as Figure 11.3 shows. Slot j contains a pointer to the head of the list of
all stored elements that hash to j ; if there are no such elements, slot j contains NI

       -- doubly linked list is used so that item can be deleted easiy

       --the worst case time can be o(n) for searching if all the keys hit same slot

       -- uniform hashing:  any given
element is equally likely to hash into any of the m slots, independently of where
any other element has hashed to.

    --> Hash functions:
       -- A good hash function satisfies (approximately) the assumption of simple uniform
hashing:
       -- one ex could be h(k)= k%table.size;






     */
}
