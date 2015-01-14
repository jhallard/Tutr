package com.tutr.libtutr.Model; /**
 * Created by HP on 1/9/2015.
 */

public class Member {
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

    public boolean setLongitude(double l) {longitude = l; return true;}

    public boolean setLatitude(double l) {latitude = l; return true;}

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
