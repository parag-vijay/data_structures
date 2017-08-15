import java.math.BigInteger;

class KaratsubaBigMultiplication
{
    public BigInteger multiply(BigInteger x, BigInteger y){
        try{
            int input_size = Math.min(findSize(x),findSize(y));
            System.out.println("Input Size = "+input_size);
            if(input_size<=1){
                System.out.println("Input Size is less than 2");
                return x.multiply(y);
            }
            if(input_size%2!=0){
                input_size += 1;
                System.out.println("Input Size incremented by 1: "+input_size);    
            }
            BigInteger fullPadding = BigInteger.TEN.pow(input_size);
            BigInteger halfPadding = BigInteger.TEN.pow(input_size/2);
            BigInteger a = x.divideAndRemainder(halfPadding)[0];
            BigInteger b = x.divideAndRemainder(halfPadding)[1];
            BigInteger c = y.divideAndRemainder(halfPadding)[0];
            BigInteger d = y.divideAndRemainder(halfPadding)[1];

            System.out.println("a="+a+" b="+b+" c="+c+" d="+d);

            BigInteger ac = multiply(a,c);
            BigInteger bd = multiply(b, d);
            BigInteger adPlusbc = multiply(a.add(b),c.add(d)).subtract(ac).subtract(bd);

            System.out.println("ac="+ac+" adPlusbc="+adPlusbc+" bd="+bd);
            System.out.println("Full Padding = "+fullPadding+" half Padding="+halfPadding);
            return ac.multiply(fullPadding).add(adPlusbc.multiply(halfPadding)).add(bd);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return BigInteger.ZERO;
        }
    }

    int findSize(BigInteger x){
        try{
           return x.toString().length();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
}