package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.security.token.SuperDuperDriveToken;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/saveNote")
    public String saveNote(Model model, Note note, Authentication authentication) {
        SuperDuperDriveToken token = (SuperDuperDriveToken) authentication;

        note.setUserId(token.getUserId());
        if (note.getNoteId() == null) {
            //create note
            noteService.addNote(note);

        } else {
            //update note
            noteService.updateNote(note);
        }

        //get note list
        List<Note> noteList = noteService.getNoteListByUserId(token.getUserId());
        model.addAttribute("noteList", noteList);

        return "home";
    }

    @PostMapping("/deleteNote")
    public String deleteNote(Model model, Authentication authentication, Note note) {
        SuperDuperDriveToken token = (SuperDuperDriveToken) authentication;

        //delete note
        noteService.deleteNoteByNoteId(note.getNoteId());

        //get note list
        List<Note> noteList = noteService.getNoteListByUserId(token.getUserId());
        model.addAttribute("noteList", noteList);

        return "home";
    }
}
