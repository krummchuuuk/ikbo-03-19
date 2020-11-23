class Shirt {
    private String[] values = new String[4];

    public String toString (String new_shirt) {
        values = new_shirt.split(",");
        return ("Number: "+values[0]+" Model: "+values[1]+" Color: "+values[2]+" Size: "+values[3]+"\n");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        String[] shirts = new String[11];
        shirts[0] = "S001,Black Polo Shirt,Black,XL"; 
        shirts[1] = "S002,Black Polo Shirt,Black,L"; 
        shirts[2] = "S003,Blue Polo Shirt,Blue,XL"; 
        shirts[3] = "S004,Blue Polo Shirt,Blue,M"; 
        shirts[4] = "S005,Tan Polo Shirt,Tan,XL"; 
        shirts[5] = "S006,Black T-Shirt,Black,XL"; 
        shirts[6] = "S007,White T-Shirt,White,XL"; 
        shirts[7] = "S008,White T-Shirt,White,L"; 
        shirts[8] = "S009,Green T-Shirt,Green,S"; 
        shirts[9] = "S010,Orange T-Shirt,Orange,S"; 
        shirts[10] = "S011,Maroon Polo Shirt,Maroon,S";

        Shirt shirt = new Shirt();
        Shirt[] arr_shirt = new Shirt[11];
        for(int i=0;i<11;i++) {
            arr_shirt[i] = shirt;
            System.out.print(shirt.toString(shirts[i]));
        }
    }
}
