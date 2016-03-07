import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JOptionPane;

public class Lab4 {
	static String directory="C:\\Users\\shehz\\Desktop\\New";
	
    public static void main(String[] args) throws IOException {     
    Collection<File> collection = new ArrayList<File>();   
   File dir=new File(directory);
    addCollection(dir, collection);  
        HashMap<String,String> hashMap = new HashMap();
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()==true){
            File file = (File) iterator.next();
            String Filename = file.getName();   //get the filename
            String Filepath = file.getPath();
            hashMap.put(Filename,Filepath);  //putting files to hashmap            
        } //end While
        while(true){
        String input = JOptionPane.showInputDialog("Enter the keyword you want to search in files \n Press / to exit: ");
        if(input.equals("/")){
            return;
        }
        String res= Crawling(hashMap, input);// searching string  
        JOptionPane.showMessageDialog(null,"The string exists in these files contents: \n\t"+res);
        }
        }
    public static void addCollection(File file, Collection<File> collection) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File fil : files) {
                addCollection(fil, collection);
            }
        }else{
            collection.add(file);
        }
    }
    
   /*
    * Method to search user's entered string in file Name and file content
    */
    public static String Crawling(HashMap hashMap, String input) throws IOException{           
            //to traverse the map
            Set set = hashMap.entrySet();
            Iterator iterator = set.iterator();
            String res="";
            String resFile="";
            while(iterator.hasNext()) {
                Entry entry = (Entry)iterator.next();
                
               String fileName=(String)entry.getKey();
               
                   if(fileName.contains(input)){
                  //  resFile+="\nFile Names have this string: \n\t"+ fileName+"\n";  
                	   resFile+=fileName+"\n";
                   }
           
               String val = (String)entry.getValue();
                File file = new File(val); 
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = br.readLine()) != null) {
                        if(line.contains(input)){
                         res+=val+"\n";  
                        }
                }
            } 
			return res+resFile;   
    }       
    }
    


