package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.security.SuperDuperDriveToken;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    private NoteService noteService;

    public HomeController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public String getHomePage(Model model, Authentication authentication) {
        //check if user logged in
        if (authentication != null) {
            SuperDuperDriveToken token = (SuperDuperDriveToken) authentication;

            //get note list
            List<Note> noteList = noteService.getNoteListByUserId(token.getUserId());
            model.addAttribute("noteList", noteList);

            return "home";
        } else {
            return "login";
        }
    }
}
