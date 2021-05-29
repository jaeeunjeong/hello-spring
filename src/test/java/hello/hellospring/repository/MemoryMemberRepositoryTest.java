package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("userId");

        repository.save(member);

        Member result = repository.findById((member.getId())).get();
        Assertions.assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName(){
        Member member = new Member();
        member.setName("userName1");
        repository.save(member);

        Member result = repository.findByName("userName1").get();

        Assertions.assertThat(result).isEqualTo(member);

    }

    @Test
    public void findAll(){
        //given
        Member member1 = new Member();
        member1.setName("user1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("user2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
