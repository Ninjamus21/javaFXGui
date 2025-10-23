package Opgave6;

public class Car {
    private String mærke;
    private String model;
    private Boolean elektrisk;
    private int price;

    public Car(String mærke, String model, boolean elektrisk, int price){
        this.mærke = mærke;
        this.model = model;
        this.elektrisk = elektrisk;
        this.price = price;
    }

    @Override
    public String toString(){
        return ( mærke + " " + model + " electric " + elektrisk.toString() + " price is: " + price + "dk" );

    }
}
