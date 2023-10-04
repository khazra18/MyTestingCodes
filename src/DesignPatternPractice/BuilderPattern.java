package DesignPatternPractice;

public class BuilderPattern {

    public static void main(String[] args) {

        Car car = new Car.CarBuilder()
                .setCarType("SUV")
                .setBrandName("Tata")
                .setModelName("Punch")
                .setAutomatic(false)
                .setHaveProjectorHeadLamp(true)
                .setHaveSunRoof(true).build();

        System.out.println(car);


    }
}

class Car{

    String modelName;
    String brandName;
    String carType;

    boolean isAutomatic;
    boolean haveSunRoof;
    boolean haveProjectorHeadLamp;

    public Car(CarBuilder carBuilder) {
        this.modelName = carBuilder.modelName;
        this.brandName = carBuilder.brandName;
        this.carType = carBuilder.carType;
        this.isAutomatic = carBuilder.isAutomatic;
        this.haveSunRoof = carBuilder.haveSunRoof;
        this.haveProjectorHeadLamp = carBuilder.haveProjectorHeadLamp;
    }

    public String getModelName() {
        return modelName;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getCarType() {
        return carType;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public boolean isHaveSunRoof() {
        return haveSunRoof;
    }

    public boolean isHaveProjectorHeadLamp() {
        return haveProjectorHeadLamp;
    }

    @Override
    public String toString() {
        return "Car{" +
                "modelName='" + modelName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", carType='" + carType + '\'' +
                ", isAutomatic=" + isAutomatic +
                ", haveSunRoof=" + haveSunRoof +
                ", haveProjectorHeadLamp=" + haveProjectorHeadLamp +
                '}';
    }

    static class CarBuilder{
        private String modelName;
        private String brandName;
        private String carType;

        private boolean isAutomatic;
        private boolean haveSunRoof;
        private boolean haveProjectorHeadLamp;

        public CarBuilder setModelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public CarBuilder setBrandName(String brandName) {
            this.brandName = brandName;
            return this;
        }

        public CarBuilder setCarType(String carType) {
            this.carType = carType;
            return this;
        }

        public CarBuilder setAutomatic(boolean automatic) {
            this.isAutomatic = automatic;
            return this;
        }

        public CarBuilder setHaveSunRoof(boolean haveSunRoof) {
            this.haveSunRoof = haveSunRoof;
            return this;
        }

        public CarBuilder setHaveProjectorHeadLamp(boolean haveProjectorHeadLamp) {
            this.haveProjectorHeadLamp = haveProjectorHeadLamp;
            return this;
        }

        Car build(){
            return new Car(this);
        }
    }


}