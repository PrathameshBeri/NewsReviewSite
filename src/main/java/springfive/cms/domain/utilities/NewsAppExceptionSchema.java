package springfive.cms.domain.utilities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsAppExceptionSchema {

    String message;
    String details;
    String time;



}
