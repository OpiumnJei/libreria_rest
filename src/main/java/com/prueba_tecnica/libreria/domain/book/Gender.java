package com.prueba_tecnica.libreria.domain.book;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Gender {
    @JsonProperty("fiction")
    FICTION,

    @JsonProperty("no fiction")
    NON_FICTION,

    MYSTERY,
    FANTASY,
    SCIENCE_FICTION,
    BIOGRAPHY,
    HISTORY,
    ROMANCE,
    THRILLER,
    HORROR,

    @JsonProperty("poetry")
    POETRY,
    ADVENTURE,
    DRAMA,
    CLASSIC
}
