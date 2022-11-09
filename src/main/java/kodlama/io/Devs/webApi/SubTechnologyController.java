package kodlama.io.Devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Devs.business.requests.subTechnology.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.DeleteSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.FindByIdSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.subTechnologies.GetAllSubTechnologyResponse;
import kodlama.io.Devs.business.responses.subTechnologies.GetByIdSubTechnologyResponse;


@RestController
@RequestMapping("/api/subTechnologies")
public class SubTechnologyController {
	
	SubTechnologyService subTechnologyService;
	
	@Autowired
	public SubTechnologyController(SubTechnologyService subTechnologyService) {
		super();
		this.subTechnologyService = subTechnologyService;
	}

	@PostMapping("/add")
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {
		subTechnologyService.add(createSubTechnologyRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllSubTechnologyResponse> getAll(){
		return subTechnologyService.getAll();
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
		subTechnologyService.delete(deleteSubTechnologyRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		subTechnologyService.update(updateSubTechnologyRequest);
	}
	
	@GetMapping("/getbyid")
	public GetByIdSubTechnologyResponse getById(FindByIdSubTechnologyRequest request) {
		return subTechnologyService.getById(request);
	}
}
