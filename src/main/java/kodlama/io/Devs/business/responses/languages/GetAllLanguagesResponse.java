package kodlama.io.Devs.business.responses.languages;

import java.util.List;

import kodlama.io.Devs.business.responses.subTechnologies.GetSubTechnologyResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllLanguagesResponse {
	private int id;
	private String name;
	List<GetSubTechnologyResponse> technologies;
}
