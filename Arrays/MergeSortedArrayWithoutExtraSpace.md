# Merge Two Sorted Lists Without Extra Space
## Algo:
* Take two pinters i and j to start from initial index of each array
* Now we know that the last element of the first array is it's largest 
* We also know that in the sorted array all the elements of the second array are larger than the first array
* So we Replace any element which is in the second array and is smaller than any element of the first array 
* We replace the it with the largest of the first array

##Code:
```
void merge(int arr1[], int arr2[], int n, int m) {
    int i=n-1;
    int j=0;
    while(i>=0 and j<m)
    {
        if(arr1[i]>=arr2[j])
        {
            swap(arr1[i],arr2[j]);
            i--;
            j++;
        }
        else
        {
            break;
        }
    }
    sort(arr1,arr1+n);
    sort(arr2,arr2+m);
}
```
