package kodlama.io.Devs.business.responses.languages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdLanguagesResponse {
	private int id;
	private String name;

}
