package com.wzn.unicodejpa.controller;

import com.wzn.unicodejpa.repository.UnicodeRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unicode")
public class UnicodeController {


    private final UnicodeRepository unicodeRepository;

    public UnicodeController(UnicodeRepository unicodeRepository) {
        this.unicodeRepository = unicodeRepository;
    }

    @GetMapping("/{i}")
    public String getUnicodeChar(@PathVariable int i) {
        char c = (char) i;
        return "unicode = " + i + "  char = " + c;
    }

    @GetMapping("/char/{c}")
    public String getUnicodeFromChar(@PathVariable char c) {
        int unicode = (int) c;
        return "char = " + c + "  unicode = " + unicode;
    }

    @GetMapping("/generate/{bogstav}/{antal}")
    public String generateLetters(@PathVariable char bogstav, @PathVariable int antal) {
        String result = "";

        for (int i = 0; i < antal; i++) {
            result += (char) (bogstav + i);
        }

        return result;
    }
}
