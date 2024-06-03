package raptarior.springcore.order;

import raptarior.springcore.discount.DiscountPolicy;
import raptarior.springcore.discount.FixDiscountPolicy;
import raptarior.springcore.member.Member;
import raptarior.springcore.member.MemberRepository;
import raptarior.springcore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
