class Opperand extends Treenode{
        int val;
        public Opperand(int value){
            this.val = value;
        }
        public int evaluate(){
            return this.val; 
        }
    }