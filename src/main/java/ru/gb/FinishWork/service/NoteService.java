package ru.gb.FinishWork.service;

import ru.gb.FinishWork.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note updateNote(Long id, Note note);
    Note newNote(Note note);
    void deleteNoteById(Long id);
    void deleteAllNoteByIdUser(Long id);
}