import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_1475 {
    public static void main(String[] args){
        String s= " ";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            s = br.readLine();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        int[] arr = new int[10];
        for (int i = 0; i < s.length(); i++) {
            int num = Character.getNumericValue(s.charAt(i));
            if (num == 6) {
                arr[9]++;
            } else {
                arr[num]++;
            }
        }
        int max = 0;
        for (int i = 0; i < 9; i++) {
            max = Math.max(max,arr[i]); //max는 if문을 사용하지 않고 큰값을 max에 넣는다.
        }
        int nine = arr[9]/2;
        if (arr[9]%2==1) nine++;
        max = Math.max(max,nine);
        System.out.print(max);
    }
}
// {
//     public static void main(String[] args) {
//         String buffer = " ";
//         int N = 0;
//         int M = 1000000;
//         int zeroCount = 0;
//         int minSet = 0;
//         int[] nArray = new int[7];
//         int[] numArray = new int[10];


//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         try {
//             buffer = br.readLine();
//         } catch (Exception e) {
//             // TODO: handle exception
//         }
        
//         N = Integer.parseInt(buffer);

       
//         for(int i = 0; i < 7; i++)
//         {
//             if(N >= M)
//             {
//                 nArray[i] = N /M;
//                 N = N - (nArray[i] * M);
//             }
//             else 
//             {
//                 nArray[i] = 0;
//             }
//             M /= 10;
//         }

//         for(int i = 0; i < nArray.length; i++)
//         {
//             if(nArray[i] != 0)
//             {
//                 zeroCount = i;
//                 break;
//             }
//             else if(N ==0)
//             {
//                 zeroCount = 6;
//             }
            
//         }

//         for(int i = 0; i < nArray.length; i++)
//         {
//             for(int j = 0; j < 10; j++)
//             {
//                 if(nArray[i] == j)
//                 {
//                     numArray[j] += 1;
//                 }
//             }
//         }
        
//         numArray[0] =  numArray[0] - zeroCount;

//         if((numArray[6] + numArray[9]) % 2 ==0)
//         {
//             numArray[7] =  (numArray[6] + numArray[9])/2;
//         }
//         else if((numArray[6] + numArray[9]) % 2 !=0)
//         {
//             numArray[7] =  (numArray[6] + numArray[9])/2 +1;
//         }
        

//         for(int i = 0; i < numArray.length-1; i++)
//         {
//             if(numArray[i] > minSet)
//             {
//                 minSet = numArray[i];
//             }
//         }
//         System.out.println(minSet);
//     }
// }
