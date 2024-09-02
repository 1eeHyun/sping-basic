package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("Should be applied 10% discount")
    void vip_o() {

        Member member = new Member(1L, "memberVIP", Grade.VIP);

        int discount = discountPolicy.discount(member, 10);

        assertThat(discount).isEqualTo(1);
    }

    @Test
    @DisplayName("Should not be applied 10% discount")
    void vip_x() {

        Member member = new Member(1L, "memberNormal", Grade.NORMAL);

        int discount = discountPolicy.discount(member, 10);

        assertThat(discount).isEqualTo(0);
    }
}
