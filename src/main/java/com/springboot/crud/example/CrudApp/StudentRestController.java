package com.springboot.crud.example.CrudApp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.example.CrudAppException.StudentNotFoundException;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class StudentRestController {

	private static Map<String, Object> students = new HashMap<String, Object>();

	static {
		Student stud1 = new Student();
		stud1.setId(1);
		stud1.setName("Prateek");
		stud1.setPassportNumber("PrateekPassport");
		students.put("1", stud1);

		Student stud2 = new Student();
		stud2.setId(2);
		stud2.setName("Priya");
		stud2.setPassportNumber("PriyaPassport");
		students.put("2", stud2);

	}

	@RequestMapping(value = "/students")
	public ResponseEntity<Object> getStudents() {
		return new ResponseEntity<>(students.values(), HttpStatus.OK);
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		students.put(String.valueOf(student.getId()), student);
		return new ResponseEntity<Object>("Student created successfully!", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStudent(@PathVariable("id") String id)
	{
		students.remove(id);
		return new ResponseEntity<Object>("Student deleted successfully!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateStudent(@PathVariable("id") String id, @RequestBody Student student)
	{
		if(!students.containsKey(id))
		{
			throw new StudentNotFoundException();
		}
		students.remove(id);
		student.setId(Integer.parseInt(id));
		students.put(id, student);
		return new ResponseEntity<Object>("Student updated successfully!",HttpStatus.OK);
	}
	
}
