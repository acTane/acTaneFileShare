package com.sg.ferguson.llamaparty.controllers;

import com.sg.ferguson.llamaparty.models.Guest;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LlamaController {

    ArrayList<Guest> guests = new ArrayList<>();

    @GetMapping("/PartyApp")
    public String homePage() {
        return "partyApp";
    }

    @GetMapping("/PartyApp/RSVP")
    public String rsvpPage() {
        return "RSVP";
    }

    @PostMapping("/PartyApp/RSVP")
    public String rsvpSubmitPage(Guest guest, Model model) {
        //nulls
        if (guest.getGuestName().isBlank()) {
            return "seriously";
        } else if (guest.isConfirmed()) {
            int numLlamas = 0;
            guests.add(guest);
            for (Guest g : guests) {
                numLlamas += g.getLlamas();
            }
            String responseP = "Did you know there will be " + numLlamas
                    + " total Llamas, and " + numLlamas / guests.size() + " per person at my Party!";
            model.addAttribute("guests", guests);
            model.addAttribute("banner", "Hurrah!");
            model.addAttribute("subtitle", "So excited you are coming");
            model.addAttribute("responseP", responseP);
            model.addAttribute("postLink", "to rsvp someone else!");
            return "rsvpResult";
        } else {
            return "rsvpResultNoTable";
        }

    }

    @GetMapping
    public String rsvpResult() {
        return "";
    }
}
