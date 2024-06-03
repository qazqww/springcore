package raptarior.springcore;

import raptarior.springcore.member.Grade;
import raptarior.springcore.member.Member;
import raptarior.springcore.member.MemberService;
import raptarior.springcore.member.MemberServiceImpl;
import raptarior.springcore.order.Order;
import raptarior.springcore.order.OrderService;
import raptarior.springcore.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
