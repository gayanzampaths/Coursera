
/**
 * Write a description of StringsFirstAssignments here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    String findSimpleGene(String dna){
        int atg = dna.indexOf("ATG");
        if(atg != -1){
            int taa = dna.indexOf("TAA");
            if(taa != -1){
                int StrLength = dna.substring(atg, taa).length();
                if(StrLength % 3 == 0){
                    return dna.substring(atg, taa+3);
                }else{
                    return "";
                }
            }else{
                return "";
            }
        }else{
            return "";
        }
    }
    
    void testSimpleGene(){
        String dnaS[] = {"ATATAAATTTGGGGATAATAA","ATGAAATTTAAATTTAAAT","AAAATTTTAAAATTTTAAATTT","AAATGAAATTTAGGTTTTAA","AAATGAAATTTATTTTAA"};
        
        for(String s: dnaS){
            String dna = findSimpleGene(s);
            System.out.println(dna);
        }
    }
}
