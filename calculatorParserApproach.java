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
            //System.out.println(""+ this.left.evaluate() +  "*" + this.right.evaluate());
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
            //System.out.println(""+ this.left.evaluate() +  "/" + this.right.evaluate());
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
            //System.out.println(""+ this.left.evaluate() +  "+" + this.right.evaluate());
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
            //System.out.println(""+ this.left.evaluate() +  "-" + this.right.evaluate());
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
    static class token{
        boolean num;
        int intValue;
        String strValue;
        
        public token(boolean isNum, int  intVal){
            this.num = isNum;
            this.intValue = intVal;
        }
        public token(boolean isNum, String strVal){
            this.num = isNum;
            this.strValue = strVal;
  
        }
    }
    static class parser{
        List<token> toks;
        token nextToken;
        int startPoint;
        public parser(List<token> toks){
            this.toks = toks;
            this.nextToken = toks.get(1); 
            this.startPoint = 0; 
        }
        public void scn(){
            this.startPoint=this.startPoint+1;
            if(this.startPoint<this.toks.size())
                this.nextToken = this.toks.get(this.startPoint);
            else
                this.nextToken = null;
        }
        public Treenode expr(){
            Treenode a = term();
            while (true) { 
                if(nextToken!=null){
                    if(nextToken.strValue.equals("+")){
                        scn();
                        Treenode b = term();
                        a = new Add(a,b);
                    }
                    else if(nextToken.strValue.equals("-")){
                        scn();
                        Treenode b = term();
                        a = new Subtract(a,b);
                    }
                    else{
                        return a;
                    }
                }
                else{
                    return a;
                }
            }
        }
        public Treenode term(){
            Treenode a = factor();
            while (true) { 
                if(nextToken!=null){
                    if(nextToken.strValue.equals("*")){
                        scn();
                        Treenode b = factor();
                        a = new Multiply(a,b);
                    }
                    else if(nextToken.strValue.equals("/")){
                        scn();
                        Treenode b = factor();
                        a = new Divide(a,b);
                    }
                    else{
                        return a;
                    }
                }
                else{
                    return a;
                }
                
            }
        }
        public Treenode factor(){
            if(toks.get(startPoint).num && startPoint<this.toks.size()){
                int sp = this.startPoint;
                scn();
                return new Opperand(toks.get(sp).intValue);
            }
            return new Opperand(-100000);
                
        }
    }


    
    static List<token> lexer(char[] rawArray){
        List<token> eqList = new ArrayList<token>();
        String numTemp = "";
        for(int i = 0; i<rawArray.length; i++){
            if(Character.isDigit(rawArray[i])){
                if(rawArray[i]=='-'){
                    eqList.add(new token(true, Integer.parseInt(numTemp)));
                    numTemp = "";
                    numTemp += rawArray[i];
                }
                else{
                    numTemp += rawArray[i];
                }
                
                if(i==rawArray.length-1){
                    eqList.add(new token(true, Integer.parseInt(numTemp)));
                }
            }
            else{
                if(!numTemp.equals("")){
                    eqList.add(new token(true, Integer.parseInt(numTemp)));
                    numTemp = "";
                }
                eqList.add(new token(false, "" + rawArray[i]));
            }
        
        }
        return eqList;
    }
    
    

    public static void main(String[] args) {
        String demo = "12*4-30/5+8";
        char[] demoarr = demo.toCharArray();
        List<token> demoList = lexer(demoarr);
        parser p = new parser(demoList);
        Treenode tree = p.expr(); 
        
        System.out.printf( "%d", tree.evaluate());
    }
}