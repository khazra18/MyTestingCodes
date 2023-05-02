package DesignPatternPractice;

public class BuilderDesignPattern {

    public static void main(String[] args) {

        HouseBuilder houseBuilder = new BrickHouseBuilder();
        CivilEngineer civilEngineer = new CivilEngineer(houseBuilder);

        civilEngineer.constructHouse();
        House house = civilEngineer.getHouse();

        System.out.println(house);

    }

}

class CivilEngineer{

    private HouseBuilder houseBuilder;

    public CivilEngineer(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House getHouse(){
        return this.houseBuilder.getHouse();
    }

    public void constructHouse(){
        this.houseBuilder.buildBasement();
        this.houseBuilder.buildStructure();
        this.houseBuilder.buildRoof();
        this.houseBuilder.buildInterior();
    }
}

interface HousePlan{

    void setBasement(String basement);
    void setStructure(String structure);
    void setRoof(String roof);
    void setInterior(String interior);

}

class House implements HousePlan{

    String basement;
    String structure;
    String roof;
    String interior;


    @Override
    public void setBasement(String basement) {
        this.basement = basement;
    }

    @Override
    public void setStructure(String structure) {
        this.structure = structure;
    }

    @Override
    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public void setInterior(String interior) {
        this.interior = interior;
    }

    @Override
    public String toString() {
        return "House{" +
                "basement='" + basement + '\'' +
                ", structure='" + structure + '\'' +
                ", roof='" + roof + '\'' +
                ", interior='" + interior + '\'' +
                '}';
    }
}

interface HouseBuilder{

    void buildBasement();
    void buildStructure();
    void buildRoof();
    void buildInterior();
    House getHouse();

}

class IglooHouseBuilder implements HouseBuilder{

    private House house;

    public IglooHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildBasement() {
        house.setBasement("Ice bars");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Ice Carvings");
    }

    @Override
    public void buildRoof() {
        house.setRoof("igloo roof");
    }

    @Override
    public void buildInterior() {
        house.setInterior("igloo interior");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}

class BrickHouseBuilder implements HouseBuilder{

    private House house;

    public BrickHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildBasement() {
        house.setBasement("brick bar");
    }

    @Override
    public void buildStructure() {
        house.setStructure("brick Carvings");
    }

    @Override
    public void buildRoof() {
        house.setRoof("brick roof");
    }

    @Override
    public void buildInterior() {
        house.setInterior("brick interior");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}