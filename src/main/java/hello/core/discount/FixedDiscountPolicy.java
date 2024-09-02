package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixedDiscountPolicy implements DiscountPolicy {

    private int discountFixedAmount = 1;

    @Override
    public int discount(Member member, int price) {
        return (member.getGrade() == Grade.VIP) ? discountFixedAmount : 0;
    }
}
