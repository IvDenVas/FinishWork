package ru.gb.FinishWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.FinishWork.model.Note;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
    List<Note> findAllByIdUser(Long aLong);
    void deleteAllByIdUser(Long aLong);
}