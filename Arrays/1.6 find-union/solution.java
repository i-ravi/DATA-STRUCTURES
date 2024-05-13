
//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> ans = new ArrayList();
        int i=0;
        int j=0;
        while (i<arr1.length && j<arr2.length){
            int ansLen = ans.size();
            int lastElem = (ansLen == 0) ? Integer.MAX_VALUE : ans.get(ansLen-1);

            // for skipping duplicate value
            while (i < (arr1.length - 1) && arr1[i] == arr1[i+1]){
                i++;
            }
            
            while (j < (arr2.length - 1) && arr2[j] == arr2[j+1]){
                j++;
            }
            
            // insert one value at a time
            int val1 = arr1[i];
            int val2 = arr2[j];
            if (val1 < val2 && val1 != val2){
                if (lastElem != val1){
                    ans.add(val1);
                }
                i++;
            } else if (val1 > val2 && val1 != val2) {
                if (lastElem != val1){
                    ans.add(val2);
                }
                j++;
            } else {
                if (lastElem != val1){
                    ans.add(val1);
                }
                i++;
                j++;
            }
        }
        
        // logic if any one array greater in length than other
        while (i<arr1.length){
            int len = ans.size();
            int lastElem = ans.get(len-1);
            int val1 = arr1[i];
            if (val1 != lastElem){
                ans.add(val1);
            }
            i++;
        }
        
        while (j<arr2.length){
            int len = ans.size();
            int lastElem = ans.get(len-1);
            int val2 = arr2[j];
            if (val2 != lastElem){
                ans.add(val2);
            }
            j++;
        }
        
        return ans;
    }
}



