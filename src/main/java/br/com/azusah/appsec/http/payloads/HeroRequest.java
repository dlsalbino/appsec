package br.com.azusah.appsec.http.payloads;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class HeroRequest {

    @NotBlank(message = "The field 'name' must be filled in!")
    private String name;

    @NotBlank(message = "The field 'company' must be filled in!")
    private String company;
}
