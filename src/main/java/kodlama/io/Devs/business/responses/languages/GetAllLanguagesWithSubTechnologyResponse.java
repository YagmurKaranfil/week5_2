package kodlama.io.Devs.business.responses.languages;

import java.util.List;

import kodlama.io.Devs.business.responses.subTechnologies.GetSubTechnologyResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguagesWithSubTechnologyResponse {

	private int id;
	private String name;
	List<GetSubTechnologyResponse> subTechnologies;
}
