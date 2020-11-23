class Numbers {
    public String get_values(String number)  {
        String code = "", operator = "", next = "", last = "";
        char[] num =  number.toCharArray();
        String result="";
        if(num[0] ==  '+') {
            result+="+";
            code=String.valueOf(num[1]);
            for(int i=2;i<5;i++) operator+=String.valueOf(num[i]);
            for(int i=5;i<8;i++) next+=String.valueOf(num[i]);
            for(int i=8;i<11;i++) last+=String.valueOf(num[i]);
            result+=code+" ("+operator+") "+ next+" "+last;
        }
        else {
            if(num[0] == '8') code+="+7";
            else code=String.valueOf(num[0]);
            for(int i=1;i<4;i++) operator+=String.valueOf(num[i]);
            for(int i=4;i<7;i++) next+=String.valueOf(num[i]);
            for(int i=7;i<10;i++) last+=String.valueOf(num[i]);
            result+=code+" ("+operator+") "+ next+" "+last;
        }
        return result;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Numbers num = new Numbers();
        System.out.print(num.get_values("+79163748290")+"\n");
        System.out.print(num.get_values("89207230934")+"\n");
    }
}


