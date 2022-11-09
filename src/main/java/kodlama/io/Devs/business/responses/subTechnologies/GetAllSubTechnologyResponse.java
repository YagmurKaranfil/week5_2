package kodlama.io.Devs.business.responses.subTechnologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllSubTechnologyResponse {

	private int id;
	private String name;
	private String languageName;
}
