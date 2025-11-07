public class Customer {
    private int customerId;
    private char pickPoint;
    private char dropPoint;
    private int pickUpTime;
    Customer(int custId,char pick,char drop,int ptime){
        customerId=custId;
        pickPoint=pick;
        dropPoint=drop;
        pickUpTime=ptime;
    }
    public int getCustomerId() {
        return customerId;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public char getPickPoint() {
        return pickPoint;
    }

    public int getPickUpTime() {
        return pickUpTime;
    }

}
