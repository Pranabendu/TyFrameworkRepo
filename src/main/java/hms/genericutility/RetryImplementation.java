package hms.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this IRetryAnalyzer interface we are using when test script getting fail because of 
 * Internet issue,server issue, some instance internal issue.
 * that time it will reExecute the script till the given limit
 * @author PRANABENDU
 */

public class RetryImplementation implements IRetryAnalyzer
{

	public boolean retry(ITestResult result) {
		int count = 0;
		int trylimit = 1;
		while (count<trylimit) {
			count++;
			return true;
		}
		return false;
	}
	
}