package raptarior.springcore;

import raptarior.springcore.discount.FixDiscountPolicy;
import raptarior.springcore.discount.RateDiscountPolicy;
import raptarior.springcore.member.MemberService;
import raptarior.springcore.member.MemberServiceImpl;
import raptarior.springcore.member.MemoryMemberRepository;
import raptarior.springcore.order.OrderService;
import raptarior.springcore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }
}
