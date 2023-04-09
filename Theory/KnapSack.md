# KnapSack Method
## 0/1 KnapSack Method
- Given is:
  - Capacity of Bag
  - Array of Weights having weight of each item
  - Array of Profits having profit of each item
### Algo
- Brute Force :
  * We will take all the possiblities and find the optimal (min or max) profit 
  * No of cases is 2^n if there are n elements
- Dynamic Programming (Tabulation)
  * We Take a matrix of N * C where N is the No of Elements and C is the Capacity of the bag
  * Formula to fill the martix say i rows and w cols with profit of each p[i] and weight be w[i]
  * Fill the matrix with max profit 
  * V[i,w] = MAX(V[i-1 , w] , V[i-1 , w-w[i]] + p[i])
  * After Filling the matrix check for the largest value and the topmost row where it was found
  * Subtract the weight and repeat the same
  
