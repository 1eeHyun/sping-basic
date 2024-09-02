package hello.core.autowired;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

class AllBeanTest {

    /**
     * DiscountPolicyConfig is needed
     */
//    @Test
//    void findAllBean() {
//
//        ApplicationContext ac = new AnnotationConfigApplicationContext(DiscountPolicyConfig.class,
//                                                                        DiscountService.class);
//
//        DiscountService discountService = ac.getBean(DiscountService.class);
//        Member member = new Member(1L, "userA", Grade.VIP);
//        int fixedDiscountPrice = discountService.discount(member, 10, "fixedDiscountPolicy");
//
//        assertThat(discountService).isInstanceOf(DiscountService.class);
//        assertThat(fixedDiscountPrice).isEqualTo(1);
//
//        int rateDiscountPrice = discountService.discount(member, 20, "rateDiscountPolicy");
//        assertThat(discountService).isInstanceOf(DiscountService.class);
//        assertThat(rateDiscountPrice).isEqualTo(2);
//    }

    @RequiredArgsConstructor
    static class DiscountService {

        // Add avery discountPolicy to map key(name of policy) value(policy instance)
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy>policies;

        public int discount(Member member, int price, String discountCode) {

            // Get what discountPolicy the client picked
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }
    
    
}
