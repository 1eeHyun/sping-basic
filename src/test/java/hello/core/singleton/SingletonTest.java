package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonTest {

    @Test
    @DisplayName("Pure DI Container; without Spring")
    void pureContainer() {

        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        // memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("Use object that's applied singleton pattern")
    void singletonServiceTest() {

        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        // instance1 == instance2
        assertThat(instance1).isSameAs(instance2);
    }

    /**
     * Spring container solved problems of singleton
     * Beans are singleton by default
     */
    @Test
    @DisplayName("Spring container and singleton")
    void springContainer() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // memberService1 == memberService2
        assertThat(memberService1).isSameAs(memberService2);
    }
}
