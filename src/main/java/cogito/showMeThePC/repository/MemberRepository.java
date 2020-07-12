package cogito.showMeThePC.repository;

import cogito.showMeThePC.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }//save() end

    public Member findOne(Long id){
        return em.find(Member.class,id);
    }//findOne() end

    public List<Member> findOneByEmail(String email){
        return em.createQuery("select m from Member m where m.email = :email")
                .setParameter("email",email)
                .getResultList();
    }//findOneById() end

}
