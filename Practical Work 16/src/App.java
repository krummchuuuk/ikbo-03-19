import java.util.Arrays;
import java.util.HashMap;

interface Item {
    double getCost();
    String getName();
    String getAbout();
}

final class Drink implements Item{
    private final double cost;
    private final String name, about;

    public Drink(String Name, String About) {
        name = Name;
        about = About;
        cost = 0;
    }
    public Drink(String Name, String About, double Cost) {
        cost = Cost;
        name = Name;
        about = About;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }
    @Override
    public String toString() {
        return (name+" "+about+" "+cost+"\n");
    }
}

final class Dish implements Item{
    private final double cost;
    private final String name, about;

    public Dish(String Name, String About) throws Exception{
        name = Name;
        about = About;
        cost = 0;
        throw new Exception("java.lang.IllegalArgumentException ");
    }
    public Dish(String Name, String About, double Cost) {
        cost = Cost;
        name = Name;
        about = About;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }
    @Override
    public String toString() {
        return (name+" "+about+" "+cost+"\n");
    }
}

interface Order {
    boolean add(Dish dish);
    boolean add(Drink dish);
    boolean remove(String Name);
    void removeAll(String Name);
    int dish_Quantity();
    int dish_Quantity(String Name);
    Dish[] getDishes();
    double costTotal();
    String[] dishesNames();
    Dish[] sortedDishesByCostDesc();
}

class Node {
    public Drink drink;
    public Dish dish;
    public Node prev, next;

    public Node(Node Prev, Dish Dish, Node Next) {
        prev = Prev;
        dish =Dish;
        next  = Next;
    }
    
    public Node(Node Prev, Drink Drink, Node Next) {
        prev = Prev;
        drink =Drink;
        next  = Next;
    }

    public Node(Drink Drink) {
        this (null, Drink, null);
    }

    public Node(Dish Dish) {
        this(null, Dish, null);
    }
}

class RestorantOrder implements Order {
    int count_dishes = 0, count_drinks = 0;
    Dish[] dishes = new Dish[20];
    Drink[] drinks = new Drink[20];

