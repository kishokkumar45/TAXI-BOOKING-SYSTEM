
public class Main {

    public static void main(String[] args) {
        Customer c1 = new Customer (1,  'A', 'B',  9);
        Customer c2 = new Customer (2, 'B', 'D',9);
        Customer c3 = new Customer (3,  'B', 'C',  12);
        BookingSystem book=new BookingSystem(4);
        book.booking(c1);
        book.booking(c2);
        book.booking(c3);
        book.displayTaxi();
    }
}