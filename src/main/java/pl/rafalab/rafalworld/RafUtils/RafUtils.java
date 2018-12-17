package pl.rafalab.rafalworld.RafUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pl.rafalab.rafalworld.Model.User;

public class RafUtils {

    public static boolean checkEmailOrPassword(String pattern, String toMatch) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(toMatch);
        return matcher.matches();

    }
    
    public static List<User> readUserXmlFile(File file) {
    	List<User> userList = new ArrayList<>();
    	try {
    		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
    		Document doc = documentBuilder.parse(file);
    		doc.getDocumentElement().normalize();
    		NodeList nodeList = doc.getElementsByTagName("user");
    		for(int i=0; i<nodeList.getLength();i++){
    			Node n = nodeList.item(i);
    			if(n.getNodeType() == Node.ELEMENT_NODE){
    				Element e = (Element) n;
    				User u = new User();
    				u.setEmail(e.getElementsByTagName("email").item(0).getTextContent());
					u.setPassword(e.getElementsByTagName("password").item(0).getTextContent());
					u.setName(e.getElementsByTagName("name").item(0).getTextContent());
					u.setLastName(e.getElementsByTagName("lastname").item(0).getTextContent());
					u.setActive(Integer.valueOf(e.getElementsByTagName("active").item(0).getTextContent()));
					u.setNrRoli(Integer.valueOf(e.getElementsByTagName("nrroli").item(0).getTextContent()));
					userList.add(u);
    			}
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
     	return userList;
	}
    
    /**
	 * Code Generator
	 * @return String
	 */
    public static String randomCodeGenerator(){
    	String randomCode="";
    	String sign ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    	Random random = new Random();
    	for(int i=0;i<32;i++){
    		int liczba = random.nextInt(sign.length());
    		randomCode += sign.substring(liczba, liczba+1);
    	}
    	return randomCode;
    }
    


}
