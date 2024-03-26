package ru.gb.FinishWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.FinishWork.model.Note;
import java.util.List;


@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
    List<Note> findAllByIdUser(Long aLong);
    void deleteAllNotesByIdUser(Long aLong);
}