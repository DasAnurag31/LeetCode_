# MERGE SORT PARTIAL LOGIC
## Algo:
* start from end and follow the code
## Code:
```
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int a = m-1;
    int b = n-1;
    int i = m+n-1;
    while(b >= 0){
        if(a >= 0 && A[a] > B[b]){
            A[i] = A[a];
            a--;
        }
        else{
            A[i] = B[b];
            b--;
        }
        i--;
    }
    }
}
```
