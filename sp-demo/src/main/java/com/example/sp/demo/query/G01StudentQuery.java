package com.example.sp.demo.query;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class G01StudentQuery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static int genMaxStudentRef(EntityManager em) {
		Query query;
		String selectClause;
		String fromClause;
		try {
			selectClause = " select coalesce(max(student_ref+1),1)";
			fromClause = " from ac_student";
			
			query = em.createNativeQuery(selectClause+fromClause);
			
			
			return new Integer(query.getSingleResult().toString());
		}finally {
			
		}
	}
}
