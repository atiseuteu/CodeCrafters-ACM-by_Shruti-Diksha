package social_media;
import java.util.*;
public class Community {
	  private String name;
	    private Set<String> interests;

	    public Community(String name, Set<String> interests) {
	        this.name = name;
	        this.interests = interests;
	    }

	    public String getName() {
	        return name;
	    }

	    public Set<String> getInterests() {
	        return interests;
	    }
}
