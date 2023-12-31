/*
 * Copyright (c) 2023 - present Florian Sauer
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.acme.verlag.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.ISBN;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Daten eines Buches für die Anwendungslogik und zum Abspeichern in der Datenbank.
 */
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@SuppressWarnings({"RequireEmptyLineBeforeBlockTagGroup", "ClassFanOutComplexity"})
public class Buch {

    /**
     * Konstante für die maximale Länge eines Haupttitels.
     */
    public static final int SIZE_MAX_HAUPTTITEL = 100;

    /**
     * Konstante für die minimale Länge eines Haupttitels.
     */
    public static final int SIZE_MIN_HAUPTTITEL = 1;

    /**
     * Konstante für die maximale Länge eines Nebentitels.
     */
    public static final int SIZE_MAX_NEBENTITEL = 100;

    /**
     * Die UUID des Buches.
     */
    @EqualsAndHashCode.Include
    private UUID id;

    /**
     * Die ISBN-13 des Buches.
     */
    @EqualsAndHashCode.Include
    @ISBN
    private String isbn13;

    /**
     * Der Haupttitel des Buches.
     */
    @Size(min = SIZE_MIN_HAUPTTITEL, max = SIZE_MAX_HAUPTTITEL)
    @NotBlank
    private String haupttitel;

    /**
     * Der Nebentitel des Buches.
     */
    @Size(max = SIZE_MAX_NEBENTITEL)
    @NotNull
    private String nebentitel;

    /**
     * Das Erscheinungsdatum des Buches.
     */
    @PastOrPresent
    @NotNull
    private LocalDate erscheinungsdatum;

    /**
     * Die Auflage des Buches.
     */
    @Positive
    private int auflage;

    /**
     * Der Preis des Buches.
     */
    @Valid
    @NotNull
    private Preis preis;

    /**
     * Die thematische Kategorie des Buches.
     */
    @NotNull
    private KategorieType kategorie;

    /**
     * Die Seitenzahl des Buches.
     */
    @Positive
    private int seitenzahl;
}
