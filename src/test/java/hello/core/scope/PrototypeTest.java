package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    public void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);

        ProtoTypeBean prototypeBean1 = ac.getBean(ProtoTypeBean.class);
        ProtoTypeBean prototypeBean2 = ac.getBean(ProtoTypeBean.class);

        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
        ac.close();
    }

    @Scope("prototype")
    static class ProtoTypeBean {

        @PostConstruct
        public void init() {
            System.out.println("Prototype.init");
        }

        /**
         * Prototype scope does not call destroy method
         */
        @PreDestroy
        public void destroy() {
            System.out.println("Prototype");
        }

    }
}
