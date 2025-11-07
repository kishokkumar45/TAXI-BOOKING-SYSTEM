import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private int id;
    private int earnings;
    private int freeTime;
    private char currentSpot;
    private List<Booking> bookingList;

    Taxi(int id){
        this.id=id;
        this.earnings=0;
        this.freeTime=0;
        this.currentSpot='A';
        this.bookingList=new ArrayList<>();
    }
    public boolean isFree(char pickPoint,int pickTime){
        int travelTime=Math.abs(pickPoint-currentSpot);
        return freeTime+travelTime<=pickTime;
    }
    public void assignBooking(Booking booking){
        bookingList.add(booking);
    }

    public char getCurrentSpot() {
        return currentSpot;
    }

    public void setCurrentSpot(char currentSpot) {
        this.currentSpot = currentSpot;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }

    public int getId() {
        return id;
    }

    public List<Booking> getList() {
        return bookingList;
    }
}