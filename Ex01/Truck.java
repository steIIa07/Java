public class Truck extends Vehicle
{
    private int numberOfSeats;
    private int power;
    private boolean airConditionOn = false;
    
    public Truck(String modelName, String company, String owner, String engineType, double tankSize, double fuelConsumption, int numberOfSeats, int power) 
    {
	    super(modelName, company, owner, engineType, tankSize, fuelConsumption);
	    setNumberOfSeat(numberOfSeats);
	    setPower(power);
    }

    private void setNumberOfSeat(int numberOfSeats)
    {
        this.numberOfSeats = numberOfSeats;
    }

    private void setPower(int power)
    {
        this.power = power;
    }

    public double costFor100Km(PetroleumPrice priceInfo)
    {
        double cost = 100 / fuelConsumption * priceInfo.getdieselPrice();
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
	    fuelConsumption /= 0.75;
    } 

    public String toString()
    {
        String description = "ModelName: " + modelName + ", Company: " + company + ", Owner: " + owner + ", EngineType: " + engineType + ", TankSize: " + tankSize + ", FuelConsumption: " + fuelConsumption + ", NumberOfSeat: " + numberOfSeats + ", HorsePower: " + power;
        return description;
    }
}
