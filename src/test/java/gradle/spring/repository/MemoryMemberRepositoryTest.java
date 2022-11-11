package gradle.spring.repository;

import gradle.spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach () {
        repository.storeClear();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("hyesun");
        repository.save(member);

        Member result = repository.findeById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("hyeyeon");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("hyeran");
        repository.save(member2);

        Member result = repository.findByName("hyeyeon").get();

        assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findByAll() {
        Member member1 = new Member();
        member1.setName("test1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }

}
