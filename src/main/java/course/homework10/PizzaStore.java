package course.homework10;

import java.util.ArrayList;

public class PizzaStore {
    private SimplePIzzaFactory fact = new SimplePIzzaFactory();

    public Pizza orderPizza(String type) {
        return fact.createPizza(type);
    }
}

class SimplePIzzaFactory {
    public Pizza createPizza(String type) {
        Pizza p;
        switch (type) {
            case "Veggie": {
                p = new VeggiePizza();
                break;
            }
            case "Cheese": {
                p = new CheesePizza();
                break;
            }
            default: {
                p = new Pizza();
                break;
            }
        }

        p.prepare();
        p.bake();
        p.cut();
        p.box();

        return p;
    }
}

class Pizza {
    protected String name;
    protected String dough;
    protected String souce;
    protected ArrayList<String> toppings;
    protected String progress;

    public Pizza() {
        name = "Pizza";
        dough = "Normal";
        souce = "Spice";
        toppings = new ArrayList<>();
    }

    public void prepare() {
        progress = "Raw";
    }

    public void bake() {
        progress = "Cooked";
    }

    public void cut() {
        progress = "Cut";
    }

    public void box() {
        progress = "Boxed";
    }

    public String getName() {
        return name;
    }
}

class VeggiePizza extends Pizza {
    public VeggiePizza() {
        super();
        name = "VeggiePizza";
    }
}

class CheesePizza extends Pizza {
    public CheesePizza() {
        super();
        name = "CheesePizza";
    }
}
