package com.example.baseb.authentication.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    @Query("select m from Member m join fetch m.authorities")
    Optional<Member> getMemberWithAuthorities(String id);
}
