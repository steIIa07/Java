public abstract class Vehicle
{
    protected String modelName;
    protected String company;
    protected String owner;
    protected String engineType;
    protected double tankSize;
    protected double fuelConsumption;
    
    public Vehicle(String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption)
    {
	    this.modelName = modelName;
	    this.company = company;
	    this.owner = owner;
	    this.engineType = engineType;
	    this.tankSize = tankSize;
	    this.fuelConsumption = fuelConsumption;
    }

    abstract public double costFor100Km(PetroleumPrice priceInfo);
    abstract public void setAirConditionON();
    abstract public void setAirConditionOFF();

    public double movableDistance()
    {
      	double distance = tankSize * fuelConsumption;
	    return distance;
    }

    public String toString()
    {
        String description = "ModelName: " + modelName + ", Company: " + company + ", Owner: " + owner + ", EngineType: " + engineType + ", TankSize: " + tankSize + ", FuelConsumption: " + fuelConsumption;
        return description;
    }
}
