package com.wzn.unicodejpa.config;

import com.wzn.unicodejpa.model.Unicode;
import com.wzn.unicodejpa.repository.UnicodeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component //
public class InitialData {


    private final UnicodeRepository unicodeRepository;

    public InitialData(UnicodeRepository unicodeRepository) {
        this.unicodeRepository = unicodeRepository;
    }

    @PostConstruct
    public void init() {
        Set<Character> unicodeChars = new HashSet<>();

        // Tilføjer chars til Set-listen fra BMP Basic Multilingual Plane (0x0000 til 0xFFFF)
        for (int i = 0; i <= 0xFFFF; i++) {
            char c = (char) i;
            unicodeChars.add(c);
        }


        // Gemmer characters fra Set-listen til databasen.
        // (Bemærk kontrol i Unidecode-Entity klassen linje 35.)
        for (Character c : unicodeChars) {
            // Kontrol af om unicode char'en allerede eksisterer i db
            if (!unicodeRepository.existsByUnicodeValue((int) c)) {
                Unicode unicode = new Unicode();
                unicode.setUnicodeValue((int) c);
                unicode.setBogstav(c);
                unicode.setDescription("Description for " + c);
                unicode.setName("Name for " + c);
                unicodeRepository.save(unicode);
            }
        }
    }
}

