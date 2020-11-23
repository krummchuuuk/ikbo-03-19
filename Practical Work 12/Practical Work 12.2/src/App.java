import java.util.HashMap;
import java.util.StringTokenizer;

class Address {
    private String[] values;

    public String first(String address) {
        values = address.split(",");
        for(int i =0;i<7;i++) {
            values[i] = values[i].strip();
        }
        return toString();
    }

    public String second(String address) {
        StringTokenizer result = new StringTokenizer(address, ",");
        for(int i=0;i<7;i++) {
            values[i] = result.nextToken();
            values[i] = values[i].strip();
        }
        return toString();
    }

    public String toString() {
        String result="";
        for(int i=0;i<7;i++) {
            result+=values[i]+" ";
        }
        result = result.strip();
        return result;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        String adr1 = "Россия,  Москва, Москва, Адмирала Ушакова, 23, 4, 80";
        String adr2 = "Россия,  Новосибирск, Новосибирск, Шмидта, 6, 3, 22";
        Address address = new Address();
        System.out.print("Result with split:\n"+address.first(adr1));
        System.out.print("\nResult with StringTokenizer:\n"+address.second(adr2));
    }
}
