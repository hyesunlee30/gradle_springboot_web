package gradle.spring.service;

import gradle.spring.domain.Member;
import gradle.spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach () {
        memoryMemberRepository.storeClear();
    }

    @Test
    void join() {
        // given
            Member member = new Member();
            member.setName("spring");
        // when
        Long saveId = memberService.join(member);
        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예외 () {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () ->memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail("예외가 발생해야 합니다");
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.11");
//        }
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}