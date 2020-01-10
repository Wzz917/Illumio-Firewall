package illumio;

import java.util.*;
import java.io.BufferedReader;    
import java.io.FileReader;  

public class Firewall {
	List<String> rules;     //Use a list of string to store all the rules
	//Constructor
	public Firewall() {
		System.out.println("test");
	}
 	public Firewall(String path) {
		rules = new ArrayList<>();
		BufferedReader reader;
		try {    
			reader = new BufferedReader(new FileReader(path));   //Read the csv file
            String line = null;    
            while((line=reader.readLine())!=null){               //Add data to the list
            	rules.add(line);   
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        }   
		System.out.println("Successfully Created a Firewall");
	}
	
	public boolean accept_packet(String direction, String protocol, int port, String ip_address) {    //Accept_packet function
		String[] nums = ip_address.split("\\.");
		System.out.println(direction);
		System.out.println(protocol);
		System.out.println(port);
		System.out.println(ip_address);
		int num1 = Integer.parseInt(nums[0]);
		//System.out.println("work");
		int num2 = Integer.parseInt(nums[1]);
		int num3 = Integer.parseInt(nums[2]);
		int num4 = Integer.parseInt(nums[3]);
		for (String rule:rules) {
			String[] items = rule.split(",");                 //For each rule, check whether it matches the current input
			//System.out.println(items[0]);
			//System.out.println(items[1]);
			//System.out.println(items[2]);
			//System.out.println(items[3]);
			if (!direction.equals(items[0])) {               //Direction
				continue;
			}
			if (!protocol.equals(items[1])) {                //Protocol
				continue;
			}
			if (items[2].contains("-")) {                    //Port
				String[] temp = items[2].split("-");
				int l1 = Integer.parseInt(temp[0]);
				int l2 = Integer.parseInt(temp[1]);
				if (port < l1 || port > l2) {
					continue;
				}
			}
			else {
				if (Integer.parseInt(items[2]) != port) {
					continue;
				}
			}
			if (items[3].contains("-")) {                    //IP address
				String[] tmp = items[3].split("-");
				String ip1 = tmp[0];
				String ip2 = tmp[1];
				String[] a = ip1.split("\\.");
				int a1 = Integer.parseInt(a[0]);
				int a2 = Integer.parseInt(a[1]);
				int a3 = Integer.parseInt(a[2]);
				int a4 = Integer.parseInt(a[3]);
				String[] b = ip2.split("\\.");
				int b1 = Integer.parseInt(b[0]);
				int b2 = Integer.parseInt(b[1]);
				int b3 = Integer.parseInt(b[2]);
				int b4 = Integer.parseInt(b[3]);
				if ((num1<a1 || num1>b1) || (num2<a2 || num2>b2) || (num3<a3 || num3>b3) || (num4<a4 || num4>b4)) {
					continue;
				}
			}
			else {
				String[] a = items[3].split("\\.");
				int a1 = Integer.parseInt(a[0]);
				int a2 = Integer.parseInt(a[1]);
				int a3 = Integer.parseInt(a[2]);
				int a4 = Integer.parseInt(a[3]);
				if (a1 != num1 || a2!=num2 || a3!=num3 || a4!=num4) {
					continue;
				}
			}
			return true;
		}
		return false;
	}

}


