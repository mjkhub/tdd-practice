package jay.tdd_practice;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public List<Member> findAllMembers(){
        return em.createQuery("select user from Member user", Member.class)
                .getResultList();
    }
}
