import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class baekjoon_5430 {
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
				
		int n = Integer.parseInt(br.readLine());
		
		while (n-- > 0) {
			String ac = br.readLine();
			int elementNum = Integer.parseInt(br.readLine());
			String inputArr = br.readLine();
			boolean isReversed = false;
			boolean isError = false;
			
			st = new StringTokenizer(inputArr, "[],");
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < elementNum; i++) 
				list.add(Integer.parseInt(st.nextToken()));
			
			for (int i = 0; i < ac.length(); i++) {				
				if (ac.charAt(i) == 'R' && !isReversed) {
					isReversed = true;
				}
				else if (ac.charAt(i) == 'R' && isReversed) {
					isReversed = false;
				}
				if (ac.charAt(i) == 'D') {
					if (list.size() == 0) {
						isError = true;
						break;
					}
					if (!isReversed)
						list.remove(0);
					else
						list.remove(list.size()-1);
				}
			}
			
			if (isError) sb.append("error\n");
			else {
				if (isReversed) {
					/*sb.append("[");
					for (int i = list.size()-1; i >= 0; i--) {
						sb.append(list.get(i) + ",");
					}
					if (sb.charAt(sb.length()-1) == ',')
						sb.deleteCharAt(sb.length()-1);
					sb.append("]\n");*/
					
					ListIterator<Integer> it = list.listIterator(list.size());
					sb.append("[");
					while (it.hasPrevious()) {
						sb.append(it.previous() + ",");
					}
					if (sb.charAt(sb.length()-1) == ',')
						sb.deleteCharAt(sb.length()-1);
					sb.append("]\n");
				}
				else {
					ListIterator<Integer> it = list.listIterator();
					sb.append("[");
					while (it.hasNext()) {
						sb.append(it.next() + ",");
					}
					if (sb.charAt(sb.length()-1) == ',')
						sb.deleteCharAt(sb.length()-1);
					sb.append("]\n");
				}
			}
			
			/*for (int i = 0; i < list.size(); i++) {
				if (i == 0)
					sb.append("[");
				if (i == list.size()-1) {
					sb.append(list.get(i) + "]");
					break;
				}
				sb.append(list.get(i) + ",");
			}
			sb.append("\n");*/
		}
		System.out.println(sb);
		
	}	
} 

//========================첫번째 ArrayList를 덱처럼 푼거
// import java.io.*;
// import java.util.*;

// public class Back_5430 {
//     public static void main(String[] args) throws IOException {
//         Deque<Integer> numDeque = new ArrayDeque<>();
//         int numOfCase = 0;
//         Boolean rIsOn = false;
//         boolean error = false;
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         numOfCase = Integer.parseInt(br.readLine());
    
//         String[] result = new String[numOfCase];
//         String command = "";
//         int numOfElements = 0;
//         String inputArr = "";
//         for(int i = 0; i < numOfCase; i++)
//         {
//             list.clear();
//             rIsOn = false;
//             command = br.readLine();
//             numOfElements = Integer.parseInt(br.readLine());
//             inputArr = br.readLine();
            
//             char[] charArr = new char [command.length()];
//             for(int j = 0; j < command.length(); j++)
//             {
//                 charArr[j] = command.charAt(j);
//             }
//             StringTokenizer st = new StringTokenizer(inputArr, "[],");
//             list.clear();
//             for(int j = 0; j < numOfElements; j++){
//                 list.add(Integer.parseInt(st.nextToken()));
//             }

            
//             for(int j = 0; j < charArr.length; j++){
//                 if(charArr[j] == 'R'){
//                     if(rIsOn == false) rIsOn = true;
//                     else if(rIsOn == true)rIsOn = false;
//                     }
//             else if(charArr[j] == 'D' && list.size() - 1 >= 1 ){
//                     if(rIsOn == false)  list.remove(0);
//                     else if(rIsOn == true) list.remove(list.size()-1);
//                 }
//             else if(charArr[j] == 'D' && list.size() - 1 < 1 ){
//                 result[i] = "error";
//                 list.clear();
//             }
//             }
//             if(rIsOn == false && list.size() != 0){
//                 String ans = "";
//                 ans += "[";
//                 for(int k = 0; k < list.size(); k++){
//                     ans += list.get(k);
//                     if(k != list.size()-1) ans += ",";
//                 }
//                 ans += "]";
//                 result[i] = ans;
//             }
//             else if(rIsOn ==true && list.size() != 0){
//                 String ans = "";
//                 ans += "[";
//                 for(int k = (list.size() -1); k >= 0; k--){
//                     ans += list.get(k);
//                     if(k != 0) ans += ",";
//                 }
//                 ans += "]";
//                 result[i] = ans;
//             }
            
//         }

//         for(int i = 0; i < result.length; i++){   
//             bw.write(result[i]+"\n");
//         }
//         bw.flush();
//         bw.close(); 
//}

//===================================2번째 덱으로 푼거
// import java.io.*;
// import java.util.*;

// public class Back_5430 {
//     public static void main(String[] args) throws IOException {
//         Deque<Integer> numDeque = new ArrayDeque<>();
//         int numOfCase = 0;
//         Boolean rIsOn = false;
//         boolean error = false;
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         numOfCase = Integer.parseInt(br.readLine());
    
//         String[] result = new String[numOfCase];
//         String command = "";
//         int numOfElements = 0;
//         String inputArr = "";

//         for(int i = 0; i < numOfCase; i++)
//         {
//             numDeque.clear();
//             rIsOn = false;
//             error = false;
//             command = br.readLine();
//             numOfElements = Integer.parseInt(br.readLine());
//             inputArr = br.readLine();

//             StringTokenizer dequTokenizer = new StringTokenizer(inputArr, "[],");
//             numDeque.clear();
//             for(int j = 0; j < numOfElements; j++){
//                 numDeque.addFirst(Integer.parseInt(dequTokenizer.nextToken()));
//             }
//             for (int j = 0; j < command.length(); j++) {
// 				switch (command.charAt(j)) {
// 					case 'R':
//                     rIsOn = !rIsOn;
// 						break;

// 					case 'D':
// 						if (!numDeque.isEmpty()) {
// 							if (rIsOn) { // 순방향
// 								numDeque.pollFirst();
// 							} else { // 역방향
// 								numDeque.pollLast();
// 							}
// 							break;
// 						} else {
// 							error = true;
// 							break;
// 						}
// 					default:
// 						break;
// 				}

// 				// 비어있는 덱 원소 삭제 시도시
// 				if (error)
// 					break;
// 			}
//             if (error) { // 비어있는 덱 원소 삭제 시도시
// 				result[i] = "error";
// 			} 
//             else {
//                 String ans = "";
// 				ans += "[";
// 				if (rIsOn) {
// 					while (!numDeque.isEmpty()) {
// 						ans += numDeque.pollFirst();
// 						if (numDeque.isEmpty())
// 							break;
//                             ans += ",";
// 					}

// 				} else {
// 					while (!numDeque.isEmpty()) {
// 						ans += numDeque.pollLast();
// 						if (numDeque.isEmpty())1
// 							break;
//                             ans += ",";
// 					}
// 				}
// 				ans +=  "]";
//                 result[i] = ans;
// 			}
//         }

//         for(int i = 0; i < result.length; i++){   
//             bw.write(result[i]+"\n");
//         }
// 		bw.flush();
//         bw.close(); 
//     }
// }