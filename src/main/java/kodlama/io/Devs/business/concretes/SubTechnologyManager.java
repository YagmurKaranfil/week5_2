package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Devs.business.requests.subTechnology.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.DeleteSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.FindByIdSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.subTechnologies.GetAllSubTechnologyResponse;
import kodlama.io.Devs.business.responses.subTechnologies.GetByIdSubTechnologyResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlama.io.Devs.entities.concretes.Language;
import kodlama.io.Devs.entities.concretes.SubTechnology;

public class SubTechnologyManager implements SubTechnologyService {
	
	SubTechnologyRepository subTechnologyRepository;
	LanguageRepository languageRepository;

	@Autowired
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository,
			LanguageRepository languageRepository) {
		super();
		this.subTechnologyRepository = subTechnologyRepository;
		this.subTechnologyRepository = subTechnologyRepository;
	}

	private boolean isNameEmpty(String name) {
		if (name == null || name.isEmpty() || name.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean isSubTechnologyExisting(String subTechnologyName) {
		List<SubTechnology> technologies = subTechnologyRepository.findAll();
		for (SubTechnology technology : technologies) {
			if (technology.getName().equals(subTechnologyName)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public List<GetAllSubTechnologyResponse> getAll() {
		List<SubTechnology> technologies = subTechnologyRepository.findAll();
		List<GetAllSubTechnologyResponse> getAllSubTechnologiesResponses = new ArrayList<GetAllSubTechnologyResponse>();

		for (SubTechnology technology : technologies) {
			GetAllSubTechnologyResponse response = new GetAllSubTechnologyResponse();
			response.setId(technology.getId());
			response.setName(technology.getName());
			response.setLanguageName(technology.getLanguage().getName());
			getAllSubTechnologiesResponses.add(response);
		}
		return getAllSubTechnologiesResponses;
	}

	@Override
	public GetByIdSubTechnologyResponse getById(FindByIdSubTechnologyRequest findByIdSubTechnologiRequest) {
		GetByIdSubTechnologyResponse response=new GetByIdSubTechnologyResponse();
		SubTechnology technology = subTechnologyRepository.findById(findByIdSubTechnologiRequest.getId()).get();
		response.setId(technology.getId());
		response.setName(technology.getName());
		response.setLanguage(technology.getLanguage().getName());
		return response;
	}

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {
		if (!isNameEmpty(createSubTechnologyRequest.getName())
				&& !isNameEmpty(createSubTechnologyRequest.getLanguageName())
				&& !isSubTechnologyExisting(createSubTechnologyRequest.getName())) {
			SubTechnology subTechnology = new SubTechnology();
			subTechnology.setName(createSubTechnologyRequest.getName());

			List<Language> languages = languageRepository.findAll();

			Language language = new Language();

			for (Language language1:languages) {
				if (language1.getName().equals(createSubTechnologyRequest.getLanguageName())) {
					language= language1;
					break;
				}
			}
			if (language != null) {
				SubTechnology technology = new SubTechnology();
				technology.setName(createSubTechnologyRequest.getName());
				technology.setLanguage(language);
				subTechnologyRepository.save(technology);
			}
		}
		
	}

	@Override
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
		SubTechnology subTechnology = subTechnologyRepository.findById(deleteSubTechnologyRequest.getId()).get();
		subTechnologyRepository.delete(subTechnology);
		
	}

	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		if (!isNameEmpty(updateSubTechnologyRequest.getNewName())
				&& !isSubTechnologyExisting(updateSubTechnologyRequest.getNewName())) {
			SubTechnology technology = subTechnologyRepository.findById(updateSubTechnologyRequest.getId()).get();
			technology.setName(updateSubTechnologyRequest.getNewName());
			subTechnologyRepository.save(technology);
		}
		
	}

}
