
import com.sun.source.tree.Tree;
import java.util.ArrayList;
import java.util.List;
public class calculatorParserApproach{

    static abstract class Treenode{
         public abstract int evaluate();
    }
    static class Multiply extends Treenode{
        Treenode left = null;
        Treenode right = null;
        public Multiply(Treenode left, Treenode right){
            this.left = left;
            this.right = right;
        }
        public int evaluate(){
            return this.left.evaluate() * this.right.evaluate();
        }
       
    }

    static class Divide extends Treenode{
        Treenode left = null;
        Treenode right = null;
        public Divide(Treenode left, Treenode right){
            this.left = left;
            this.right = right;
        }
        public int evaluate(){
            return this.left.evaluate() / this.right.evaluate();
        }
       
    }

    static class Add extends Treenode{
        Treenode left = null;
        Treenode right = null;
        public Add(Treenode left, Treenode right){
            this.left = left;
            this.right = right;
        }
        public int evaluate(){
            return this.left.evaluate() + this.right.evaluate();
        }
       
    }

    static class Subtract extends Treenode{
        Treenode left = null;
        Treenode right = null;
        public Subtract(Treenode left, Treenode right){
            this.left = left;
            this.right = right;
        }
        public int evaluate(){
            return this.left.evaluate() - this.right.evaluate();
        }
       
    }

    static class Opperand extends Treenode{
        int val;
        public Opperand(int value){
            this.val = value;
        }
        public int evaluate(){
            return this.val; 
        }
    }

    static Treenode parser(List<Object> lexed){
        //methodstub
        return new Opperand(0);
    }
    
    static List<Object> lexer(char[] rawArray){
        List<Object> eqList = new ArrayList<Object>();
        String numTemp = "";
        for(int i = 0; i<rawArray.length; i++){
            if(Character.isDigit(rawArray[i])){
                if(rawArray[i]=='-'){
                    eqList.add(Integer.parseInt(numTemp));
                    numTemp = "";
                    numTemp += rawArray[i];
                }
                else{
                    numTemp += rawArray[i];
                }
                
                if(i==rawArray.length-1){
                    eqList.add(Integer.parseInt(numTemp));
                }
            }
            else{
                if(numTemp != ""){
                    eqList.add(Integer.parseInt(numTemp));
                    numTemp = "";
                }
                eqList.add(rawArray[i]);
            }
        
        }
        return eqList;
    }
    
    

    public static void main(String[] args) {
        String demo = "4X4+4/2";
        char[] demoarr = demo.toCharArray();
        List<Object> demoList = lexer(demoarr);
        Treenode tree = parser(demoList);
        System.out.printf( "%d", tree.evaluate());
    }
}