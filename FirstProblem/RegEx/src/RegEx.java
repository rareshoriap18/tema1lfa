import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

	RegEx() {
	
	}
	
	public String getResult(String pattern, String line) {
		Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
       
        String results = "";
          
        boolean found = false;    
        while (m.find()) {    
      	  results+=m.group()+"\n";        
            found = true;    
        }    
        if(!found){    
            return ("No match found.");    
        }  
        else {
      	  return results;    
        }
	}
}