    public boolean add(Dish dish) {
        if (dishes.length==count_dishes) {
            dishes = Arrays.copyOf(dishes, count_dishes+1);
        }
        try {
            dishes[count_dishes] = dish;
            count_dishes++;
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean add(Drink drink) {
        if (drinks.length==count_drinks) {
            drinks = Arrays.copyOf(drinks, count_drinks+1);
        }
        try {
            drinks[count_drinks] = drink;
            count_drinks++;
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean remove(String name) {
        for (int i=0;i<dishes.length;i++) {
            if(dishes[i].getName() == name) {
                if(i==count_dishes) drinks[i] = null;
                else {
                    drinks[i] = drinks[count_dishes];
                    drinks[count_dishes] = null;
                }
                drinks = Arrays.copyOf(drinks, count_dishes--);
                count_dishes--;
                return true;
            }
        }
        for (int i=0;i<drinks.length;i++) {
            if(drinks[i].getName() == name) {
                if(i==count_drinks) drinks[i] = null;
                else {
                    drinks[i] = drinks[count_drinks];
                    drinks[count_drinks] = null;
                }
                drinks = Arrays.copyOf(drinks, count_drinks--);
                count_drinks--;
                return true;
            }
        }
        return false;
    }

    public void removeAll(String name) {
        boolean not_end = true;
        while(not_end) {
            if(!remove(name)) not_end = false;
        }
    }

    public int Quantity() {
        return (count_dishes+count_drinks);
    }

    public int dish_Quantity(String name) {
        int counter = 0;
        for(int i=0;i<count_dishes;i++) {
            if (dishes[i].getName() == name) counter++;
        }
        return counter;
    }

    public int dish_Quantity() {
        return count_dishes;
    }

    public int drink_Quantity(String name) {
        int counter = 0;
        for(int i=0;i<count_drinks;i++) {
            if (drinks[i].getName() == name) counter++;
        }
        return counter;
    }

    public int drink_Quantity() {
        return count_drinks;
    }

    public Dish[] getDishes() {
        return dishes;
    }

    public Drink[] getDrinks() {
        return drinks;
    }

    public String[] dishesNames() {
        String[] names =new String[count_dishes];
        for (int i=0;i<count_dishes;i++) {
            names[i] = dishes[i].getName();
        }
        return names;
    }

    public String[] drinksNames() {
        String[] names =new String[count_drinks];
        for (int i=0;i<count_drinks;i++) {
            names[i] = drinks[i].getName();
        }
        return names;
    }

    public Dish[] sortedDishesByCostDesc() {
        Dish[] sorted = dishes;
        for(int i = sorted.length-1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (sorted[j] != null && sorted[j + 1] != null) {
                    if (dishes[j].getCost() > sorted[j + 1].getCost()) {
                        Dish temp = sorted[j];
                        sorted[j] = sorted[j + 1];
                        sorted[j + 1] = temp;
                    }
                }
            }
        }
        return sorted;
    }

    public Drink[] sortedDrinksByCostDesc() {
        Drink[] sorted = drinks;
        for(int i = sorted.length-1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (sorted[j] != null && sorted[j + 1] != null) {
                    if (drinks[j].getCost() > sorted[j + 1].getCost()) {
                        Drink temp = sorted[j];
                        sorted[j] = sorted[j + 1];
                        sorted[j + 1] = temp;
                    }
                }
            }
        }
        return sorted;
    }

    public double costTotal(){
        double cost = 0;
        for (Dish dish : dishes) {
            if (dish != null)
                cost += dish.getCost();
        }
        for (Drink drink : drinks) {
            if (drink != null)
                cost += drink.getCost();
        }
        return cost;
    }
}

class InternetOrder implements Order {
    int count_dishes = 0, count_drinks = 0;
    Dish[] dishes = new Dish[20];
    Drink[] drinks = new Drink[20];
    private Node head;
    private int count;

    public InternetOrder() {
        head = null;
    }

    public InternetOrder (RestorantOrder order) {
        Dish[] dishes = order.getDishes();
        Drink[] drinks = order.getDrinks();
        for (Dish i: dishes) {
            add(i);
        }
        for (Drink i: drinks) {
            add(i);
        }
    }

    public boolean isEmpty() {
        if (count == 0) return true;
        else return false;
    }

    public int size() {
        return count;
    }

    public boolean add(Drink drink) {
        try {
            if (isEmpty()) head = new Node(drink);
            else {
                Node temp = head;
                head = new Node(null, drink, temp);
                head.next.prev = head;
            }
            count++;
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public boolean add(Dish dish) {
        try {
            if (isEmpty()) head = new Node(dish);
            else {
                Node temp = head;
                head = new Node(null, dish, temp);
                head.next.prev = head;
            }
            count++;
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    
    public boolean remove(String name) {
        if (isEmpty()) return false;
        if (head.dish !=null && head.dish.getName() == name) {
                head = head.next;
                return true;
        }
        if (head.drink != null && head.drink.getName() == name) {
                head = head.next;
                return true;
        }
        Node that = head;
        boolean not_end = true;
        while (not_end) {
            that = that.next;
            if (that == null) not_end = false;
            else if (that.dish != null && that.dish.getName() == name) not_end = false;
            else if (that.drink != null && that.drink.getName() == name) not_end = false;
        }
        if (that == null) return false;
        if (that.next != null) that.next.prev = that.prev;
        that.prev.next = that.next;
        count--;
        return true;
    }

    public void removeAll(String name) {
        boolean not_end = true;
        while(not_end) {
            if (!remove(name)) not_end = false;
        }
    }

    public int getSize() {
        return count;
    }

    public RestorantOrder getOrder() {
        RestorantOrder order = new RestorantOrder();
        if (!isEmpty()) {
            Node temp = head;
            while (temp != null) {
                if (temp.dish != null) order.add(temp.dish);
                else if (temp.drink != null) order.add(temp.drink);
                temp = temp.next;
            }
        }
        return order;
    }

    public double costTotal() {
        double cost = 0;
        if (!isEmpty()) {
            Node temp = head;
            while (temp !=null) {
                if (temp.dish != null) cost += temp.dish.getCost();
                else if (temp.drink != null) cost += temp.drink.getCost();
                temp = temp.next;
            }
        }
        return cost;
    }

    public String[] dishesNames() {
        String[] names =new String[count_dishes];
        for (int i=0;i<count_dishes;i++) {
            names[i] = dishes[i].getName();
        }
        return names;
    }

    public int getOrderQuantity (String name) {
        int quantity = 0;
        if (!isEmpty()) {
            Node temp  = head;
            while (temp != null) {
                if (temp.dish != null && temp.dish.getName() == name) quantity ++;
                else if (temp.drink != null && temp.drink.getName() == name) quantity++;
                temp = temp.next;
            }
        }
        return quantity;
    }

    public int dish_Quantity(String name) {
        int counter = 0;
        for(int i=0;i<count_dishes;i++) {
            if (dishes[i].getName() == name) counter++;
        }
        return counter;
    }

    public int dish_Quantity() {
        return count_dishes;
    }

    public Drink[] getDrinks() {
        Drink[] drinks = new Drink[5];
        boolean not_end = true;
        if (!isEmpty()) {
            Node temp = head;
            while (temp != null) {
                if (temp.drink !=null) {
                    for (int i=0;i<5;i++) {
                        if (drinks[i] !=null && temp.drink.getName() == drinks[i].getName()) not_end = false; 
                    }
                    if (not_end) {
                        for (int i=0;i<5;i++) {
                            if (drinks[i] == null) {
                                drinks[i] =temp.drink;
                                break;
                            }
                        }
                    }
                    not_end = true;
                }
                temp = temp.next;
            }
        }
        return drinks;
    }

    public Dish[] getDishes() {
        Dish[] dishes = new Dish[5];
        boolean not_end = true;
        if (!isEmpty()) {
            Node temp = head;
            while (temp != null) {
                if (temp.dish !=null) {
                    for (int i=0;i<5;i++) {
                        if (dishes[i] !=null && temp.dish.getName() == dishes[i].getName()) not_end = false; 
                    }
                    if (not_end) {
                        for (int i=0;i<5;i++) {
                            if (dishes[i] == null) {
                                dishes[i] =temp.dish;
                                break;
                            }
                        }
                    }
                    not_end = true;
                }
                temp = temp.next;
            }
        }
        return dishes;
    }

    public Dish[] sortedDishesByCostDesc() {
        Dish[] sorted = dishes;
        for(int i = sorted.length-1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (sorted[j] != null && sorted[j + 1] != null) {
                    if (dishes[j].getCost() > sorted[j + 1].getCost()) {
                        Dish temp = sorted[j];
                        sorted[j] = sorted[j + 1];
                        sorted[j + 1] = temp;
                    }
                }
            }
        }
        return sorted;
    }
}

class OrderManager{
    private HashMap<Integer, RestorantOrder> rest_order = new HashMap<>();
    private HashMap<String, InternetOrder> online_order = new HashMap<>();

    public boolean add(int table_num, RestorantOrder order) throws Exception {
        if (rest_order.containsKey(table_num)) throw new Exception("OrderAlreadyAddedException");
        else {
            rest_order.put(table_num, order);
            return true;
        }
    }

    public boolean add(String address, InternetOrder order) {
        try {
            online_order.put(address, order);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    public void removeResorantOrder (int table_num) {
        rest_order.remove(table_num);
    }

    public void removeInternetOrder (String address) {
        online_order.remove(address);
    }

    public RestorantOrder getRestorantOrder(int table_num) {
        return rest_order.get(table_num);
    } 

    public InternetOrder getInternetOrder(String address) {
        return online_order.get(address);
    }

    public double RestorantOrdersCostSummery() {
        double cost = 0;
        for(int key:rest_order.keySet()) {
            cost += rest_order.get(key).costTotal();
        }
        return cost;
    }

    public double InternetOrdersCostSummery() {
        double cost = 0;
        for(String key:online_order.keySet()) {
            cost += online_order.get(key).costTotal();
        }
        return cost;
    }

    public void addDish_RestaurantOrder(int table_num, Dish dish) {
        rest_order.get(table_num).add(dish);
    }

    public void addDrink_RestaurantOrder(int table_num, Drink drink) {
        rest_order.get(table_num).add(drink);
    }

    public void addDish_InternetOrder(String address, Dish dish) {
        online_order.get(address).add(dish);
    }

    public void addDrink_InternetOrder(String address, Drink drink) {
        online_order.get(address).add(drink);
    }

    public String getAllOrders(){
        String str = "";
        if (!rest_order.isEmpty()) {
            str += "Заказы в ресторане:\n";
            for (int key : rest_order.keySet()) {
                str += "Столик №" + key + " заказал на сумму : " + rest_order.get(key).costTotal() + "\n";
            }
        }
        if (!online_order.isEmpty()) {
            str += "Онлайн-заказы:\n";
            for (String key : online_order.keySet()) {
                str += "По адресу -> " + key + " <- заказали на сумму : " + online_order.get(key).costTotal() + "\n";
            }
        }
        return str;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        OrderManager manager = new OrderManager();
        RestorantOrder rest_1 = new RestorantOrder();
        RestorantOrder rest_2 = new RestorantOrder();
        InternetOrder online_1 = new InternetOrder();
        InternetOrder online_2 = new InternetOrder();

        Dish dish_1 = new Dish("Сливочный крем-суп", "400 мл", 300);
        Dish dish_2 = new Dish("Цезарь с лососем", "400 г", 500);
        Dish dish_3 = new Dish("Альфредо", "400 г", 380);
        Dish dish_4 = new Dish("Борщ", "400 мл", 300);
        Drink drink_1 = new Drink ("Молочный Улун", "500 мл", 280);
        Drink drink_2 = new Drink ("Клюквенный морс", "500 мл", 300);
        Drink drink_3 = new Drink ("Ванильный раф", "400 мл", 300);
        Drink drink_4 = new Drink ("Воды", "500 мл", 150);

        rest_1.add(dish_1);
        rest_1.add(dish_2);
        rest_1.add(drink_1);
        rest_2.add(dish_3);
        rest_2.add(dish_4);
        rest_2.add(drink_4);
        online_1.add(dish_3);
        online_1.add(drink_3);
        online_2.add(drink_2);
        online_2.add(drink_2);

        manager.add(3, rest_1);
        manager.add(5, rest_2);
        manager.add("Москва, ул.Адмирала Ушакова 16/3, 190", online_1);
        manager.add("Москва, ул.Крылатская 46/2, 12", online_2);

        System.out.print(manager.getAllOrders()+"\nОнлайн-заказ №2 отменили. Теперь наш список заказов выглядит так:\n\n");
        manager.removeInternetOrder("Москва, ул.Крылатская 46/2, 12");
        System.out.print(manager.getAllOrders());
    }
}