package algorithms.dp.inClass;
/*
There is a road and on both sides of road, the architect can plan buildings in N slots.
// There is a condition that every two buildings must have a space between them.
// Then in how many different possible ways, can the architect do the planning.

--> approach:
     the approach is very simple, we have n slots on the one side, we can first find the no of ways for the one sides,
     and total no including the other side will be n^2, if n ways are for one side.
 */


public class bulidingPlanning {
    int  countBinaryStrings(int n){
        int oldBuilding=1;
        int oldSpace=1;
        int newBuilding =oldBuilding;
        int newSpace =oldBuilding;
        for (int i = 2; i <=n ; i++) {
            newBuilding =oldBuilding;
            newSpace =oldBuilding+oldSpace;
            oldSpace= newBuilding;
            oldBuilding= newSpace;
        }
        int oneSideWays= newBuilding + newSpace;
        // total ways= oneSidewys*onesideways
        return oneSideWays*oneSideWays;
    }
}
