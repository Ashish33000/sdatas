package com.smartdatasolutions.test.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter( ) {
		// TODO
		return new MemberExporterImpl();
	}

	@Override
	protected MemberImporter getMemberImporter( ) {
		// TODO
		return new MemberImporterImpl();
	}

	@Override
	protected List< Member > getNonDuplicateMembers( List< Member > membersFromFile ) {
        Set<String> set=new HashSet<>();
        List<Member> nonduplicate=new ArrayList<>();
        for(Member m:membersFromFile) {
        	if(!set.contains(m.getId())) {
        		set.add(m.getId());
        		nonduplicate.add(m);
        	}
        }
		 return nonduplicate;
	}

	@Override
	protected Map< String, List< Member >> splitMembersByState( List< Member > validMembers ) {
		Map< String, List< Member >> res=new HashMap<>();
		for(Member m:validMembers) {
			if(res.containsKey(m.getState())) {
				res.get(m.getState()).add(m);
			}else {
				 List<Member> array = new ArrayList<>();
		            array.add(m);
		            res.put(m.getState(), array);
			}
			
		}
		// TODO
		return res;
	}

	public static void main( String[] args ) {
		//TODO
		Main main=new Main();
		try {
            File inputMemberFile = new File("C:\\Users\\hi\\Desktop\\java test file (3)\\SDS_Entry_Maven\\Members.txt");
            String outputFilePath = "C:\\Users\\hi\\Desktop\\java test file (3)\\SDS_Entry_Maven\\csvoutput";  
            String outputFileName = "outputFile.csv";

            main.convert(inputMemberFile, outputFilePath, outputFileName);
        } catch (Exception e) {
        	 System.err.println( e.getMessage());
          e.printStackTrace();
        }
	}

}
