package kodlama.io.Devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.languages.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.languages.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.languages.FindByIdLanguageRequest;
import kodlama.io.Devs.business.requests.languages.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.languages.GetAllLanguagesResponse;
import kodlama.io.Devs.business.responses.languages.GetAllLanguagesWithSubTechnologyResponse;
import kodlama.io.Devs.business.responses.languages.GetByIdLanguagesResponse;

@RestController
@RequestMapping("/api/programmingLanguages")
public class LanguageController {

	private LanguageService languageService;

	@Autowired
	public LanguageController (LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll(){
		return languageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageRequest languageRequest) {
		languageService.add(languageRequest);
	}
	
	@GetMapping("/getbyid")
	public GetByIdLanguagesResponse getById(FindByIdLanguageRequest byIdProgrammingLanguageRequest) {
		return languageService.getById(byIdProgrammingLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		languageService.delete(deleteLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateLanguageRequest updateLanguage) {
		languageService.update(updateLanguage);
	}
	
	@GetMapping("/getAllWithSubTechnologies")
	public List<GetAllLanguagesWithSubTechnologyResponse> getAllWithSubTechnologies(){
		return languageService.getAllLanguagesWithSubTechnologyResponses();
	}
}
