public static int aibjck(String str){
       int acount = 0;
       int bcount = 0;
       int ccount = 0;
       for(int i=0;i<str.length();i++){
           char ch = str.charAt(i);
           if(ch == 'a') acount = acount + (1 + acount); // not include + include(prev + self)
           else if(ch=='b') bcount = bcount + (acount + bcount);
           else if(ch=='c') ccount = ccount + (bcount + ccount);
       }
       return ccount;
   }
