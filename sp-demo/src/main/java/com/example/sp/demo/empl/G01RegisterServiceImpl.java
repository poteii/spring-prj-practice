package com.example.sp.demo.empl;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sp.demo.entity.AcStudent;
import com.example.sp.demo.entity.AcUser;
import com.example.sp.demo.form.G01RegisterForm;
import com.example.sp.demo.query.G01StudentQuery;
import com.example.sp.demo.query.G01UserQuery;
import com.example.sp.demo.service.G01RegisterService;

@Service
@Repository
@Transactional
public class G01RegisterServiceImpl implements G01RegisterService{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void createUser(G01RegisterForm registerForm) {
		int studentRef;
		try {
			studentRef = createStudent(registerForm);
			createUser(registerForm, studentRef);
		}finally {
			
		}
		
	}
	
	public void createUser(G01RegisterForm registerForm,int studentRef) {
		AcUser user;
		int userRef;
		try {
			user = new AcUser();
			userRef = G01UserQuery.genMaxUserRef(em);
			user.setUserRef(0);
			user.setUserId(registerForm.getAcUser().getUserId());
			user.setPassword(registerForm.getAcUser().getPassword());
			user.setUserRole("1");
			user.setStudentRef(studentRef);
			
			user.setCreateUser(userRef);
			user.setUpdateUser(userRef);
			user.setCreateDatetime(new Timestamp(System.currentTimeMillis()));
			user.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));
		}finally {
			
		}
		
	}
	
	private int createStudent(G01RegisterForm registerForm) {
		AcStudent acStudent;
		int studentRef;
		try {
			acStudent = new AcStudent();
			studentRef = G01StudentQuery.genMaxStudentRef(em);
			acStudent.setStudentRef(studentRef);
			acStudent.setEducationLevel(registerForm.getAcStudent().getEducationLevel());
			acStudent.setPersonalId(registerForm.getAcStudent().getPersonalId());
			acStudent.setStudentId(registerForm.getAcStudent().getStudentId());
			acStudent.setGender(registerForm.getAcStudent().getGender());
			acStudent.setBirthDate(registerForm.getAcStudent().getBirthDate());
			acStudent.setTitleCode(registerForm.getAcStudent().getTitleCode());
			acStudent.setFirstNameT(registerForm.getAcStudent().getFirstNameT());
			acStudent.setLastNameT(registerForm.getAcStudent().getLastNameT());
			acStudent.setFirstNameE(registerForm.getAcStudent().getFirstNameE());
			acStudent.setLastNameE(registerForm.getAcStudent().getLastNameE());
			acStudent.setSchoolRef(registerForm.getAcStudent().getSchoolRef());
			acStudent.setMajorRef(registerForm.getAcStudent().getMajorRef());
			acStudent.setNationality(registerForm.getAcStudent().getNationality());
			acStudent.setRace(registerForm.getAcStudent().getRace());
			acStudent.setReligion(registerForm.getAcStudent().getReligion());
			acStudent.setPhoneNo(registerForm.getAcStudent().getPhoneNo());
			acStudent.setEmail(registerForm.getAcStudent().getEmail());

			acStudent.setProfileName(registerForm.getAcStudent().getProfileName());
			acStudent.setProfileType(registerForm.getAcStudent().getProfileType());
			acStudent.setProfileImage(registerForm.getAcStudent().getProfileImage());

			acStudent.setCreateUser(studentRef);
			acStudent.setUpdateUser(studentRef);
			acStudent.setCreateDatetime(new Timestamp(System.currentTimeMillis()));
			acStudent.setUpdateDatetime(new Timestamp(System.currentTimeMillis()));

			em.persist(acStudent);
			return studentRef;
		} finally {

		}

	}
}
