package excerciseQuestion;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class BusinessCalculationService {
	
//	@Autowired
	private DataService dataservice;

	
	public BusinessCalculationService(DataService dataservice) {
		super();
		this.dataservice = dataservice;
	}


	public int findMax() {
		return Arrays.stream(dataservice.retrieveData()).max().orElse(0);	
	}
	
	
}

