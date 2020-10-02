interface Store {
    int status = 0;
    public void placeOrder(String pizza);
    public Pizza createPizza(String pizza);
    
}

class IndianStore implements Store {
    Pizza name = null;
    public void placeOrder(String pizzaName) {
        //some BL
        return;
    }

    public Pizza createPizza(String pizza) {
        if (pizza.equals("CheesePizza"))
            return new IndianCheesePizza(); 
        
        return null;
    }
} 

class USStore implements Store {
    Pizza name = null;
    public void placeOrder(String pizzaName) {
        //some BL
        return;
    }


    public Pizza createPizza(String pizza) {
        if (pizza.equals("CheesePizza"))
            return new USCheesePizza(); 
        return null;
    }
} 

abstract class Pizza {
    public void cutPizza() {
        System.out.println("Your pizza is cutting into triangular");
    }
    public void bakePizza() {
        System.out.println("Your pizza is being baked");
    }
    public void packPizza() {
        System.out.println("Your pizza is packed");
    }
    public abstract void recepie();
} 

class IndianCheesePizza extends Pizza {
    public  void recepie() {
        //regional recepie
        return;
    }

}

class USCheesePizza extends Pizza {
    public  void recepie() {
        //regional recepie
        return;
    }
    
}

public class PizzaRegionalStore {
    public static void main (String [] args) {
        IndianStore is = new IndianStore();
        Pizza pi = is.createPizza("CheesePizza");
        pi.recepie();
        pi.bakePizza();
        pi.cutPizza();
        pi.packPizza();

    }
}

