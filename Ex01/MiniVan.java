public class MiniVan extends Vehicle
{
    private int numberOfSeats;
    private boolean hasAutoDoor;
    private boolean airConditionOn = false;
    
    public MiniVan(String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption, int numberOfSeats, boolean hasAutoDoor) 
    {
    	super(modelName, company, owner, engineType, tankSize, fuelConsumption);
	    setNumberOfSeat(numberOfSeats);
	    setHasAutoDoor(hasAutoDoor);
    }
    
    private void setNumberOfSeat(int numberOfSeats) 
    {
        this.numberOfSeats = numberOfSeats;
    }

    private void setHasAutoDoor(boolean hasAutoDoor) 
    {
        this.hasAutoDoor = hasAutoDoor;
    }
    
    public double costFor100Km(PetroleumPrice priceInfo)
    {
        double price;
        if(this.engineType == "Diesel")
        {
            price = priceInfo.getdieselPrice();
        }
        else
        {
            price = priceInfo.getGasolineCost();
        }
        
        double cost = 100 / fuelConsumption * price;
        return cost;
    }

    public void setAirConditionON()
    {
	    if(!airConditionOn)
	        airConditionOn = true;
	    fuelConsumption *= 0.75;
    }

    public void setAirConditionOFF()
    {
	    if(airConditionOn)
	        airConditionOn = false;
	    fuelConsumption *= 0.75;
    } 

    public String toString()
    {
        String description = "ModelName: " + modelName + ", Company: " + company + ", Owner: " + owner + ", EngineType: " + engineType + ", TankSize: " + tankSize + ", FuelConsumption: " + fuelConsumption + ", NumberOfSeat: " + numberOfSeats + ", HasAutoDoor: " + hasAutoDoor;
        return description;
    }
}
