package com.prueba_tecnica.libreria.domain.book;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Gender {
    @JsonProperty("fiction")
    FICTION,

    @JsonProperty("no fiction")
    NON_FICTION,

    @JsonProperty("mistery")
    MYSTERY,

    @JsonProperty("fantasy")
    FANTASY,

    @JsonProperty("science fiction")
    SCIENCE_FICTION,

    @JsonProperty("biography")
    BIOGRAPHY,

    @JsonProperty("history")
    HISTORY,

    @JsonProperty("romance")
    ROMANCE,

    @JsonProperty("thriller")
    THRILLER,

    @JsonProperty("horror")
    HORROR,

    @JsonProperty("poetry")
    POETRY,

    @JsonProperty("adventure")
    ADVENTURE,

    @JsonProperty("drama")
    DRAMA,

    @JsonProperty("clasic")
    CLASSIC
}
