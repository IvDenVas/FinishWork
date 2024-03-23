package ru.gb.FinishWork.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ru.gb.FinishWork.aspect.TrackUserAction;
import ru.gb.FinishWork.model.Note;
import ru.gb.FinishWork.model.User;
import ru.gb.FinishWork.repository.NoteRepo;
import ru.gb.FinishWork.service.NoteService;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteServiceImplements implements NoteService {

    private NoteRepo noteRepo;

    @Override
    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }


    @Override
    public Note getNoteById(Long id) {
        return noteRepo.findById(id).get();
    }

    @TrackUserAction
    @Override
    public Note updateNote(Long id, Note note) {
        Note updateNote = noteRepo.findById(id).get();
        updateNote.setId(note.getId());
        updateNote.setTitle(note.getTitle());
        updateNote.setDescription(note.getDescription());
        updateNote.setDateTime(note.getDateTime());
        updateNote.setIdUser(note.getIdUser());
        return noteRepo.save(updateNote);
    }

    @TrackUserAction
    @Override
    public Note newNote(Note note) {
        return noteRepo.save(note);
    }

    @TrackUserAction
    @Override
    public void deleteNoteById(Long id) {
        Note note = getNoteById(id);
        noteRepo.delete(note);
    }

    public void deleteAllNoteByIdUser(Long id) {
        noteRepo.deleteAllByIdUser(id);
    }

    public List<Note> getAllNotesByIdUser(Long aLong) {
        return noteRepo.findAllByIdUser(aLong);
    }

    public void updateNoteFromAdmin(Long id, Note note) {
        Note updateNote = noteRepo.findById(id).get();
        updateNote.setDescription(note.getDescription());
        noteRepo.updateNote(updateNote.getDescription(), note.getId());
    }


}