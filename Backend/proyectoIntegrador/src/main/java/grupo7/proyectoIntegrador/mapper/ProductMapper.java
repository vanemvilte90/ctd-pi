package grupo7.proyectoIntegrador.mapper;

import grupo7.proyectoIntegrador.dto.*;
import grupo7.proyectoIntegrador.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ProductMapper {

    /**
     * Instancia ModelMapper
     * Injection of Dependency
     */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Instancia FeatureMapper.
     */
    private final FeatureMapper featureMapper;

    /**
     * Instancia ImageMapper
     */
    private final ImageMapper imgMapper;

    /**
     * Instancia Policys Mapper
     */
    private final PolicyCancellationMapper policyCancellationMapper;
    private final PolicyHealthAndSecurityMapper policyHealthAndSecurityMapper;
    private final PolicyHouseRuleMapper policyHouseRuleMapper;

    public ProductMapper(ModelMapper modelMapper, FeatureMapper featureMapper, ImageMapper imgMapper, PolicyCancellationMapper policyCancellationMapper, PolicyHealthAndSecurityMapper policyHealthAndSecurityMapper, PolicyHouseRuleMapper policyHouseRuleMapper) {
        this.modelMapper = modelMapper;
        this.featureMapper = featureMapper;
        this.imgMapper = imgMapper;
        this.policyCancellationMapper = policyCancellationMapper;
        this.policyHealthAndSecurityMapper = policyHealthAndSecurityMapper;
        this.policyHouseRuleMapper = policyHouseRuleMapper;
    }

    /**
     * Entity ->  mapToDto
     */
    public ProductDto mapToDto(Product productEntity) {

        CategoryDto CategoryDto = modelMapper.map(productEntity.getCategory(), CategoryDto.class);
        CityDto cityDto = modelMapper.map(productEntity.getCity(), CityDto.class);
        List<ImageDto> imgDto = imgMapper.mapToListDto(productEntity.getImages());
        List<FeatureDto> featDto = featureMapper.mapToListDto(productEntity.getProductFeatures());
        List<PolicyCancellationDto> cancellationPolicy = policyCancellationMapper.mapToListDto(productEntity.getPolicyCancellation());
        List<PolicyHealthAndSecurityDto> healthSecurity = policyHealthAndSecurityMapper.mapToListDto(productEntity.getPolicyHealthAndSecurity());
        List<PolicyHouseRuleDto> houseRule = policyHouseRuleMapper.mapToListDto(productEntity.getPolicyHouseRules());

        log.info("*** productEntity {}", productEntity);

        ProductDto dto = modelMapper.map(productEntity, ProductDto.class);
        dto.setCategoryDto(CategoryDto);
        dto.setCityDto(cityDto);
        dto.setImagesDto(imgDto);
        dto.setFeatureDto(featDto);
        dto.setPolicyCancellationDto(cancellationPolicy);
        dto.setPolicyHealthSecurityDto(healthSecurity);
        dto.setPolicyHouseRulesDto(houseRule);

        log.info("*** productDto {}", dto);

        return dto;
    }

    /**
     * Dto -> mapToEntity
     */
    public Product mapToEntity(ProductDto productDto) {

        Category categoryEntity = modelMapper.map(productDto.getCategoryDto(), Category.class);
        City cityEntity = modelMapper.map(productDto.getCityDto(), City.class);
        List<Image> img = imgMapper.mapToListEntity(productDto.getImagesDto());
        List<Feature> feat = featureMapper.mapToListEntity(productDto.getFeatureDto());
        List<PolicyCancellation> cancellationPolicy = policyCancellationMapper.mapToListEntity(productDto.getPolicyCancellationDto());
        List<PolicyHealthAndSecurity> healthSecurity = policyHealthAndSecurityMapper.mapToListEntity(productDto.getPolicyHealthSecurityDto());
        List<PolicyHouseRule> houseRule = policyHouseRuleMapper.mapToListEntity(productDto.getPolicyHouseRulesDto());

        log.info("*** productDto Dto {}", productDto);

        Product entity = modelMapper.map(productDto, Product.class);
        entity.setCategory(categoryEntity);
        entity.setCity(cityEntity);
        entity.setImages(img);
        entity.setProductFeatures(feat);
        entity.setPolicyCancellation(cancellationPolicy);
        entity.setPolicyHealthAndSecurity(healthSecurity);
        entity.setPolicyHouseRules(houseRule);

        log.info("*** Product Entity {}", entity);

        return entity;
    }


    /**
     * List Entity -> mapListDto
     */
    public List<ProductDto> mapToListDto(List<Product> listProductEntity) {
        log.info("List<ProductEntity>: {}", listProductEntity);

        List<ProductDto> listProductDto = listProductEntity
                .stream()
                .map(ProductEntity -> mapToDto(ProductEntity))
                .collect(Collectors.toList());

        log.info("List<PacienteDto>: {}", listProductDto);
        return listProductDto;
    }

    /**
     * List Entity -> mapListDto
     */
    public List<Product> mapToListEntity(List<ProductDto> listProductDto) {
        log.info("List<ProductDto>: {}", listProductDto);

        List<Product> listProductEntity = listProductDto
                .stream()
                .map(ProductDto -> mapToEntity(ProductDto))
                .collect(Collectors.toList());

        log.info("List<ProductEntity>: {}", listProductEntity);
        return listProductEntity;
    }

}
