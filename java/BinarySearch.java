

class BinarySearch
{
    int search(int[] a, int first, int last, int val)
    {
        try{
        if(first==last)
        {
            if(a[first]==val){
                System.out.println("First= "+first);
                return first;
            }
            else{
                return -1;
            }
        }
        
        int mid = (last+first)/2;
        System.out.println("Mid= "+mid);
        if(a[mid]==val){
            return mid;
        }
        else if(a[mid]>val){
            return search(a, first, mid-1, val);
        }
        else
        {
            return search(a, mid+1, last, val);
        }
    }
    catch(Exception e){
     System.out.println("Exception occured");
     System.out.println(e.toString());
     return -1;
 }
    }
 
}