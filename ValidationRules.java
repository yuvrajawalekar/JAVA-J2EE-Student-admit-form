package utils;

import java.time.LocalDate;

import org.hibernate.HibernateException;

public class ValidationRules {
	public static void checkCgpa(Double m) {
		if(m<7.0)
			throw new HibernateException("CGPA must be greater than 7");
		
	}
	
	public static void checkDob(LocalDate d) {
		if(d.getYear()<1995)
			throw new HibernateException("Year must be from 1995");
		
	}
}
