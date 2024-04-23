package com.smartdatasolutions.test.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

public class MemberImporterImpl implements MemberImporter {

	@Override
	public List< Member > importMembers( File inputFile ) throws Exception {

		/*
		 * Implement the missing logic
		 */
		List< Member > res=new ArrayList<>();
		FileReader fr=new FileReader(inputFile);
		BufferedReader br=new BufferedReader(fr);

		try {
			String line = br.readLine();	
			while ( line != null ) {
			
				    String id = line.substring(0, 12).trim();
	                String lastName = line.substring(12, 37).trim();
	                String firstName = line.substring(37, 62).trim();
	                String address = line.substring(62, 92).trim();
	                String city = line.substring(92, 112).trim();
	                String state = line.substring(112, 116).trim();
	                String zip = line.substring(116).trim();
	               System.out.println(id+" "+lastName+firstName+address+city+state+zip);
					Member member = new Member();
		            member.setId(id);
		            member.setLastName(lastName);
		            member.setFirstName(firstName);
		            member.setAddress(address);
		            member.setCity(city);
		            member.setState(state);
		            member.setZip(zip);
		            res.add(member);
			
         
              
			}
			
		}catch (IOException e) {
            System.err.println( e.getMessage());
            e.printStackTrace();
        }finally {
        	fr.close();
        	br.close();
        }

		return res;
	}
	
	

}
