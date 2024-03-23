package ru.gb.FinishWork.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.gb.FinishWork.model.Note;
import ru.gb.FinishWork.model.User;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note updateNote(Long id, Note note);
    Note newNote(Note note);
    void deleteNoteById(Long id);
    void deleteAllNoteByIdUser(Long id);
//    User newUser(User user);

}