package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.PriceTagDTO;
import kz.datcom.pricetag.mapper.PriceTagMapper;
import kz.datcom.pricetag.model.BaseStation;
import kz.datcom.pricetag.model.PriceTag;
import kz.datcom.pricetag.repository.BaseStationRepository;
import kz.datcom.pricetag.repository.PriceTagRepository;
import kz.datcom.pricetag.service.integration.ZkongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PriceTagServiceImpl implements PriceTagService {

    @Autowired
    PriceTagRepository priceTagRepository;

    @Autowired
    BaseStationRepository stationRepository;

    private PriceTagMapper priceTagMapper = new PriceTagMapper();

    @Override
    public PriceTagDTO addPriceTag(PriceTagDTO tagDTO) {
        tagDTO.setStatus("NOT BIND");
        PriceTag priceTag = priceTagRepository.save(priceTagMapper.toEntity(tagDTO));
        return priceTagMapper.toDTO(priceTag);
    }

    @Override
    public PriceTagDTO editPriceTag(PriceTagDTO tag) {
        return null;
    }

    @Override
    public PriceTagDTO getPriceTag(Long id) {
        Optional<PriceTag> priceTag = priceTagRepository.findById(id);
        return priceTagMapper.toDTO(priceTag.get());
    }

    @Override
    public List<PriceTagDTO> tagByBaseStation(Long stationId) {
        BaseStation station = stationRepository.getOne(stationId);
        List<PriceTag> priceTags = priceTagRepository.findAllByBaseStation(station);
        return priceTagMapper.toDTO(priceTags);
    }

    @Override
    public List<PriceTagDTO> tagList() {
        List<PriceTag> priceTags = priceTagRepository.findAll();
        return priceTagMapper.toDTO(priceTags);
    }

    @Override
    public Void deleteTag(Long id) {
        return null;
    }
}
