package coid.bcaf.bebootcamp.repository;

//import coid.bcaf.BootcampTANew.entity.CustomerEntity;
import coid.bcaf.bebootcamp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {


    @Query(value = "SELECT no_box as noBox, COUNT(0) as jml FROM [db_user].[customer] AND approved != 0 Group By no_box", nativeQuery = true)
    List<Customer> masterBox();

    @Query(value = "SELECT * FROM db_user.customer WHERE no_box = :noBox", nativeQuery = true)
    List<Customer> findAllByNoBox(@Param("noBox") String noBox);

     @Query("SELECT c FROM Customer c WHERE c.noBox = :noBox")
    Customer findByNoBox(@Param("noBox") String noBox);

}
