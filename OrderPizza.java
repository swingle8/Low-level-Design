abstract class Pizza {
   
    int currSize = 0;
    public void cut () {
        System.out.println("cutting your pizza");
    }
    public void pack() {
        System.out.println("packing your pizza");
    }

    public abstract boolean canConfirm();
    public abstract void bake();
    public abstract void decreaseQuantity();
    public void setSize (String val) {
        if (val.equals("small"))
            currSize = 1;
        else if (val.equals("medium"))
            currSize = 2;
        else if (val.equals("large"))
            currSize = 3;
    }
}

class VegPizza extends Pizza {
    private static int quantity = 1;
    public boolean canConfirm () {
        if (quantity != 0)
            return true;
        return false;
    }

    public void bake () {
        
        System.out.println("Baking your Vegetable pizza");
    }

    public void decreaseQuantity() {
        System.out.println("Decreasing quantity");
        quantity--;
    }
}

class ChickenPizza extends Pizza {
    private static int quantity = 1;
    public boolean canConfirm () {
        if (quantity != 0)
            return true;
        return false;
    }

    public void bake () {
        
        System.out.println("Baking your chicken pizza");
    }

    public void decreaseQuantity() {
        System.out.println("Decreasing quantity");
        quantity--;
    }
}

class Pizzafactory {
    public Pizza getPizza (String type) {
        if (type.equals("VegPizza"))
            return new VegPizza();
        else if (type.equals("ChickenPizza"))
            return new ChickenPizza();
        return null;
    } 
}

class Unavailable extends Exception {
    String message = "";
    Unavailable (String error) {
        super(error);
    }
}

class OrderNow {
    Pizza p;
    OrderNow (Pizza val) {
        this.p = val;
    }

    public void orderMyPizza () throws Unavailable {
        if (! p.canConfirm()) {
            throw new Unavailable("Pizza is not available");
        }
        p.decreaseQuantity();
        p.bake();
        p.cut();
        p.pack();
        System.out.println("Your Pizza is ready!");
    }
}


public class OrderPizza {
    public static void main(String [] args) {
        Pizzafactory p = new Pizzafactory();
        Pizza currPizza = p.getPizza("VegPizza");
        Pizza currPizza1 = p.getPizza("VegPizza");
        try {
            OrderNow order = new OrderNow(currPizza);
            order.orderMyPizza();
            order = new OrderNow(currPizza1);
            order.orderMyPizza();
            
        }
        catch (Exception E) {
            System.out.println(E.getMessage());
        }
    }
}