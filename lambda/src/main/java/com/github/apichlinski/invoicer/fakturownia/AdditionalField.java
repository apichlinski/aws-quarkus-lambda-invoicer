package com.github.apichlinski.invoicer.fakturownia;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
class AdditionalField {
    @JsonProperty("gtu_codes")
    private List<GtuCode> gtuCodes;
}
