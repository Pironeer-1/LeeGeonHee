package com.pironeer._th.member.repository;

import com.pironeer._th.member.entity.Member;
import io.jsonwebtoken.lang.Assert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemberRepository {

    private final AtomicLong memberIdxGenerator = new AtomicLong(0);
    private final Map<Long , Member> memberMap = new HashMap<>();

    public Member save(Member member) {
        System.out.println("회원 저장 메서드 호출됨");
        if (member.getId() == null) {
            Long id = memberIdxGenerator.incrementAndGet();
            member.setId(id);
            memberMap.put(id, member);
            System.out.println("회원 저장 후 memberMap 상태: " + memberMap);
            return member;
        } else {
            memberMap.replace(member.getId(), member);
            return member;
        }
    }

    public Optional<Member> findById(Long id) {
        Assert.notNull(id, "ID MUST NOT BE NULL");
        return Optional.ofNullable(memberMap.get(id));
    }


    public Optional<Member> findByMemberId(String memberId) {
        return memberMap.values().stream()
                .filter(data -> data.getMemberId().equals(memberId))
                .findAny();
    }

    public Boolean existByMemberId(String memberId) {
        return memberMap.values().stream()
                .anyMatch(data -> data.getMemberId().equals(memberId));
    }
}
