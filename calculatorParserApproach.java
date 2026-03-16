

public class calculatorParserApproach{

    static abstract class treenode{
         public abstract int evaluate();
    }
    static class multiply extends treenode{
        treenode left = null;
        treenode right = null;
        public multiply(treenode left, treenode right){
            this.left = left;
            this.right = right;
        }
        public int evaluate(){
            return this.left.evaluate() * this.right.evaluate();
        }
       
    }

    static class divide extends treenode{
        treenode left = null;
        treenode right = null;
        public divide(treenode left, treenode right){
            this.left = left;
            this.right = right;
        }
        public int evaluate(){
            return this.left.evaluate() / this.right.evaluate();
        }
       
    }

    static class add extends treenode{
        treenode left = null;
        treenode right = null;
        public add(treenode left, treenode right){
            this.left = left;
            this.right = right;
        }
        public int evaluate(){
            return this.left.evaluate() + this.right.evaluate();
        }
       
    }

    static class subtract extends treenode{
        treenode left = null;
        treenode right = null;
        public subtract(treenode left, treenode right){
            this.left = left;
            this.right = right;
        }
        public int evaluate(){
            return this.left.evaluate() - this.right.evaluate();
        }
       
    }

    static class Opperand extends treenode{
        int val;
        public Opperand(int value){
            this.val = value;
        }
        public int evaluate(){
            return this.val; 
        }
    }
    /*private List<treenode> numberMaker(char[] rawArray){
        List<treenode> eqList = new ArrayList<treenode>();
        String numTemp = "";
        for(int i = 0; i<rawArray.length; i++){
            if(i == rawArray.length && numTemp!=""){
                numTemp+=rawArray[i];
                inteeger t = new inteeger(Integer.parseInt(numTemp));
                eqList.add(t);
            
            if(Character.isDigit(rawArray[i])){
                numTemp+=rawArray[i];
            }
            }
            else if(numTemp!=""){
                inteeger t = new inteeger(Integer.parseInt(numTemp));
                eqList.add(t);
                /*if(rawArray[i] == 'X'){
                    multiply o = new multiply();
                    eqList.add(o);
                }
                

            }
        }

        return eqList;
    }
    */

    public static void main(String[] args) {

        Opperand o1 = new Opperand(1);
        Opperand o2 = new Opperand(1);
        multiply b1 = new multiply(o1, o2);
        System.out.print(b1.evaluate());
    }
}