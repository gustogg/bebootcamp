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
    @Query(value = "UPDATE db_user.list_box SET sampled = :sampled, approved = :approved WHERE no_box = :noBox", nativeQuery = true)
    void updateSampledByNoBox(@Param("noBox") String noBox, @Param("sampled") String sampled,  @Param("approved") String approved);

    @Query(value = "SELECT * FROM db_user.list_box WHERE sampled = 1 AND approved = 0", nativeQuery = true)
    List<ListBox> findUnapprovedListBoxes();

}