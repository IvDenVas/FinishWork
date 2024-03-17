package ru.gb.FinishWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.FinishWork.model.Note;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
}