package serializer;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomSerDerExample {

	  public static void main (String[] args) {

	        ArrayList<SWEngineer> sweList = new ArrayList<SWEngineer>();
	        SWEngineer swe1 = new SWEngineer(1, "Mark", new String[]{"Java", "Python"});
	        SWEngineer swe2 = new SWEngineer(2, "John", new String[]{"Java", "C++", "Ruby"});
	        sweList.add(swe1);
	        sweList.add(swe2);

	        ObjectMapper mapper = new ObjectMapper();

	        String s = null;

	        try {
	            s = mapper.writeValueAsString(sweList);
	        }
	        catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }

	        System.out.println(s);
	    }
	
	
	
}
