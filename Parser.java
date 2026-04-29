import java.util.List;
import tnode.Add;
import tnode.Divide;
import tnode.Multiply;
import tnode.Opperand;
import tnode.Subtract;
import tnode.Treenode;
class Parser{
        List<Token> toks;
        Token nextToken;
        int startPoint;
        public Parser(List<Token> toks){
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