package hello.hellospring.repository;

import hello.hellospring.domain.Member;
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
        //어떻게 했는지 기억이 안나지만 암튼..
    }

    @Test
    public void findByName(){
        Member member = new Member();
        member.setName("userName1");
        repository.save(member);

        Member result = repository.findByName("userName1").get();

       //(result).isEquals(member);

    }

    public void findAll(){
        List<Member> result = repository.findAll();
        //ass~~//
    }
}
