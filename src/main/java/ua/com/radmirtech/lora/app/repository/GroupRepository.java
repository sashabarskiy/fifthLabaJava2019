package ua.com.radmirtech.lora.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.radmirtech.lora.app.entity.GroupEntity;

import java.util.List;


public interface GroupRepository extends JpaRepository<GroupEntity, Long> {



    @Query("select a from GroupEntity a where a.name = :name")
    List<GroupEntity> findByName(@Param("name") String name);

}
