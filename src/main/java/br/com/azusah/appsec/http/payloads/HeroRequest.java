package br.com.azusah.appsec.http.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroRequest {
    private String name;
    private String company;
}
