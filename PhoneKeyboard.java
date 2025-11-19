import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class PhoneKeyboard{
    public static void main(String[] args) {
        var pk = new PhoneKeyboard() ; 
        pk.letterCombinations("5678"); 
    }
    public List<String> letterCombinations(String digits) {       
        List<String> ans = new ArrayList<>();
        HashMap<Character ,String> hm = new HashMap<>(); 
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");       

      if(digits.length() == 1){
        String s1 = hm.get(digits.charAt(0));        
        ans = giveCombinations(s1, "");  
        return ans;       
      }
      if(digits.length()==2){
        String s1 = hm.get(digits.charAt(0)); 
        String s2 = hm.get(digits.charAt(1));
        System.out.println(s1);
        System.out.println(s2);
        ans = giveCombinations(s1, s2);
        System.out.println(ans);
        return ans; 
      }
      if(digits.length()==3){
        String s1 = hm.get(digits.charAt(0)); 
        String s2 = hm.get(digits.charAt(1));
        String s3 = hm.get(digits.charAt(2)); 
        List<String> ans12 = giveCombinations(s1, s2);
        List<String> finaList = new ArrayList<>();
        for(int i =0; i <s3.length();i++){
            for(String s:ans12){
                finaList.add(""+s+s3.charAt(i));
            }
        }
        System.out.println(finaList);
        return finaList;
    }
    if(digits.length()==4){
         String s1 = hm.get(digits.charAt(0)); 
        String s2 = hm.get(digits.charAt(1));
        String s3 = hm.get(digits.charAt(2));
        String s4 = hm.get(digits.charAt(3)); 
        List <String> ans12 = giveCombinations(s1, s2);
        List<String> finaList123 = new ArrayList<>();
        for(int i =0; i <s3.length();i++){
            for(String s:ans12){
                finaList123.add(""+s+s3.charAt(i));
            }
        }
        List<String> finalist1234 = new ArrayList<>();
        for(int i =0;i<s4.length();i++){
            for(String s:finaList123){
                finalist1234.add(""+s+s4.charAt(i));
            }
        }
        System.out.println(finalist1234);
        return finalist1234;
    }
        return new ArrayList<>();      
    }

    List<String> giveCombinations(String s1 , String s2){
        List<String> list = new ArrayList<>();
        if(s1.equals("") || s2.equals("")){
            for(int i =0;i<s1.length();i++){
                list.add(String.valueOf(s1.charAt(i)));
            }
            return list;
        }
        for(int i =0; i<s1.length();i++){            
            for(int j=0 ; j<s2.length();j++){
                list.add(""+s1.charAt(i)+s2.charAt(j));
            }
        }
        return list;
    }
}