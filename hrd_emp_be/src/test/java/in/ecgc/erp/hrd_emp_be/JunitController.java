package in.ecgc.erp.hrd_emp_be;

import static in.ecgc.erp.hrd_emp_be.JsonConverter.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import in.ecgc.erp.hrd_emp_be.model.Employee;

public class JunitController extends HrdEmpBeApplicationTests {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	//@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void viewAllEmployees() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/allEmployeeData").contentType(MediaType.APPLICATION_STREAM_JSON))
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Test	
	public void addEmployee() throws Exception {
		Employee emp = new Employee();
		emp.setEmpId(6);
		emp.setFirstName("Sonali");
		emp.setLastName("K");
		emp.setDob("1999-9-9");
		emp.setDoj("1995-8-8");
		System.out.println(asJsonString(emp));
		
		mockMvc.perform(MockMvcRequestBuilders.post("/saveEmployeeData")
				.contentType(MediaType.APPLICATION_STREAM_JSON)
				.content(asJsonString(emp)))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
	}
	
	@Test
	public void deleteEmployee() throws Exception {
		Employee emp = new Employee();
		emp.setEmpId(5);
		mockMvc.perform(MockMvcRequestBuilders.get("/deleteEmployee/5")
				.contentType(MediaType.APPLICATION_STREAM_JSON)
				.content(asJsonString(emp)))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
	}

	
}