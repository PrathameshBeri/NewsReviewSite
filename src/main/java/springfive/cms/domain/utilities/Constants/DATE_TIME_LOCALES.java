package springfive.cms.domain.utilities.Constants;


import lombok.Data;


public enum DATE_TIME_LOCALES {

    INDIA("Asia/Calcutta");

    String region;

    DATE_TIME_LOCALES(String region){

        this.region = region;
    }


}
