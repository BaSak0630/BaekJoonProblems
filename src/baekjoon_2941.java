import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_2941 {
    public static void main(String[] args) {
        String s = " ";
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            s = br.readLine();
        } catch (Exception e) {
        }
        count = s.length();
        if(s.charAt(0) == '=')
        {
            count -= 1;
        }
        if(s.charAt(0) == '-')
        {
            count -= 1;
        }
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == 'c' && i+1 != s.length()){
                if(s.charAt(i+1) == '=') count -= 1;
                else if(s.charAt(i+1) == '-') count -= 1;
            }
            else if(s.charAt(i) == 'd'&& i+1 != s.length()){
                if(s.charAt(i+1) == 'z'&& i+2 != s.length()){
                    if(s.charAt(i+2)== '=')
                    { 
                        count -= 2;
                        i += 2;
                    }
                }
                else if(s.charAt(i+1) == '-') count -= 1;
            }
            else if(s.charAt(i) == 'l'&& i+1 != s.length()){
                if(s.charAt(i+1) == 'j') count -= 1;
            }
            else if(s.charAt(i) == 'n'&& i+1 != s.length()){
                if(s.charAt(i+1) == 'j')count -= 1;
            }
            else if(s.charAt(i) == 's'&& i+1 != s.length()){
                if(s.charAt(i+1) == '=')count -= 1;
            }
            else if(s.charAt(i) == 'z'&& i+1 != s.length()){
                if(s.charAt(i+1) == '=') count -= 1;
            }
            else if(s.charAt(i) == '='&& i+1 != s.length()){
                if(s.charAt(i+1) == '=') count -= 1;
                else if (s.charAt(i+1) == '-') count -= 1;
            }
            else if(s.charAt(i) == '-'&& i+1 != s.length()){
                if(s.charAt(i+1) == '=') count -= 1;
                else if (s.charAt(i+1) == '-') count -= 1;
            }
        }
        System.out.println(count);
    }
} 