# Dutch National Flag : Sort the entities into groups of three
## Algorithm :
* Divide the array into 4 parts 
    * region containing 0 
    * region containing 1 
    * region containing unsorted elememts
    * region containing 2 
* Inititally 
    * mid = first index;
    * low = first index;
    * high = last index;
* Run a loop UNTIL unsorted region is empty (```mid <= high```)
* Switch ```array[mid]``` into three cases with break in each
    * case 0 : ```swap(array[low++], array[mid++])``` : swap low , mid and increment both 
    * case 1 : ```mid++```                            : increment mid  
    * case 2 : ```swap(array[mid],array[high--])```   : swap high and mid and decrement high
## CODE :
```
class Solution {
    public void sortColors(int[] nums) {
    int low=0;
    int mid=0;
    int high=nums.length-1;
        while(mid<=high){
            switch (arr[mid])    
            {        
            case 0:    
                swap(arr[low++], arr[mid++]);    
                break;       
            case 1:    
                mid++;    
                break;        
            case 2:    
                swap(arr[mid], arr[high--]);    
                break;    
            }
        }
    }
}
``` 
