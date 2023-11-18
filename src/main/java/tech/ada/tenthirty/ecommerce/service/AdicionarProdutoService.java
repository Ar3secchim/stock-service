package tech.ada.tenthirty.ecommerce.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.tenthirty.ecommerce.model.Item;
import tech.ada.tenthirty.ecommerce.payload.ItemRequest;
import tech.ada.tenthirty.ecommerce.payload.response.ItemResponse;
import tech.ada.tenthirty.ecommerce.repository.ItemRepository;


@Service
@RequiredArgsConstructor
public class AdicionarProdutoService {
    private final ItemRepository itemRepository;
    
    public ItemResponse execute(ItemRequest itemRequest){
        Item item = new Item();
        item.setSku(itemRequest.getSkuId());
        item.setQuantityStock(itemRequest.getQuantidade());
        item.setPrice(0.0);
        itemRepository.save(item);

        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setQuantidade(itemRequest.getQuantidade());
        itemResponse.setSkuId(itemRequest.getSkuId());
        return itemResponse;
    }
}
