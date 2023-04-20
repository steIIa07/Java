import java.util.ArrayList;

class ToyBox<T>
{
    private ArrayList<T> v = new ArrayList<T>(); 
    
    public void add(T t)
    {
	    v.add(t); 
    }

    public T get(int index)
    {
	    return v.get(index);
    }
    
    public int getSize()
    {
	    return v.size(); 
    }
}

public class ToyBoxTest
{
    public static void showToysinBox(ToyBox<? extends Toy> box)
    {
	    for (int i = 0; i < box.getSize(); i++)
	    {
            Toy toy = box.get(i);

            if(toy instanceof Car)
            {
                System.out.println("Car: " + toy.getName() + "/" + toy.getNumber());
            }
        else if(toy instanceof Bear)
            {
                System.out.println("Bear: " + toy.getName() + "/" + toy.getNumber());
            }
	    }
    }
    
    public static void main(String[] args)
    {
	    ToyBox<Car> carBox = new ToyBox<Car>();
        System.out.println("Creating a carBox...");
	
	    Car t1 = new Car("Yaris", 1500);
	    Car t2 = new Car("Corolla", 2500);
	    carBox.add(t1);
	    carBox.add(t2);
	    showToysinBox(carBox);

	    ToyBox<Bear> bearBox = new ToyBox<Bear>();
    	System.out.println("Creating a bearBox...");
	    Bear b1 = new Bear("Bear1", 1000);
	    Bear b2 = new Bear("Bear2", 2000);
	    bearBox.add(b1);
	    bearBox.add(b2);
        showToysinBox(bearBox);
       
       ToyBox<Toy> toyBox = new ToyBox<Toy>();
       System.out.println("Creating a toyBox..."); 
       
       Car t3 = new Car("Tacoma", 3300);
       Bear b3 = new Bear("Bear3", 1200);
       
       toyBox.add(t3);
       toyBox.add(b3);
       
       showToysinBox(toyBox);

       ToyBox<? extends Toy> sometoyBox = carBox;
       System.out.println("After assigning the carBox into the \"sometoyBox\"...");
       showToysinBox(sometoyBox);
    }
}

class Toy
{
    protected String name;
    protected int number;

    public Toy(String name, int number)
    {
	    this.name = name;
    	this.number = number;
    }

    public String getName()
    {
	    return name;
    }
    public int getNumber()
    {
	    return number;
    }
}

class Car extends Toy
{
    public Car(String model, int number)
    {
	    super(model, number);
    }
}

class Bear extends Toy
{    
    public Bear(String name, int number)
    {
	    super(name, number);
    }
}
