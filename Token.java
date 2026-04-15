class Token{
        boolean num;
        int intValue;
        String strValue;
        
        public Token(boolean isNum, int  intVal){
            this.num = isNum;
            this.intValue = intVal;
        }
        public Token(boolean isNum, String strVal){
            this.num = isNum;
            this.strValue = strVal;
  
        }
    }