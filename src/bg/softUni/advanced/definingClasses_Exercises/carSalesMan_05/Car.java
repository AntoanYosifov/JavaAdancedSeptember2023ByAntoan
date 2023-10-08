package bg.softUni.advanced.definingClasses_Exercises.carSalesMan_05;

public class Car {
    // model, engine, weight, and color
    private String model;
    private String engineModel;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // "{CarModel}:
        //{EngineModel}:
        //Power: {EnginePower}
        //Displacement: {EngineDisplacement}
        //Efficiency: {EngineEfficiency}
        //Weight: {CarWeight}
        //Color: {CarColor}"
        sb.append(this.model).append(":").append(System.lineSeparator())
                .append(this.engine.getModel()).append(":").append(System.lineSeparator())
                .append("Power: ").append(this.engine.getPower()).append(System.lineSeparator());

        sb.append("Displacement: ");
        if (this.engine.getDisplacement() == 0) {
            sb.append("n/a");
        } else {
            sb.append(this.engine.getDisplacement());
        }
        sb.append(System.lineSeparator());
        sb.append("Efficiency: ");
        if(this.engine.getEfficiency() == null){
            sb.append("n/a");
        }else{
            sb.append(this.engine.getEfficiency());
        }
        sb.append(System.lineSeparator());
        sb.append("Weight: ");
        if(this.weight == 0){
            sb.append("n/a");
        }else{
            sb.append(this.weight);
        }
        sb.append(System.lineSeparator());
        sb.append("Color: ");
        if(this.color == null){
            sb.append("n/a");
        }else{
            sb.append(this.color);
        }

        return sb.toString();
    }
}
