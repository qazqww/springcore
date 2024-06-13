package raptarior.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import raptarior.springcore.discount.DiscountPolicy;
import raptarior.springcore.discount.FixDiscountPolicy;
import raptarior.springcore.discount.RateDiscountPolicy;
import raptarior.springcore.member.MemberRepository;
import raptarior.springcore.member.MemberService;
import raptarior.springcore.member.MemberServiceImpl;
import raptarior.springcore.member.MemoryMemberRepository;
import raptarior.springcore.order.OrderService;
import raptarior.springcore.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
