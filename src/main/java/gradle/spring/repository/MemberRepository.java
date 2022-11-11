package gradle.spring.repository;

import gradle.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findeById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
