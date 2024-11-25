package coid.bcaf.bebootcamp.repository;



import coid.bcaf.bebootcamp.model.ListBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListBoxRepository extends JpaRepository<ListBox, Long> {
}
