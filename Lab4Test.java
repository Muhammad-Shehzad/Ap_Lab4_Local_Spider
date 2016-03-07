import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;

public class Lab4Test {
	String Filepath = "C:\\Users\\shehz\\Desktop\\New\\testFile.txt";
	@Test
	public void test() throws IOException {
		Lab4 lab4=new Lab4();
		 HashMap<String,String> hashMap = new HashMap();
         String Filename = "testFile.txt";   //get the filename
         
         hashMap.put(Filename,Filepath);  //putting files to hashmap 
		String result=lab4.Crawling(hashMap, "gh");// searching string
		System.out.println(result);
		assertEquals("", result);
	//	fail("Not yet implemented");
	}

}
