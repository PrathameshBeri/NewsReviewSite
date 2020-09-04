package springfive.cms.domain.utilities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsAppException extends RuntimeException {

    String message;
    String details;
    String time;


}
