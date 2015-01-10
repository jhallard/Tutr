import java.util.ArrayList;
/**
 * Created by HP on 1/10/2015.
 */
public class Tutor extends Member{
    ArrayList<String> qualified = new ArrayList<>(0); //will contain classes qualified to teach in
    private double hourlyRate; //cost per hour
    private double rawScore = 0; //the sum of all reviews for this tutor
    private double numberRatings = 0; //this is the number reviews this instructor has received
    private double averageRating;

    //constructor
    public Tutor(String na, String em, String pass, String ph){
        super(na, em, pass, ph);
    }
    public Tutor(String na, String em, String pass, String sk, String ph){
        super(na, em, pass, sk, ph);
    }

    public void addClass(String newClass) {
        if(!qualified.contains(newClass)) //make sure we don't clone classes
            qualified.add(newClass);
    }
    public void removeClass(String dumpClass){
        if(qualified.contains(dumpClass))
            qualified.remove(dumpClass);
    }
    public void setPrice(double price){
        hourlyRate = price;
    }
    public double getPrice(){
        return hourlyRate;
    }
    public void add_rating(double rating){
        //check to make sure the student has interacted with the tutor before calling this method!!!
        rawScore += rating;
        numberRatings++;
        averageRating = rawScore/numberRatings;
    }
    public String get_rating(){
        if(numberRatings == 0){
            return "No Ratings Yet!";
        }
        else {
            return ""+averageRating;
        }
    }
    public double get_numOfRatings(){
        return numberRatings;
    }
}
