
/**
 * Write a description of Part2 here.
 * 
 * @author (Gayan) 
 * @version (a version number or a date)
 */
public class Part2 {
    String findSimpleGene(String dna, String startCodon, String stopCodon){
        int atg = dna.indexOf(startCodon);
        if(atg != -1){
            int taa = dna.indexOf(stopCodon);
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
            String dna = findSimpleGene(s,"ATG","TAA");
            System.out.println(dna);
        }
    }
}
