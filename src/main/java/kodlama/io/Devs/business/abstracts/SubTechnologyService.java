package kodlama.io.Devs.business.abstracts;

import java.util.List;



import kodlama.io.Devs.business.requests.subTechnology.CreateSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.DeleteSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.FindByIdSubTechnologyRequest;
import kodlama.io.Devs.business.requests.subTechnology.UpdateSubTechnologyRequest;
import kodlama.io.Devs.business.responses.subTechnologies.GetAllSubTechnologyResponse;
import kodlama.io.Devs.business.responses.subTechnologies.GetByIdSubTechnologyResponse;


public interface SubTechnologyService {
List<GetAllSubTechnologyResponse> getAll();
GetByIdSubTechnologyResponse getById(FindByIdSubTechnologyRequest findByIdSubTechnologiRequest);
void add(CreateSubTechnologyRequest createSubTechnologyRequest);
void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest);
void update(UpdateSubTechnologyRequest updateSubTechnologyRequest);
}
