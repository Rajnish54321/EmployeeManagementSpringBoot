/**
 * 
 */
package com.student.management.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rajnish Kumar Ranjan
 *
 */

@RestController
public class GitDemoController {

	
	@GetMapping("/getbranchname")
	public @ResponseBody Object getBranchName() {
		
		return "Master Branch";
	}
}
