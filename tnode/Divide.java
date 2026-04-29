package tnode;

public class Divide extends Treenode{
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