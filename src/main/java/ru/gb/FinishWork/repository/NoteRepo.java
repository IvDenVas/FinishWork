package ru.gb.FinishWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.gb.FinishWork.model.Note;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
    List<Note> findAllByIdUser(Long aLong);
    void deleteAllByIdUser(Long aLong);
    @Modifying
    @Query("update Note u set u.description = ?1 where u.id = ?2")
    void updateNote(String description, Long id);
}