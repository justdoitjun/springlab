package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository rep = new MemoryMemberRepository();
    @AfterEach
    public void afterEach(){
        rep.clearStore();
    }       //매우 중요함.
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        rep.save(member);
     //   rep.findById(member.getId());
        Member result = rep.findById(member.getId()).get();
        // 검증을 하는 방법 : Assertions.assertThat(
        //왜 이렇게 하냐?  매번 System.out.println을 할 수 엇기 때문임.
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        rep.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        rep.save(member2);

        Optional<Member> result = Optional.of(rep.findByName("spring1").get());
        assertThat(result).isEqualTo(member1);
    }
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        rep.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        rep.save(member2);

        List<Member> result = rep.findAll();
        assertThat(result.size()).isEqualTo(3);
     }
}
