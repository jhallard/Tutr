import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import java.util.Arrays;
import java.util.List;

package com.ucsc.teamtutor.tutrappengine;
package com.ucsc.teamtutor.tutr;
/**
 * Created by Alec Reid on 1/10/2015.
 */
public class DataBaseEngine {
    private List<String> subjectList;
    DataBaseEngine()
    {
        String[] subjectArray = {"Anthropology","Art","Art History",
                "Astronomy","Astrophysics","Biology",
                "Ecology","Chemistry","Biochemistry",
                "Chinese","Classical Studies","Community Studies",
                "Critical Race and Ethnic Studies","Digital Art and New Media","Earth and Planetary Sciences",
                "Asian Studies","Economics","Education",
                "Engineering","Applied Mathematics","Statistics",
                "Computer Science","Environmental Studies","Feminist Studies",
                "Film and Digital Media","French","German",
                "Greek","Hebrew","History",
                "History of Art and Visual Culture","Humanities","Italian",
                "Japanese","Jewish Studies","Languages and Applied Linguistics",
                "Language Studies","Latin","Latin American and Latino Studies",
                "Legal Studies","Linguistics","Literature",
                "Marine Sciences","Mathematics","Microbiology",
                "Music","Ocean Sciences","Philosophy",
                "Physical Education","Physics","Politics",
                "Portuguese","Psychology","Queer and Sexuality Studies",
                "Religious Studies","Russian","Communication",
                "Sociology","Spanish","Sustainability Studies",
                "Theater Arts","Yiddish"};
        Arrays.sort(subjectArray);

        List<String> subjectList = Arrays.asList(subjectArray);
    }
    List<String> GetSubjects()
    {

        return subjectList;
    }
    boolean CheckUserNameAvailability(String username)
    {
        return true;
    }

    boolean VerifyStudentLogin(Student student)
    {

        return true;
    }

    boolean CreateStudent()
    {

        return true;
    }
    boolean CreateStudent(Student student)
    {
        return true;
    }


}
