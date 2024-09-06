package com.wzn.unicodejpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unicode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int unicodeValue;

    /*
        Mysql default var latin1, men hver række sættes nu til at kunne tage utf8
        ved brug af "SET utf8 COLLATE utf8_general_ci"
     */
    @Column(columnDefinition = "CHAR(1) CHARACTER SET utf8 COLLATE utf8_general_ci", nullable = false)
    private char bogstav;

    @Column(length = 255, columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String description;

    @Column(length = 255, columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String name;

    public void setBogstav(char bogstav) {
        if (!isValidUtf8Char(bogstav)) {
            throw new IllegalArgumentException("Character not supported by MySQL utf8: " + bogstav);
        }
        this.bogstav = bogstav;
    }

    private boolean isValidUtf8Char(char c) {
        return c <= 0xFFFF; // Godtager kun BMP
    }
}

