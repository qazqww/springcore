package raptarior.springcore;

import raptarior.springcore.discount.DiscountPolicy;
import raptarior.springcore.discount.FixDiscountPolicy;
import raptarior.springcore.discount.RateDiscountPolicy;
import raptarior.springcore.member.MemberRepository;
import raptarior.springcore.member.MemberService;
import raptarior.springcore.member.MemberServiceImpl;
import raptarior.springcore.member.MemoryMemberRepository;
import raptarior.springcore.order.OrderService;
import raptarior.springcore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
