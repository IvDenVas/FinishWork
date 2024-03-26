package ru.gb.FinishWork.service.impl;

import org.junit.jupiter.api.Test;
import ru.gb.FinishWork.model.Note;
import ru.gb.FinishWork.repository.NoteRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NoteServiceImplementsUnitTest {

    @Test
    public void newNoteTest(){
        NoteRepo noteRepo = mock(NoteRepo.class);
        NoteServiceImplements noteServiceImplements = new NoteServiceImplements(noteRepo);
        Note note = new Note(1L,"1","1", LocalDateTime.now(), 1L);

        when(noteRepo.save(note)).thenReturn(note);

        assertEquals(note,noteServiceImplements.newNote(note));
    }

    @Test
    public void getAllNotesTest(){
        NoteRepo noteRepo = mock(NoteRepo.class);
        NoteServiceImplements noteServiceImplements = new NoteServiceImplements(noteRepo);

        Note note1 = new Note(1L,"1","1", LocalDateTime.now(), 1L);
        Note note2 = new Note(2L,"2","2", LocalDateTime.now(), 2L);
        Note note3 = new Note(3L,"3","3", LocalDateTime.now(), 3L);

        when(noteRepo.findAll()).thenReturn(List.of(note1,note2,note3));

        List<Note> result = noteServiceImplements.getAllNotes();

        assertEquals(3,result.size());
        assertEquals(note1,noteServiceImplements.getAllNotes().get(0));
        assertEquals(note2,noteServiceImplements.getAllNotes().get(1));
        assertEquals(note3,noteServiceImplements.getAllNotes().get(2));
        assertNotEquals(4,result.size());
    }

    @Test
    public void getNoteByIdTest(){
        NoteRepo noteRepo = mock(NoteRepo.class);
        NoteServiceImplements noteServiceImplements = new NoteServiceImplements(noteRepo);
        Note note = new Note(123L,"Test","Des",LocalDateTime.now(), 1L);

        when(noteRepo.findById(123L)).thenReturn(Optional.of(note));
        assertEquals(note,noteServiceImplements.getNoteById(123L));
        verify(noteRepo).findById(123L);
    }

    @Test
    public void updateNoteTest(){
        NoteRepo noteRepo = mock(NoteRepo.class);
        NoteServiceImplements noteServiceImplements = new NoteServiceImplements(noteRepo);
        Long id = 1L;
        Note note = new Note(id, "1", "1", LocalDateTime.now(), 1L);
        Note updatedNote = new Note(id, "2", "2", LocalDateTime.now(), 2L);

        when(noteRepo.findById(id)).thenReturn(Optional.of(note));
        when(noteRepo.save(note)).thenReturn(note);

        Note result = noteServiceImplements.updateNote(id, updatedNote);

        assertEquals(updatedNote.getTitle(), result.getTitle());
        assertEquals(updatedNote.getDescription(), result.getDescription());
        assertEquals(updatedNote.getDateTime(), result.getDateTime());
    }

    @Test
    void getAllNotesByIdUserTest(){
        NoteRepo noteRepo = mock(NoteRepo.class);
        NoteServiceImplements noteServiceImplements = new NoteServiceImplements(noteRepo);
        Note note = new Note(123L,"Test","Des",LocalDateTime.now(), 1L);
        Note note1 = new Note(124L,"Test1","Des1",LocalDateTime.now(), 1L);
        List<Note> noteList = new ArrayList<>();
        noteList.add(note);
        noteList.add(note1);

        when(noteRepo.findAllByIdUser(1L)).thenReturn(noteList);
        assertEquals(noteList, noteServiceImplements.getAllNotesByIdUser(1L));
    }
}