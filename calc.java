import java.util.ArrayList;
import java.util.List;

import tnode.Treenode;

public class calc{

    static List<Token> tokenise(char[] rawArray){
        List<Token> eqList = new ArrayList<Token>();
        String numTemp = "";
        for(int i = 0; i<rawArray.length; i++){
            if(Character.isDigit(rawArray[i])){
                if(rawArray[i]=='-'){
                    eqList.add(new Token(true, Integer.parseInt(numTemp)));
                    numTemp = "";
                    numTemp += rawArray[i];
                }
                else{
                    numTemp += rawArray[i];
                }
                
                if(i==rawArray.length-1){
                    eqList.add(new Token(true, Integer.parseInt(numTemp)));
                }
            }
            else{
                if(!numTemp.equals("")){
                    eqList.add(new Token(true, Integer.parseInt(numTemp)));
                    numTemp = "";
                }
                eqList.add(new Token(false, "" + rawArray[i]));
            }
        
        }
        return eqList;
    }
    
    

    public static void main(String[] args) {
        String demo = "12*4-30/5+8";
        char[] demoarr = demo.toCharArray();
        List<Token> demoList = tokenise(demoarr);
        Parser p = new Parser(demoList);
        Treenode tree = p.expr(); 
        System.out.printf( "%d", tree.evaluate());
    }
}