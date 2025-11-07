import java.util.List;

public class Booking {
    private int id;
    private Customer customer;
    private int dropTime;
    private int charges;

    public Booking(int id,int dropTime,int charges,Customer cust){
        this.id=id;
        this.customer=cust;
        this.charges=charges;
        this.dropTime=dropTime;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
