package dev.phoenixtype.security.repository;

import dev.phoenixtype.security.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JwtTokenRepository  extends JpaRepository<Token, Integer> {

    @Query("""
    select t from Token t inner join User u on t.user.id = u.id
    where u.id = :id and  (t.expired = false or t.revoked = false)
                    """)
    List<Token> findAllValidTokensByUser(Integer id);


    Optional<Token> findByToken(String token);
}
