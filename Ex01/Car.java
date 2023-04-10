public class Car extends Vehicle
{
    private int numberOfSeats;
    private boolean airConditionOn = false;
    
    public Car(String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption, int numberOfSeats) 
    {
	    super(modelName, company, owner, engineType, tankSize, fuelConsumption);
	    setNumberOfSeat(numberOfSeats);
    }

    private void setNumberOfSeat(int numberOfSeats) 
    {
        this.numberOfSeats = numberOfSeats;
    }

    public double costFor100Km(PetroleumPrice priceInfo)
    {
        double cost = 100 / fuelConsumption * priceInfo.getGasolineCost();
    	return cost;
    }

    public void setAirConditionON()
    {
	    if(!airConditionOn)
	        airConditionOn = true;
	    fuelConsumption *= 0.85;
    }

    public void setAirConditionOFF()
    {
	    if(airConditionOn)
	        airConditionOn = false;
	    fuelConsumption /= 0.85;
    } 

    public String toString()
    {
        String description = "ModelName: " + modelName + ", Company: " + company + ", Owner: " + owner + ", EngineType: " + engineType + ", TankSize: " + tankSize + ", FuelConsumption: " + fuelConsumption + ", NumberOfSeat: " + numberOfSeats;
        return description;
    }
}
