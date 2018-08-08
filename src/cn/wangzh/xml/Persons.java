package cn.wangzh.xml;

import java.util.List;

public class Persons {
	 private List<Person> listPerson ;   
	    
	  
	   public Persons() {}   
	    
	  
	   public Persons(List<Person> listPerson) {   
	      super ();   
	      this . listPerson = listPerson;   
	   }   
	   public List<Person> getListPerson() {   
	      return listPerson ;   
	   }   
	    
	  
	   public void setListPerson(List<Person> listPerson) {   
	      this . listPerson = listPerson;   
	   }   
	/*@Override   
	   public String toString() {   
	        
	      StringBuffer sb= new StringBuffer();   
	      for (Iterator it= listPerson .iterator();it.hasNext();){   
	         Person p=(Person)it.next();   
	         sb.append(it.toString());   
	      }   
	      return "persons{" +   
	            "listPerson=" + sb.toString() +   
	            "}\n" ;   
	    
	  
	   }   */

}
