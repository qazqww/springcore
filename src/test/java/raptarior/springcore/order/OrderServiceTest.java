package raptarior.springcore.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import raptarior.springcore.member.Grade;
import raptarior.springcore.member.Member;
import raptarior.springcore.member.MemberService;
import raptarior.springcore.member.MemberServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertEquals(order.getDiscountPrice(), 1000);
    }
}
