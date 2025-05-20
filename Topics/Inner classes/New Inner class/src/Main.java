class Vehicle {

    private String name;

    // create constructor
    Vehicle(){}
    Vehicle(String name){
        this.name = name;
    }

    class Engine {

        void start() {
            System.out.println("RRRrrrrrrr....");
        }

    }

    // create class Body
    class Body{
        private String color;

        Body(){}
        Body(String color){
            this.color = color;
        }

        public void printColor(){
            System.out.printf("Vehicle %s has %s body.\n", Vehicle.this.name, this.color);
        }
    }
}

// this code should work
class EnjoyVehicle {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Dixi");
        Vehicle.Body body = vehicle.new Body("red");
        body.printColor();
    }
}