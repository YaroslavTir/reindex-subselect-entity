package com.yaroslavtir;

import com.yaroslavtir.entity.FirstEntity;
import com.yaroslavtir.entity.SecondEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TestService {

    private final MainService mainService;

    @EventListener
    public void test(ContextRefreshedEvent ctxStartEvt)  {
        mainService.create(
                new SecondEntity(1L, "old name")
        );
        mainService.create(
                new FirstEntity(1L, new SecondEntity(1L, "old name"))
        );
        mainService.updateSecond(1L, "new name");
    }


}
