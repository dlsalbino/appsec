package br.com.azusah.appsec.http.payloads;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HeroResponse {

    private Long id;
    private String name;
    private String company;
}
