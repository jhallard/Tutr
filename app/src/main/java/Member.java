/**
 * Created by HP on 1/9/2015.
*/
import java.util.ArrayList;
public class Member {
    //variables
    public String name;
    public String email; //this will also be login name
    public String phone;
    public String skype;
    private String password;
    public double[] GPS; //NOT IMPLEMENTED YET!!!!!
    public String bio = ""; //avoid null pointer exception
    private ArrayList<Member> friends = new ArrayList<>(0); //contains friends of this member
    private ArrayList<Interaction> interacted = new ArrayList<>(0);

    //Constructor
    //2 since skype is optional during creation
    public Member(){ //because android excepts a default constructor to be written out....
        name = "";
        email = "";
        password = "";
        phone = "";
        skype = ""; //we don't like null pointer exceptions do we?
    }
    public Member(String na, String em, String pass, String ph){
        name = na;
        email = em;
        password = pass;
        phone = ph;
        skype = ""; //we don't like null pointer exceptions do we?
    }
    public Member(String na, String em, String pass, String sk, String ph){
        name = na;
        email = em;
        password = pass;
        skype = sk;
        phone = ph;
    }

    //Methods
    public void changeEmail(String newEmail){
        email = newEmail;
    }
    public void changePassword(String newPassword){
        password = newPassword;
    }
    public void changeSkype(String newSkype){
        skype = newSkype;
    }
    public void changePhone(String newPhone){
        phone = newPhone;
    }
    public void changeBio(String newBio){
        bio = newBio;
    }
    public void changeImage(){
        //NEED TO IMPLEMENT THIS!@!@!@!@!@!
    }

    public void addFriend(Member newFriend){
        //should probably implement a request system!@!@!@!
        if(!friends.contains(newFriend)) { //prevents duplicate friending
            friends.add(newFriend);
        }
    }
    public void addInteraction(Member person){
        //ok scary looking loop here to check if the person has interacted with the other person yet
        //look at Interaction.java to see how the Interaction object works
        //interacted is the name of the array
        for(int i = 0; i<interacted.size(); i++){
            if(interacted.get(i).person.equals(person)){
                Interaction updated = interacted.get(i);
                updated.interactions++;
                interacted.set(i, updated);
                return; //exit the method once we have updated the number of interactions
            }
        }
        //if we didn't find the person in the loop we will add a new interaction between the two
        interacted.add(new Interaction(person));
    }
    public double getInteractions(Member person){
        //similar to addInteraction, but instead we only retrieve the amount of interactions with said person
        for(int i = 0; i<interacted.size(); i++){
            if(interacted.get(i).person.equals(person)){
                return interacted.get(i).interactions;
            }
        }
        //if we didn't find the person in the loop then we have never seen them
        return 0;
    }
}
