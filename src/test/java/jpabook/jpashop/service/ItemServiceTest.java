package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class ItemServiceTest {

    @Autowired ItemService itemService;
    @Autowired EntityManager em;
    @Autowired ItemRepository itemRepository;

    @Test
    public void 상품생성() throws Exception{
        //given
        Item item = new Item();
        item.setName("itemA");

        //when
        Long savedItemId = itemService.saveItem(item);
        System.out.println(item.getId());
        //then

        assertThat(itemRepository.findOne(savedItemId)).isEqualTo(item);
    }
}