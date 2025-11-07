import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Taxi> taxis;
    int bookId;
    public BookingSystem(int taxiCount){
        taxis=new ArrayList<>();
        bookId=1;
        for(int i=1;i<=taxiCount;i++) taxis.add(new Taxi(i));
    }
    private int findDistance(char pickPoint,char dropPoint){
        return Math.abs(pickPoint-dropPoint);
    }
    private int calculateCharges(char pickPoint,char dropPoint){
        int dist=Math.abs(pickPoint-dropPoint)*15;
        dist-=5;
        int charges=100;
        charges+=dist*10;
        return charges;
    }

    public Taxi findTaxi(char pickPoint,int pickTime){
        List<Taxi> freeTaxis=new ArrayList<>();
        for(Taxi i:taxis){
            if(i.isFree(pickPoint,pickTime)){
                freeTaxis.add(i);
            }
        }
        if(freeTaxis.isEmpty()) return null;
        int minDist=Integer.MAX_VALUE;
        for(Taxi i:freeTaxis){
            int distance=findDistance(pickPoint,i.getCurrentSpot());
            minDist=Math.min(distance,minDist);
        }
        List<Taxi> candidate=new ArrayList<>();
        for(Taxi i:freeTaxis){
            if(minDist==findDistance(pickPoint,i.getCurrentSpot())){
                candidate.add(i);
            }
        }
        int minEarnings=candidate.getFirst().getEarnings();
        Taxi t=candidate.getFirst();
        for(Taxi i:candidate){
            if(t.getEarnings()<minEarnings){
                minEarnings=t.getEarnings();
                t=i;
            }
        }
        return t;
    }
    public void booking(Customer c){
        char pickPoint=c.getPickPoint();
        char droppoint=c.getDropPoint();
        int pickTime=c.getPickUpTime();
        Taxi selectedTaxi=findTaxi(pickPoint,pickTime);
        if(selectedTaxi==null) {
            System.out.println("Booking is not available now");
            return;
        }
        int charge=calculateCharges(pickPoint,droppoint);
        Booking b=new Booking(bookId++,findDistance(pickPoint,droppoint)+pickTime,charge,c);
        selectedTaxi.assignBooking(b);
        selectedTaxi.setCurrentSpot(droppoint);
        selectedTaxi.setEarnings(charge+selectedTaxi.getEarnings());
        selectedTaxi.setFreeTime(findDistance(pickPoint,droppoint)+pickTime);
        System.out.println("Booked Taxi No: "+selectedTaxi.getId()+" Successfully");
    }
    void displayTaxi(){
        for(Taxi t:taxis){
            System.out.println("Taxi :"+t.getId()+" "+"Earnings: "+t.getEarnings()+" ");
        }
    }
}
