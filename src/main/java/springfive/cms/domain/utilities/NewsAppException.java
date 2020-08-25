package springfive.cms.domain.utilities;


import lombok.Data;

@Data
public class NewsAppException extends RuntimeException {

    String message;
    String details;
    String time;


}
