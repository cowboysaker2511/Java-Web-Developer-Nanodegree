package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.entity.Note;
import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    public List<Note> getNoteListByUserId(int userId) {
        return noteMapper.getNoteListByUserId(userId);
    }

    public void addNote(Note note) {
        noteMapper.addNote(note.getNoteTitle(), note.getNoteDescription(), note.getUserId());
    }

    public void saveNote(Note note) {
        noteMapper.saveNote(note.getNoteId(), note.getNoteTitle(), note.getNoteDescription(), note.getUserId());
    }

    public void deleteNoteByNoteId(Integer noteId) {
        noteMapper.deleteNoteByNoteId(noteId);
    }
}
