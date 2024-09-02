package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.service.MemberServiceImpl;
import hello.core.repository.MemberRepository;
import hello.core.service.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class ConfigurationSingletonTest {

    @Test
    void configurationTest() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
    }
}
