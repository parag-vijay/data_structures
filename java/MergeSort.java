import com.sun.javafx.runtime.SystemProperties;

class MergeSort
{

    public int[] sort(int arr[]){
        try{
            // System.out.println("Array length = "+arr.length);
            // System.out.print("Sort called for array : { ");
            // for(int i:arr){
            //     System.out.print(i+", ");
            // }
            // System.out.println("}");

            if(arr.length==1){
                return arr;
            }
            int mid = (arr.length)/2;
            int arr1[] = new int[mid];
            int arr2[] = new int[arr.length-mid];
            for(int i=0;i<mid;i++){
                arr1[i]=arr[i];
            }
            for(int j=0;mid+j<arr.length;j++){
                arr2[j]= arr[mid+j];
            }
            // System.out.println("Arr1 length="+arr1.length+" Arr2 length="+arr2.length);

            int result[] =  merge(sort(arr1),sort(arr2));
            // System.out.print("Got result from merge!= {");
            // for(int i : result){
            //     System.out.print(i+", ");
            // }
            // System.out.println("}");
            return result;
        }catch(Exception e){
            System.out.println("Exception occured");
            System.out.println(e.toString());
            return arr;        }
        
    }
    private int[] merge(int a[], int b[]){
        System.out.println("In Merge");
        if(a.length==0){
            return b;
        }
        if(b.length==0){
            return a;
        }

        // System.out.print("Array a = {");
        // for(int q : a){
        //     System.out.print(q+", ");
        // }
        // System.out.println("}");

        // System.out.print("Array b = {");
        // for(int q : b){
        //     System.out.print(q+", ");
        // }
        // System.out.println("}");

        int c[] = new int[a.length+b.length];
        // System.out.println("a.len="+a.length+" b.len="+b.length+" c.len="+c.length);

        int k =0,i=0,j=0;
        while(i<a.length&&j<b.length&&k<c.length){
            if(a[i]<b[j]){
                c[k]=a[i];
                i++;
            }
            else{
                c[k]=b[j];
                j++;
            }
            k++;
        }
        
        if(i>=a.length&&k<c.length){
            while(k<c.length){
                c[k]=b[j];
                j++;
                k++;
            }
        }
        else if(j>=b.length&&k<c.length){
                while(k<c.length){
                    c[k]=a[i];
                    i++;
                    k++;
                }
        }
        // System.out.print("In merge c array = {");
        // for(int p : c){
        //     System.out.print(p+", ");
        // }
        // System.out.println("}");
            return c;
    }
}