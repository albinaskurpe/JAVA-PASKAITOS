public class Item{
    private double price;
    private String name;

    public Item(){
        setPrice(0);
        setName("");
    }
    public Item(double p, String n){
        setPrice(p);
        setName(n);
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double p){
        if(p >= 0){
            price = p;
        }
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
}

class ItemTest{

    public static void main(String[] args){

        Item potato = new Item();
        System.out.println(potato.getPrice());
        potato.setPrice(-2.32);
        System.out.println(potato.getPrice());

        System.out.println(potato.getName());
        potato.setName("Bulves");
        System.out.println(potato.getName());

        potato.setPrice(potato.getPrice()+10);
        System.out.println(potato.getPrice());
    }
}