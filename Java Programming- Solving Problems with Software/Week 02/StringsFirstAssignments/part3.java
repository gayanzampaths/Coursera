
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    boolean twoOccurrences(String stringa, String stringb){
        int counter = 0;
        int pos = stringb.indexOf(stringa);
        if(pos!=-1){
            while(pos!=-1){
                stringb = stringb.substring(pos+1);
                pos = stringb.indexOf(stringa);
                counter ++;
            }
            if(counter>1){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    void testing(){
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println(twoOccurrences("atg", "ctgtatgta"));
        System.out.println(lastPart("an","banana"));
        System.out.println(lastPart("zoo","forest"));
    }
    
    String lastPart(String stringa, String stringb){
        int p = stringb.indexOf(stringa);
        if(p != -1){
            return stringb.substring(p,stringa.length()+2);
        }else{
            return stringb;
        }
    }
}
