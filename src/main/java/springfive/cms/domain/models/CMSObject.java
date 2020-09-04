package springfive.cms.domain.models;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;


public class CMSObject {

    @Column
    LocalDateTime creationDate;

    @Column
    LocalDateTime modificationDate;

}
