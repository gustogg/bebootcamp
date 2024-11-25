package coid.bcaf.bebootcamp.repository;



import coid.bcaf.bebootcamp.model.Customer;
import coid.bcaf.bebootcamp.model.ListBox;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListBoxRepository extends JpaRepository<ListBox, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE db_user.list_box SET sampled = :sampled WHERE no_box = :noBox", nativeQuery = true)
    void updateSampledByNoBox(@Param("noBox") String noBox, @Param("sampled") String sampled);


}