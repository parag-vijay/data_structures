

/* A better recursive algorithm to compute algebric multiplication */

class KaratsubaMultiplication
{
    long setKaratsubaMultiplication(long x, long y){
        long input_size = computeInputSize(x);
        return computeKaratsubaMultiplication(input_size, x, y);
    }

   private long computeKaratsubaMultiplication(long input_size,long x, long y){
       try{
        // long input_size = computeInputSize(x);
        System.out.println("Input Size="+input_size);
        if(input_size==1){
            System.out.println("Input size is 1");
            return x*y;
        }
        if(input_size%2!=0){
            input_size += 1;
            System.out.println("Input Size incremented by 1: "+input_size);
        }
        long padding = (long)Math.pow(10, Math.round(input_size/2));
        long a = x/padding;
        long b = x%padding;
        long c = y/padding;
        long d = y%padding;
        System.out.println("a="+a+" b="+ b+" c=" +c+" d="+d);

        long ac,bd,adPlusbc;
             ac = computeKaratsubaMultiplication(input_size/2, a, c);
             bd = computeKaratsubaMultiplication(input_size/2, b, d);
              adPlusbc = computeKaratsubaMultiplication(input_size/2, a+b, c+d)-ac-bd;
        
        System.out.println("ac="+ac+" ad+bc="+adPlusbc+" bd="+bd);
        return ac*(long)Math.pow(10, input_size)+adPlusbc*padding+bd;
       }
    catch(Exception e){
        System.out.println(e.getMessage());
        return -1;
    }
    }

   private long computeInputSize(long x){
        long result = 1;
        while(x/10!=0){
            result++;
            x = x/10;
        }
        return result;
    }


}