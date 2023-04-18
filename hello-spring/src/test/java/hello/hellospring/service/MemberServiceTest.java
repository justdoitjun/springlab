package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class MemberServiceTest {

    MemberService memberservice = new MemberService();
    MemoryMemberRepository memberRepository;
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberservice = new MemberService(memberRepository);
    }
    @Test
    void join() {
        //given(데이터)
        Member member = new Member();
        member.setName("hello");
        //when(이 조건으로)
        Long saveId = memberservice.join(member);
        //then(결과)
        Member findMembers = memberservice.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMembers.getName());
    }

    @Test
    void 중복회원예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberservice.join(member1);
        try{
            memberservice.join(member2);
            fail();
        }catch(IllegalStateException e){
            assertThat((e.getMessage()).isEqualTo("이미 존재하는 멤버입니다"));
        }

        //then

    }

    @Test
    void findOne() {
    }
}