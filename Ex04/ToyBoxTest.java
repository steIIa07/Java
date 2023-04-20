import java.util.ArrayList;

/**
 * ToyBox Example.
 */


class ToyBox<T>
{
    private ArrayList<T> v = new ArrayList<T>(); // Complete here to assign ArrayList object         
    
    public void add(T t)
    {
	    v.add(t); // Complete add method with proper argument and method body                     
    }

    public T get(int index)
    {
	    return v.get(index);
    }
    
    public int getSize()
    {
	    return v.size(); // Complete getSize method with proper argument and method body
    }
}

public class ToyBoxTest
{
    public static void showToysinBox(ToyBox<? extends Toy> box)
    {
	// Complete showAnimalsinToyBox method with proper argument and method body                     
	for (int i = 0; i < box.getSize(); i++)
	    {
		Toy toy = box.get(i);
		
		if(toy instanceof Car)
		    {
			Car car = (Car) toy;
			System.out.println("Car: " + car.getName() + ", " + car.getNumber() + "kg");
		    }
		else if(toy instanceof Bear)
		    {
			Bear bear = (Bear) toy;
			System.out.println("Bear: " + bear.getName() + ", " + bear.getNumber() + "kg");
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
       
       
       /* It is OK till now */
       
       // Next, create Box<Toy>
       
     // Create a "toyBox" with proper sentence
       ToyBox<Toy> toyBox = new ToyBox<Toy>();
       System.out.println("Creating a toyBox..."); 
       
       Car t3 = new Car("Tacoma", 3300);
       Bear b3 = new Bear("Bear3", 1200);
       
       toyBox.add(t3);
       toyBox.add(b3);
       
       showToysinBox(toyBox);
       /* It is still OK till now */
       
       // How about the next? Is it subtype?
       ToyBox<? extends Toy> sometoyBox = carBox;
       System.out.println("After assigning the carBox into the \"sometoyBox\"...");
       showToysinBox(sometoyBox);
    }
}

class Toy
{
    private String name;
    private int number;

    protected Toy(String name, int w)
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

// Car class and Bear class to extend the Toy class
class Car extends Toy
{
    public Car(String name, int number)
    {
	super(name, number);
    }
    /*
    private String model;
    private int weight;
    
    public Car(String model, int weight)
    {
	this.model = model;
	this.weight = weight;
    }
    
    public String getModel()
    {
	return model;
    }
    public int getWeight()
    {
	return weight;
    }
    */
}

class Bear extends Toy
{
    public Bear(String name, int number)
    {
	super(name, number);
    }
	
    /*
    private String name;
    private int weight;
    
    public Bear(String name, int weight)
    {
	this.name = name;
        this.weight = weight;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getWeight()
    {
        return weight;
    }
    */
}
