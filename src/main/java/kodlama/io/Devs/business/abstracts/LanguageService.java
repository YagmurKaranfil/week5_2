package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.languages.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.languages.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.languages.FindByIdLanguageRequest;
import kodlama.io.Devs.business.requests.languages.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.languages.GetAllLanguagesResponse;
import kodlama.io.Devs.business.responses.languages.GetAllLanguagesWithSubTechnologyResponse;
import kodlama.io.Devs.business.responses.languages.GetByIdLanguagesResponse;

public interface LanguageService {
List<GetAllLanguagesResponse> getAll();
List<GetAllLanguagesWithSubTechnologyResponse> getAllLanguagesWithSubTechnologyResponses();
GetByIdLanguagesResponse getById(FindByIdLanguageRequest findByLanguageRequest);
void add(CreateLanguageRequest createLanguageRequest);
void delete(DeleteLanguageRequest deletLanguageRequest);
void update(UpdateLanguageRequest updateLanguageRequest);
}
