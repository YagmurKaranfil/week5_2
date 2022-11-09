package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.io.Devs.entities.concretes.Language;
import kodlama.io.Devs.entities.concretes.SubTechnology;
import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.business.requests.languages.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.languages.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.languages.FindByIdLanguageRequest;
import kodlama.io.Devs.business.requests.languages.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.languages.GetAllLanguagesResponse;
import kodlama.io.Devs.business.responses.languages.GetAllLanguagesWithSubTechnologyResponse;
import kodlama.io.Devs.business.responses.languages.GetByIdLanguagesResponse;
import kodlama.io.Devs.business.responses.subTechnologies.GetSubTechnologyResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;


@Service
public class LanguageManager implements LanguageService{

	private LanguageRepository languageRepository;
	private SubTechnologyRepository subTechnologyRepository;
	

	@Autowired
	public LanguageManager(LanguageRepository languageRepository,
			SubTechnologyRepository subTechnologyRepository) {
		super();
		this.languageRepository = languageRepository;
		this.subTechnologyRepository=subTechnologyRepository;
	}
	private boolean isLanguageEmpty(String language) {
		if (language == null || language.isEmpty() || language.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean isLanguageExisting(String language) {
		List<Language> languages = languageRepository.findAll();
		for (Language l : languages) {
			if (l.getName().equals(language)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> getAllLanguagesResponses = new ArrayList<GetAllLanguagesResponse>();

		for (Language language : languages) {
			GetAllLanguagesResponse languagesResponse = new GetAllLanguagesResponse();
			languagesResponse.setId(language.getId());
			languagesResponse.setName(language.getName());
			getAllLanguagesResponses.add(languagesResponse);
		}
		return getAllLanguagesResponses;
	}

	
	@Override
	public List<GetAllLanguagesWithSubTechnologyResponse> getAllLanguagesWithSubTechnologyResponses() {
		List<Language> languages = languageRepository.findAll();
		List<SubTechnology> technologies = subTechnologyRepository.findAll();
		List<GetAllLanguagesWithSubTechnologyResponse> languagesWithSubTechnologies = new ArrayList<GetAllLanguagesWithSubTechnologyResponse>();
		
		for (Language language : languages) {
			GetAllLanguagesWithSubTechnologyResponse response = new GetAllLanguagesWithSubTechnologyResponse();
			response.setId(language.getId());
			response.setName(language.getName());
			
			List<GetSubTechnologyResponse> t = new ArrayList<GetSubTechnologyResponse>();
			for (SubTechnology technology : technologies) {
				if(technology.getLanguage().getId()==language.getId()) {
					GetSubTechnologyResponse subTechnologyOnlyName = new GetSubTechnologyResponse();
					subTechnologyOnlyName.setName(technology.getName());
					t.add(subTechnologyOnlyName);
				}
					
					
			}
			response.setSubTechnologies(t);
			languagesWithSubTechnologies.add(response);
		}
		return languagesWithSubTechnologies;
	}


	@Override
	public GetByIdLanguagesResponse getById(FindByIdLanguageRequest findByLanguageRequest) {
			Language language = languageRepository.findById(findByLanguageRequest.getId()).get();
			GetByIdLanguagesResponse languageResponse = new GetByIdLanguagesResponse();
			languageResponse.setId(language.getId());
			languageResponse.setName(language.getName());
			return languageResponse;
	
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		Language language = new Language();
		language.setName(createLanguageRequest.getName());

		if (!isLanguageEmpty(createLanguageRequest.getName())
				&& !isLanguageExisting(createLanguageRequest.getName()))
			languageRepository.save(language);
		
	}

	@Override
	public void delete(DeleteLanguageRequest deletLanguageRequest) {
		Language language = languageRepository.findById(deletLanguageRequest.getId()).get();
		languageRepository.delete(language);
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		Language language = languageRepository.findById(updateLanguageRequest.getId()).get();

		if (!isLanguageEmpty(updateLanguageRequest.getNewName())
				&& !isLanguageExisting(updateLanguageRequest.getNewName()))
			language.setName(updateLanguageRequest.getNewName());
		languageRepository.save(language);
}
}
