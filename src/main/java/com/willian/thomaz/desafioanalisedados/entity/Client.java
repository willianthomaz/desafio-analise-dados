package com.willian.thomaz.desafioanalisedados.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {

    private Long id;
    private Long cnpj;
    private String name;
    private String businessArea;
}
