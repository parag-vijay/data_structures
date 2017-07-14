public class RadixSort{

    int n = 10;
    // Sort an integer array
    public int[] doRadixSort(int[] arr){
        int output[] = new int[arr.length];

        // Find the maximum # of significant digits in the input array
        int maxSig = findMostSignificantDigitsInArray(arr);

        //  Sort the elements of input array based on each significant digit per iteration.
        for(int i=1;i<=maxSig;++i,n=(int)Math.pow(10,i)){

            int[] countArr = new int[10];

            // Calculate the count just like counting sort
            for(int j : arr){
                countArr[(j%n)/(n/10)]++;   
            }

            // Modify the count
            for(int index =1; index<countArr.length;index++){
                countArr[index] += countArr[index-1];
            }

            //Create output array by sorting input array in reverse to maintain the position of elements
             for(int index = arr.length-1;index >=0;index--){
                output[--countArr[(arr[index]%n)/(n/10)]] = arr[index];
            }
            
            arr = output.clone();

            //Testing
            System.out.print("For "+i+" significant digit, arr = ");
            for(int num : arr){
                System.out.print(num+" ");
            }
            System.out.println();

        }
        return arr;
    }

    private int findMostSignificantDigitsInArray(int[] arr){

        int result=1;

        int max = 0;

        for(int i : arr){
            if(i>max){
                max = i;
            }
        }
        while(max/10!=0){
            result++;
            max = max/10;
        }
        return result;
    }
}