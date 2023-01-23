package com.example.springproject.repository;

import com.example.springproject.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("jahyun");

        repository.save(member);
        Member res = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(res);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("jahyun1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("jahyun2");
        repository.save(member2);

        Member res = repository.findByName("jahyun1").get();

        assertThat(res).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("jahyun1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("jahyun2");
        repository.save(member2);

        List<Member> res = repository.findAll();

        assertThat(res.size()).isEqualTo(2);
    }
}
