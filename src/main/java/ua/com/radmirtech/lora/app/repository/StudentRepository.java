package ua.com.radmirtech.lora.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.com.radmirtech.lora.app.entity.StudentEntity;

import java.util.List;


public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query("select a from StudentEntity a where a.mark >= 4")
    List<StudentEntity> findAllGood();

}
