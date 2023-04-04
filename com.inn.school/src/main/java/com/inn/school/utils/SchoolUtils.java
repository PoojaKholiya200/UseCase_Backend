//generic methods which can be used in any service central classes
package com.inn.school.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SchoolUtils {
	private SchoolUtils() {
	}
		public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus) {
			return new ResponseEntity<String>( "{\"message\":\""+responseMessage+"\"}",httpStatus);
	}
}
