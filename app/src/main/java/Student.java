import java.util.ArrayList;

/**
 * Created by HP on 1/10/2015.
 */
public class Student extends Member {
    //variables
    private ArrayList<String> classes = new ArrayList<>(0); //starts at 0 cause we have no classes

    //constructor
    public Student(String na, String em, String pass, String ph) {
        super(na, em, pass, ph);
    }

    public Student(String na, String em, String pass, String sk, String ph) {
        super(na, em, pass, sk, ph);
    }

    //methods
    public void retrieveClasses() {
        //THIS WILL BE CODED TO RETRIEVE CLASSES FROM PIAZZA
    }

    public void addClass(String newClass) {
        if (!classes.contains(newClass)) //make sure we don't clone classes
            classes.add(newClass);
    }

    public void removeClass(String dumpClass) {
        if (classes.contains(dumpClass))
            classes.remove(dumpClass);
    }

    public ArrayList<String> getClasses() {
        return classes;
    }
}
