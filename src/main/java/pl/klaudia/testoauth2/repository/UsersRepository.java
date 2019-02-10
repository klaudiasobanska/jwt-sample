package pl.klaudia.testoauth2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.klaudia.testoauth2.model.AUser;


import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<AUser, Long > {

    List<AUser> findAll();

    AUser findByUsername(String username);

    @Query(value = "SELECT nextval('user_id_seq')", nativeQuery =
            true)
    Long getNextSeriesId();


}
