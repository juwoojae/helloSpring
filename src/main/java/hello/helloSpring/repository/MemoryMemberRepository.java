package hello.helloSpring.repository;

import hello.helloSpring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//Repository 데이터를 저장을 함   의 구현체

public class MemoryMemberRepository implements Memberrepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {   //멤버를 store에 저장하는 메서드
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {    //id 로 Member 객체 찾기
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {    //Name 으로 Member 객체 찾기
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
