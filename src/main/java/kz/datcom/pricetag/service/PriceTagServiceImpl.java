package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.PriceTagDTO;
import kz.datcom.pricetag.mapper.PriceTagMapper;
import kz.datcom.pricetag.model.PriceTag;
import kz.datcom.pricetag.repository.PriceTagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PriceTagServiceImpl implements PriceTagService {

    @Autowired
    PriceTagRepository priceTagRepository;

    private final PriceTagMapper priceTagMapper;

    @Override
    public PriceTagDTO addPriceTag(PriceTagDTO tagDTO) {

        PriceTag priceTag = priceTagRepository.save(priceTagMapper.toEntity(tagDTO));
        return priceTagMapper.toDTO(priceTag);
    }

    @Override
    public PriceTagDTO editPriceTag(PriceTagDTO tag) {
        return null;
    }

    @Override
    public PriceTagDTO getPriceTag(ObjectId id) {
        PriceTag priceTag = priceTagRepository.findById(id);
        return priceTagMapper.toDTO(priceTag);
    }

    @Override
    public List<PriceTagDTO> tagList(ObjectId storeId) {
        List<PriceTag> priceTags = priceTagRepository.findByStoreId(storeId);
        return priceTagMapper.toDTO(priceTags);
    }

    @Override
    public Void deleteTag(ObjectId id) {
        return null;
    }
}
