class Person {
    private String surname = "";
    private String name = "";
    private String middle = "";

    public Person(String Surname, String Name, String Middle) {
        surname = Surname;
        name = Name;
        middle = Middle;
    }

    @Override
    public String toString() {
        if(name=="") name="None";
        else if (middle=="") middle = "None"; 
        return (surname+" "+name+" "+middle);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Person Mike = new Person("Prinstone","Mike", "Uva");
        System.out.print(Mike.toString()+"\n");
        Person Lisa = new Person("Aveme", "Lisa", "");
        System.out.print(Lisa.toString());
    }
}
