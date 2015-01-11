package com.ucsc.teamtutor.tutr.Model; /**
 * Created by HP on 1/9/2015.
 */

import java.util.ArrayList;

public class Member {
    /*SEAN IF YOU READ THIS:
    I changed the code to more accurately reflect the way a class should be made.  Encapsulated
      variables, getters and setters.
    I deleted the password variable because we are storing that server side (security).
    I deleted the skype variable because we have not made a prompt in any part of the app for that
      and don't have time to input one.
    I commented out friends and interacted.  Friends is a difficult thing to make and something
      which we have not anything to do with (or the time to make anything to do with).
      Interactions, as I learned from HappyTraveler is something that's actually very difficult
      to measure, not to mention we also have not done anything with it.  However, I will keep it
      there just in case.
    When the user logs in, the server creates and sends back a student/tutor object.  It's when
      the user logs out that said object is destroyed.
    I'm sorry, it's just a time thing.
     */
    //variables
    private String name;
    private String email; //this will also be login name
    private String phone;
    private double longitude; //can't use long...
    private double latitude;
    private String bio = ""; //avoid null pointer exception
    /*
    private ArrayList<Member> friends = new ArrayList<>(0); //contains friends of this member
    private ArrayList<Interaction> interacted = new ArrayList<>(0);
    */
    //Constructor
    //2 since skype is optional during creation
    public Member() { //because android excepts a default constructor to be written out....
        name = "";
        email = "";
        phone = "";
    }

    public Member(String na, String em, String ph) {
        name = na;
        email = em;
        phone = ph;
    }

    //Methods
    //getters
    public String getName() {return name;}

    public String getPhone() {return phone;}

    public String getEmail() {return email;}

    public double getLongitude() {return longitude;}

    public double getLatitude() {return latitude;}

    public String getBio() {return bio;}
/*
    public ArrayList<Member> getFriends() {return friends;}
    //confusing: getInteracted to get the arraylist, or Sean's getInteractions for a specific
    //member
    public ArrayList<Interaction> getInteracted() {return interacted;}
*/

    //setters
    public void setName(String newName){
        name = newName;
    }
    public void setEmail(String newEmail) {
        email = newEmail;
    }

    public void setPhone(String newPhone) {
        phone = newPhone;
    }

    public void setBio(String newBio) {
        bio = newBio;
    }

    public void setImage() {
        //NEED TO IMPLEMENT THIS!@!@!@!@!@!
    }
/*
    public void addFriend(Member newFriend) {
        //should probably implement a request system!@!@!@!
        if (!friends.contains(newFriend)) { //prevents duplicate friending
            friends.add(newFriend);
        }
    }

    public void addInteraction(Member person) {
        //ok scary looking loop here to check if the person has interacted with the other person
        // yet look at com.ucsc.teamtutor.tutr.Model.Interaction.java to see how the
        // com.ucsc.teamtutor.tutr.Model.Interaction object works interacted is the name of the
        // array
        for (int i = 0; i < interacted.size(); i++) {
            if (interacted.get(i).person.equals(person)) {
                Interaction updated = interacted.get(i);
                updated.interactions++;
                interacted.set(i, updated);
                return; //exit the method once we have updated the number of interactions
            }
        }
        //if we didn't find the person in the loop we will add a new interaction between the two
        interacted.add(new Interaction(person));
    }

    public double getInteractions(Member person) {
        //similar to addInteraction, but instead we only retrieve the amount of interactions with said person
        for (int i = 0; i < interacted.size(); i++) {
            if (interacted.get(i).person.equals(person)) {
                return interacted.get(i).interactions;
            }
        }
        //if we didn't find the person in the loop then we have never seen them
        return 0;
    }
    */
}
