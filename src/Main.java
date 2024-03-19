class Vehicle {
    //Attributes
    protected String make, model;
    protected int year;
    protected double rental_price;
    //Constructor
    public Vehicle(String make, String model, int year, double rental_price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rental_price = rental_price;
    }
    //Getters and Setters Attributes
    public String getMake()
    {
        return make;
    }
    public void setMake()
    {
        this.make = make;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRentalPrice() {
        return rental_price;
    }
    //Calculate Rental Cost
    public double CalculateRentalCost(int days)
    {
        return rental_price * days;
    }
}
class Car extends Vehicle
{
    private int numSeats;
    public Car(String make, String model, int year, double rental_price, int numSeats)
    {
        super(make,model,year,rental_price);
        this.numSeats = numSeats;
    }
    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
    //Override method
    @Override
    public double CalculateRentalCost(int days) {
        if (numSeats > 5)
        {
            return super.CalculateRentalCost(days) * 1.5;
        }
        else
        {
            return super.CalculateRentalCost(days);
        }
    }
}
class Truck extends Vehicle
{
    private double payloadCapacity;
    public Truck(String make, String model, int year, double rental_price, double payloadCapacity)
    {
        super(make,model,year,rental_price);
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public double CalculateRentalCost(int days) {
        if (payloadCapacity > 5)
        {
            return super.CalculateRentalCost(days) * 1.8;
        }
        else
        {
            return super.CalculateRentalCost(days);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating Instances of car and truck
        Car car1 = new Car("Volkswagen", "polo", 2020, 500.0, 4);
        Truck truck1 = new Truck("Opel", "Movano", 2018, 800.0, 3.2);

        int rentalDays = 7;

        // Printing Costs
        System.out.println("Price to rent the car is R" + car1.CalculateRentalCost(rentalDays));
        System.out.println("Price to rent the truck is R" + truck1.CalculateRentalCost(rentalDays));

    }
}